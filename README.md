# The SQL++ query language for Asterix

Notice: this document is using a variant of Markdown called Github Flavored Markdown (GFM), which allows fancy features such as syntax coloring. To be able to view this document properly, please either go to the [github page for the project](https://github.com/jtestard/asterixdb-sqlpp) or use Eclipse's [GFM viewer](https://github.com/satyagraha/gfm_viewer).

Generate SQL++ and AQL syntax trees for identical (semantically, maybe not syntactically) query and compare differences.

## Introduction

This document is intended as a reference guide to the full syntax and semantics of the SQL++ Query Language for Asterix (Asterix SQL++). This document describes how the SQL++ query language is interpreted in the context of AsterixDB. Details for the SQL++ query language being developed at UCSD can be found [here](http://forward.ucsd.edu/sqlpp.html).

It is important to note that while we are using the SQL++ query language, we are keeping the Asterix Data Model. As such, there will be some differences between the language presented here and the standard "UCSD" SQL++ [1]. These differences will be clearly highlighted when they occur and will be kept at a minimum.

This description only addresses expressions for the moment. Unsupported expressions are currently greyed out.
Note that this description contains left-recursion, while the parser used for SQL++ is LL(k). Therefore rules appearing in the parser may differ from this document.

## Expressions
```python
SQLPPQuery ::= SQLPPExpression
```    
A SQL++ query can be any legal SQL++ expression.

```python
SQLPPExpression ::=     SFWExpression
                |       SQLPPOperatorExpr
#                |       SQLPPQuantifiedExpression
```

The `SQLPPQuantifiedExpression` expression specification will be deferred to a later date, given that existential/universal quantification is not fully supported in the SQL++ implementation as of this moment (in particular the `IN, EXISTS, ANY, ALL` keywords from the SQL++ language are not yet supported).

### SQL++ Operator Expression

```python
SQLPPOperatorExpr   ::= SQLPPAndExpr ( "or" SQLPPAndExpr )*
SQLPPAndExpr        ::= SQLPPRelExpr ( "and" SQLPPRelExpr )*
SQLPPRelExpr        ::= SQLPPAddExpr ( ( "<" | ">" | "<=" | 
                    ">=" | "=" | "!=" | "~=" ) SQLPPAddExpr )?
SQLPPAddExpr        ::= SQLPPMultExpr ( ( "+" | "-" ) SQLPPMultExpr )*
SQLPPMultExpr       ::= SQLPPUnaryExpr ( ( "*" | "/" | "%" |
                        "^"| "idiv" ) SQLPPUnaryExpr )*
SQLPPUnaryExpr      ::= ( ( "+" | "-" ) )? SQLPPValueExpr
```

The operator expression structure is inherited from AQL.

#### SQL++ PathStep

```python
SQLPPValueExpr ::= SQLPPPrimaryExpr (SQLPPathstep)*
SQLPPPathstep   ::= "." SQLPPIdentifier
                |   "[" SQLPPValueExpr "]"
                |   "->" SQLPPValueExpr
```

#### SQL++ Value Expression

```python
    SQLPPPrimaryExpr ::=   SQLPPValue
                     |     SQLPPParenthesizedExpression
                     |     SQLPPVariableRef
                     |     SQLPPNamedValue
                     |     SQLPPFunctionCallExpr
#                    |     SQLPPColumnReference
```
                    
#### SQL++ Values (includes literals)

```python
SQLPPValue          ::= SQLPPDefinedValue
                    |    "missing"
SQLPPDefinedValue    ::= SQLPPScalarValue
                    |    SQLPPComplexValue
SQLPPComplexValue    ::= SQLPPTupleValue
                    |    SQLPPBagValue
                    |    SQLPPArrayValue
                    |    SQLPPMapValue
SQLPPScalarValue    ::= SQLPPPrimitveValue
                    |    SQLPPEnrichedValue
SQLPPPrimitveValue  ::= SQLPPStringValue
                    |    SQLPPNumberValue
                    |    "true"
                    |    "false"
                    |    "null"
SQLPPNumberValue    ::= SQLPPIntegerValue
                    |   SQLPPFloatValue
                    |   SQLPPDoubleValue
SQLPPEnrichedValue  ::= SQLPPIdentifier "(" SQLPPPrimitiveValue 
                    ( "," SQLPPPrimitiveValue ) ? ")"
SQLPPTupleValue     ::= "{" ( SQLPPFieldBinding ( "," SQLPPFieldBinding )* )?  "}"
SQLPPBagValue       ::= "{{" ( SQLPPOperatorExpr ( "," SQLPPOperatorExpr )* )?  "}}"
SQLPPArrayValue     ::= "[" ( SQLPPOperatorExpr ( "," SQLPPOperatorExpr )* )?  "]"
SQLPPMapValue       ::= "map" "(" (SQLPPValue ":" SQLPPDefinedValue 
                        ( "," SQLPPValue ":" SQLPPDefinedValue )* )? ")"
SQLPPFieldBinding   ::= SQLPPStringValue ":" SQLPPOperatorExpr
```
    
This section is inspired by the SQL++ Value BNF presented in [1]. However, some features from the BNF are not included. For example,
the `id::` field for defined values is absent from this specification. In order to map more closely to AQL primitives, the number value is subdivided further to its AQL equivalents. Primitive values imported from AQL are appended with a `*`.

#### SQL++ Parenthesized Expression

```python
SQLPPParenthesizedExpression ::= "(" SFWExpression ")"
```

Notice that SQL++ does not have the "I am lucky" array navigation AQL has (the "?" in array navigation).            

#### SQL++ Named Value

```python
SQLPPNamedValue ::= SQLPPIdentifier
```

#### SQL++ Function Call Expression

```python
SQLPPFunctionCallExpr     ::= "(" SQLPPExpression ( "," SQLPPExpression ) ? ")"
```

In AQL, the symbols `"<" | ">" | "<=" | ">=" | "=" | "!=" | "~=" | "+" | "-" | "*" | "%" | "/" ` are treated as special operators while in SQL++ they are treated as functions. We chose to keep the AQL format.

### SQL++ SFWExpression

```python
SQLPPSFWExpression ::=    "SELECT" SQLPPSelectClause
#                    |     "SELECT"  "DISTINCT" SQLPPSelectClause
                    |    "FROM" SQLPPFromClause
                    |    "WHERE" SQLPPOperatorExpr
#                    |    "GROUPBY" SQLPPGroupItem
#                    |    "HAVING" SQLPPOperatorExpr
#                    |    ("UNION" | "INTERSECT" | "EXCEPT") ["ALL"] SQLPPSFWExpression
#                    |    "ORDER BY" SQLPPOrderItem
#                    |    "LIMIT" SQLPPOperatorExpr
#                    |    "OFFSET" SQLPPOperatorExpr
```

#### SQL++ Select Clause

```python
SQLPPSelectClause   ::= SQLPPSelectItem (, SQLPPSelectItem)*
#                    |   "TUPLE" SQLPPSelectItem
#                    |    "ELEMENT" SQLPPOperatorExpr
SQLPPSelectItem     ::= SQLPPValueExpr [ "AS" SQLPPAlias ]
                    |   SQLPPWildCard
SQLPPAlias          ::= SQLPPIdentifier
SQLPPWildCard       ::= "*"
```

#### SQL++ From Clause

```python
SQLPPFromClause         ::= SQLPPFromItem ( "," SQLPPFromItem)*
SQLPPFromItem           ::= SQLPPFromSingle
                        |    SQLPPFromJoin
#                        |    SQLPPFromFlatten
SQLPPFromSingle         ::=     SQLPPValueExpression "AS" SQLPPVariableRef # ["AT" SQLPPOperatorExpr ]
SQLPPFromJoin           ::=     SQLPPFromInnerJoin
#                       |       SQLPPFromOuterJoin
SQLPPFromInnerJoin      ::= SQLPPFromItem "JOIN" SQLPPFromItem "ON" SQLPPOperatorExpr
SQLPPFromOuterJoin      ::= ( "LEFT" | "RIGHT" | "FULL" ) 
                            "JOIN" SQLPPFromItem "ON" SQLPPOperatorExpr
# SQLPPFromFlatten      ::= SQLPPFromInFlatten
#                       |   SQLPPFromOutFlatten
# SQLPPFromInFlatten    ::= "FLATTEN" "("
#                           SQLPPOpertorExpr "AS" SQLPPVariableRef ","
#                           SQLPPOpertorExpr "AS" SQLPPVariableRef ")"
# SQLPPFromOutFlatten   ::= "FLATTEN" "("
#                           SQLPPOpertorExpr "AS" SQLPPVariableRef ","
#                           SQLPPOpertorExpr "AS" SQLPPVariableRef ")"
SQLPPVariableRef        ::= SQLPPIdentifier
```

#### SQL++ GROUP BY Clause

```python
# SQLPPGroupItem        ::= SQLPPOperatorExpr [ "AS" VariableRef* ]
```

#### SQL++ ORDER BY Clause

```python
# SQLPPOrderByItem    ::= SQLPPOperatorExpr [ "ASC" | "DESC" ]
```

## SQL++ Configuration Parameters

UCSD SQL++ configuration parameters are implicitely defined in Asterix SQL++, and cannot be modified. They have been set to Asterix default behaviour.

## SQLPP to AQL Mappings

```python
    SQLPPStringValue      =>        StringLiteral
    SQLPPIntegerValue     =>        IntegerLiteral
    SQLPPFloatValue       =>        FloatLiteral
    SQLPPDoubleValue      =>        DoubleLiteral
    SQLPPTupleValue         =>        RecordConstructor
    SQLPPArrayValue         =>        OrderedListConstructor
    SQLPPBagValue           =>        UnorderedListConstructor
    SQLPPIdentifier         =>        Identifier
    SQLPPVariableRef        =>        VariableRef
    SQLPPNamedValue         =>        QualifiedName
```

This is tentative corresponding of SQL++ tokens to AQL tokens.