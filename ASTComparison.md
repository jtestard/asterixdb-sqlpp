## AQL vs SQL++ AST comparison

### SFW query without join

Assume the Asterix Dataset `TinySocial` from the examples. Consider the queries :

1) AQL :
```
use dataverse TinySocial;
for $user in dataset FacebookUsers
where $user.id = 8
return $user.alias;
```
With AST: 

    FLWOGR [
        For Variable [ Name=$user Id=0 ]
            In 
            FunctionCall Metadata.dataset@1[
                LiteralExpr [STRING] [FacebookUsers] 
            ]
    Where 
    OperatorExpr [
      FieldAccessor [
        Variable [ Name=$user Id=0 ]
        Field=id
      ]
      EQ
      LiteralExpr [INTEGER] [8] 
    ]
    Return
        FieldAccessor [
            Variable [ Name=$user Id=0 ]
            Field=alias
        ]
    ]

2) SQL++:
```
SELECT FB.alias 
FROM FacebookUsers AS FB 
WHERE FB.id = 8
```
With AST :
```
{
  "query":[
    {
      "select":[
        {
          "expression":{
            "expression":"NamedValue(FB)",
            ".":"Ident(alias)"
          },
          "alias":"null"
        }
      ]
    },
    {
      "from":[
        {
          "expression":"NamedValue(FacebookUsers)",
          "alias":"Variable(FB)"
        }
      ]
    },
    {
      "where":[
        {
          "expression":"NamedValue(FB)",
          ".":"Ident(id)"
        },
        "EQ",
        8
      ]
    }
  ]
}
```

3) Asterix Logical Plan :

```
distribute result [%0->$$4] -- |UNPARTITIONED|
  project ([$$4]) -- |UNPARTITIONED|
    assign [$$4] <- [function-call: asterix:field-access-by-name, Args:[%0->$$0, AString: {alias}]] -- |UNPARTITIONED|
      select (function-call: algebricks:eq, Args:[function-call: asterix:field-access-by-name, Args:[%0->$$0, AString: {id}], AInt32: {8}]) -- |UNPARTITIONED|
        unnest $$0 <- function-call: asterix:dataset, Args:[AString: {FacebookUsers}] -- |UNPARTITIONED|
          empty-tuple-source -- |UNPARTITIONED|
```

### Left Outer Join Query

1) AQL :
```
use dataverse TinySocial;

for $user in dataset FacebookUsers
return {
"uname": $user.name,
"messages": for $message in dataset FacebookMessages
       where $message.author-id = $user.id
       return $message.message
};
```
with AST : 
```
FLWOGR [
  For Variable [ Name=$user Id=0 ]
    In 
    FunctionCall Metadata.dataset@1[
      LiteralExpr [STRING] [FacebookUsers] 
    ]
  Return
    RecordConstructor [
      (
        LiteralExpr [STRING] [uname] 
        :
        FieldAccessor [
          Variable [ Name=$user Id=0 ]
          Field=name
        ]
      )
      (
        LiteralExpr [STRING] [messages] 
        :
        FLWOGR [
          For Variable [ Name=$message Id=1 ]
            In 
            FunctionCall Metadata.dataset@1[
              LiteralExpr [STRING] [FacebookMessages] 
            ]
          Where 
            OperatorExpr [
              FieldAccessor [
                Variable [ Name=$message Id=1 ]
                Field=author-id
              ]
              EQ
              FieldAccessor [
                Variable [ Name=$user Id=0 ]
                Field=id
              ]
            ]
          Return
            FieldAccessor [
              Variable [ Name=$message Id=1 ]
              Field=message
            ]
        ]
      )
    ]
]
```
2) SQL++ :
```
SELECT FBU.name AS uname, FBM.message AS message
FROM FacebookUsers AS FBU
LEFT OUTER JOIN FacebookMessages AS FBM
ON FBU.id = FBM.author-id
```
with AST :
```
{
  "query":[
    {
      "select":[
        {
          "expression":{
            "expression":"NamedValue(FBU)",
            ".":"Ident(name)"
          },
          "alias":"Variable(uname)"
        },
        {
          "expression":{
            "expression":"NamedValue(FBM)",
            ".":"Ident(message)"
          },
          "alias":"Variable(message)"
        }
      ]
    },
    {
      "from":[
        {
          "type":"LEFT_OUTER",
          "left":{
            "expression":"NamedValue(FacebookUsers)",
            "alias":"Variable(FBU)"
          },
          "right":{
            "expression":"NamedValue(FacebookMessages)",
            "alias":"Variable(FBM)"
          },
          "condition":[
            {
              "expression":"NamedValue(FBU)",
              ".":"Ident(id)"
            },
            "EQ",
            {
              "expression":"NamedValue(FBM)",
              ".":"Ident(author-id)"
            }
          ]
        }
      ]
    }
  ]
}
```

3) Asterix Logical Plan :
```
distribute result [%0->$$3] -- |UNPARTITIONED|
  project ([$$3]) -- |UNPARTITIONED|
    assign [$$3] <- [function-call: asterix:open-record-constructor, Args:[AString: {uname}, function-call: asterix:field-access-by-name, Args:[%0->$$0, AString: {name}], AString: {messages}, %0->$$10]] -- |UNPARTITIONED|
      subplan {
                aggregate [$$10] <- [function-call: asterix:listify, Args:[%0->$$9]] -- |UNPARTITIONED|
                  assign [$$9] <- [function-call: asterix:field-access-by-name, Args:[%0->$$1, AString: {message}]] -- |UNPARTITIONED|
                    select (function-call: algebricks:eq, Args:[function-call: asterix:field-access-by-name, Args:[%0->$$1, AString: {author-id}], function-call: asterix:field-access-by-name, Args:[%0->$$0, AString: {id}]]) -- |UNPARTITIONED|
                      unnest $$1 <- function-call: asterix:dataset, Args:[AString: {FacebookMessages}] -- |UNPARTITIONED|
                        nested tuple source -- |UNPARTITIONED|
             } -- |UNPARTITIONED|
        unnest $$0 <- function-call: asterix:dataset, Args:[AString: {FacebookUsers}] -- |UNPARTITIONED|
          empty-tuple-source -- |UNPARTITIONED|
```