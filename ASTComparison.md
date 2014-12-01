### AQL vs SQL++ AST comparison

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
  "@type":"edu.uci.ics.asterix.sqlpp.statement.SQLPPQuery",
  "body":{
    "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPSFWExpression",
    "clauses":[
      {
        "@type":"edu.uci.ics.asterix.sqlpp.clause.SelectClause",
        "items":[
          {
            "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPSelectItemExpression",
            "alias":null,
            "expression":{
              "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPTupleAccess",
              "ident":{
                "identifier":"alias"
              },
              "expr":{
                "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPNamedValueExpression",
                "name":{
                  "identifier":"FB"
                }
              }
            }
          }
        ]
      },
      {
        "@type":"edu.uci.ics.asterix.sqlpp.clause.FromClause",
        "items":[
          {
            "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPFromSingle",
            "alias":{
              "variable":{
                "identifier":"FB"
              }
            },
            "expression":{
              "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPNamedValueExpression",
              "name":{
                "identifier":"FacebookUsers"
              }
            }
          }
        ]
      },
      {
        "@type":"edu.uci.ics.asterix.sqlpp.clause.WhereClause",
        "expression":{
          "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPOperatorExpr",
          "expressions":[
            {
              "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPTupleAccess",
              "ident":{
                "identifier":"id"
              },
              "expr":{
                "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPNamedValueExpression",
                "name":{
                  "identifier":"FB"
                }
              }
            },
            {
              "@type":"edu.uci.ics.asterix.sqlpp.expression.SQLPPValueExpression",
              "value":{
                "@type":"edu.uci.ics.asterix.sqlpp.value.IntegerValue",
                "value":8
              }
            }
          ],
          "operators":[
            {
              "@type":"edu.uci.ics.asterix.sqlpp.expression.OperatorType",
              "name":"EQ",
              "ordinal":6
            }
          ]
        }
      }
    ]
  }
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