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



#### SQL++ Type Names

SQL++ does not provide a mechanism to identify a type, while AQL does. It seems like this would be a useful feature for an implementation of the SQL++ language.

We propose to introduce a type naming. The same way there can be a *named value*, we introduce the concept of a *named type*. We can evaluate later if such addition makes sense outside of the AQL context later.

#### SQL++ Named Values

Given SQL++ *named values*

#### SQL++ Select Clause

Note sure whether `SQLPPSelectItem    ::= SQLPPOperatorExpr [ "AS" {{Identifier}}* ]` is correct. Other candidates include `VariableRef`, `QualifiedName` and more.
