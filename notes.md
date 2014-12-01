#### SQL++ Type Names

SQL++ does not provide a mechanism to identify a type, while AQL does. It seems like this would be a useful feature for an implementation of the SQL++ language.

We propose to introduce a type naming. The same way there can be a *named value*, we introduce the concept of a *named type*. We can evaluate later if such addition makes sense outside of the AQL context later.

#### SQL++ Named Values

Given SQL++ *named values*

#### SQL++ Select Clause

Note sure whether `SQLPPSelectItem    ::= SQLPPOperatorExpr [ "AS" {{Identifier}}* ]` is correct. Other candidates include `VariableRef`, `QualifiedName` and more.