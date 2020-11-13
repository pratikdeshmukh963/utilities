### **This is a utility to generate Microsoft Excel or Google Sheets concatenate formula.**

This can be useful when you want to generate build SQL queries for inserting/updating/deleting records.

Consider an example table structure below.
| COLUMN_1 | COLUMN_2 | COLUMN_3 |
| -------- | -------- | -------- |
| value_1  | value_2  | value_3  |
| value_4  | value_5  | value_6  |
\
If we want to create an insert/update statement using this table structure with COLUMN_X being column names of a table and values are the values we want to insert/update.
We can do this simply by running the **“ExcelConcatFormulaGenerator.class”** file using the below command.

```java
java ExcelConcatFormulaGenerator noOfCoumns //In our case this will be 3
```
\
Once you run the above code you will get output something like this : 
`$A$1,"=","'",A2,"'",",",$B$1,"=","'",B2,"'",",",$C$1,"=","'",C2,"'"`
\
\
You can use this output in a concatenate formula to get output as shown below.
COLUMN_1|COLUMN_2|COLUMN_3|Concatenate output|
|---|---|---|---|
value_1|value_2|value_3|COLUMN_1='value_1',COLUMN_2='value_2',COLUMN_3='value_3'|
value_4|value_5|value_6|COLUMN_1='value_4',COLUMN_2='value_5',COLUMN_3='value_6|
