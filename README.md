# The SQL++ query language for Asterix

Notice: this document is using a variant of Markdown called Github Flavored Markdown (GFM), which allows fancy features such as syntax coloring. To be able to view this document properly, please either go to the [github page for the project](https://github.com/jtestard/asterixdb-) or use Eclipse's [GFM viewer](https://github.com/satyagraha/gfm_viewer).


## Introduction

This document is intended as a reference guide to the full syntax and semantics of the SQL++ Query Language for Asterix (Asterix SQL++). This document describes how the SQL++ query language is parsed in the context of AsterixDB. Details for the SQL++ query language being developed at UCSD can be found [here](http://forward.ucsd.edu/.html).

It is important to note that while we are using the SQL++ query language, we are keeping the Asterix Data Model. As such, there will be some differences between the language presented here and the SQL++ Reference Implementation [1]. These differences will be clearly highlighted when they occur and will be kept at a minimum.

Note that the SQL++ interface currently only offers query capabilities. To do any sort of data (or metadata) manipulation, the regular AQL interface must be used. The language is presented using a BNF form.

**Disclaimer** : This BNF is not final and will change when support for new types of operators is added.

## Expressions
```python
Query ::= Expression
```    
A SQL++ query can be any legal SQL++ expression.

```python
Expression ::=   SFWExpression
           |     OperatorExpression
```

The `QuantifiedExpression` expression specification will be deferred to a later date, given that existential/universal quantification is not fully supported in the SQL++ implementation as of this moment (in particular the `IN, EXISTS, ANY, ALL` keywords from the SQL++ language are not yet supported).

### SQL++ Query Expression

```python
OperatorExpression   ::= AndExpression ( "or" AndExpression )*
AndExpression        ::= RelExpression ( "and" RelExpression )*
RelExpression        ::= AddExpression ( ( "<" | ">" | "<=" | 
                         ">=" | "=" | "!=" | "~=" ) AddExpression )?
AddExpression        ::= MultExpression ( ( "+" | "-" ) MultExpression )*
MultExpression       ::= UnaryExpression ( ( "*" | "/" | "%" |
                         "^"| "idiv" ) UnaryExpression )*
UnaryExpression      ::= ( ( "+" | "-" ) )? ValueExpression
```

The operator expression structure is inherited from the AQL `OperatorExpression`.

#### SQL++ PathStep

```python
ValueExpression  ::= PrimaryExpression (pathstep)*
Pathstep         ::= "." Identifier
                 |   "[" Expression "]"
                 |   "->(" Expression ")"
```
Notice that SQL++ does not have the "I am lucky" array navigation AQL has (the "?" in array navigation).

#### SQL++ Value Expression

```python
PrimaryExpression ::=   Value
                  |     ParenthesizedExpression # Currently not supported
                  |     Variable
```
                    
#### SQL++ Literals

```python
Value           ::=  DefinedValue
                |    "missing"
DefinedValue    ::=  ScalarValue
                |    ComplexValue
ScalarValue     ::=  PrimitiveValue
                |    EnrichedValue
PrimitiveValue   ::=  StringValue
                |    NumberValue
                |    "true"
                |    "false"
                |    "null"
NumberValue    ::=   IntegerValue
                |    FloatValue
                |    DoubleValue
EnrichedValue  ::=   Identifier "(" PrimitiveValue 
                     ( "," PrimitiveValue ) ? ")"
```
    
This section is inspired by the SQL++ Value BNF presented in [1]. However, some features from the BNF are not included. For example :

 - the `id::` field for defined values is absent from this specification. 
 - In order to map more closely to AQL primitives, the number value is subdivided further to its AQL equivalents.

#### SQL++ Complex Values

```python
ComplexValue    ::=  TupleValue
                |    BagValue
                |    ArrayValue
                |    MapValue
TupleValue     ::=   "{" ( FieldBinding ( "," FieldBinding )* )?  "}"
BagValue       ::=   "{{" ( OperatorExpression ( "," OperatorExpression )* )?  "}}"
ArrayValue     ::=   "[" ( OperatorExpression ( "," OperatorExpression )* )?  "]"
MapValue       ::=   "map" "(" (Value ":" DefinedValue 
                     ( "," Value ":" DefinedValue )* )? ")" # not supported yet (ever)?
FieldBinding   ::=   OperatorExpression ":" OperatorExpression
```
Given that the Asterix Data Model does not contain maps, the usage of maps will be 
identified, but will also reported a "operation not supported" error.

#### SQL++ Parenthesized Expression

```python
ParenthesizedExpression ::= "(" SFWExpression ")"
```

#### SQL++ Named Value and variables

```python
DatasetExpression ::= Identifier
Variable   ::= Identifier
```

In a SQL++ query, it is not possible to distinguish a variable from a dataset expression without context. *Note that the concept of dataset expression replaces the named value expression existing in the SQL++ Reference Implementation.* (May need to verify)

### SQL++ SFWExpression

```python
SFWExpression ::=   "SELECT" SelectClause
              |     "SELECT"  "DISTINCT" SelectClause
              |    "FROM" FromClause
              |    "WHERE" OperatorExpr
              |    "GROUPBY" GroupItem # Not supported yet
              |    "HAVING" OperatorExpr # Not supported yet
              |    ("UNION" | "INTERSECT" | "EXCEPT") ["ALL"] SFWExpression # Not supported yet
              |    "ORDER BY" OrderItem # Not supported yet
              |    "LIMIT" OperatorExpr # Not supported yet
              |    "OFFSET" OperatorExpr # Not supported yet
```

#### SQL++ Select Clause

```python
SelectClause   ::= SelectItem (, SelectItem)*
                    |   "TUPLE" SelectItem
                    |   "ELEMENT" OperatorExpr
SelectItem     ::= ValueExpr [ "AS" Variable ]
                    |   WildCard

WildCard       ::= "*" # Not supported yet
```

#### SQL++ From Clause

```python
FromClause         ::= FromItem ( "," FromItem)*
FromItem           ::= FromSingle
                   |   FromJoin
                   |   FromFlatten
FromSingle         ::= FromElement "AS" Variable ["AT" OperatorExpr ] # AT not yet supported
FromJoin           ::= FromInnerJoin
                   |   FromOuterJoin
FromInnerJoin      ::= FromItem "JOIN" FromItem "ON" OperatorExpr
FromOuterJoin      ::= ( "LEFT" | "RIGHT" | "FULL" ) 
                       "JOIN" FromItem "ON" OperatorExpr
FromFlatten        ::= FromInFlatten # not supported
                   |   FromOutFlatten # not supported
FromInFlatten      ::= "FLATTEN" "("
                       OpertorExpr "AS" VariableRef ","
                       OpertorExpr "AS" VariableRef ")"
FromOutFlatten   ::=   "FLATTEN" "("
                       OpertorExpr "AS" VariableRef ","
                       OpertorExpr "AS" VariableRef ")"
VariableRef        ::= Identifier
FromElement        ::= DatasetExpression
                   |   ParenthesizedExpression # Currently not supported
```

#### SQL++ GROUP BY Clause

```python
GroupItem        ::= OperatorExpresion [ "AS" VariableRef* ]
```

#### SQL++ ORDER BY Clause

```python
OrderByItem    ::= OperatorExpression [ "ASC" | "DESC" ]
```

## Statements

```python
Statement       ::= ( SingleStatement ( ";" )? )* <EOF>
SingleStatement ::= DataverseDeclaration
                  | SQLPPQuery
```

For details about non-query statements, please refer to the guide found [here](https://asterixdb.ics.uci.edu/documentation/aql/manual.html).

## SQL++ Configuration Parameters

UCSD SQL++ configuration parameters are implicitely defined in Asterix SQL++, and cannot be modified. They have been set to Asterix default behaviour.