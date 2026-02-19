# Excel Reader project

### Zadání

V programovacím jazyce Java s využitím Mavenu vytvořte program, který bude spouštěný z příkazové řádky.
Jako jediný vstupní parametr bude mít zadaný datovy soubor.
Program vypíše všechna prvočisla nalezená v datovém souboru (jeden řadek vystupu = jedno nalezené prvočíslo) v pořadí, v jakém se v souboru vyskytují.
Pro výstup bude použit Logger.
Je možné používat jakékoli volně dostupné knihovny.

Dbejte prosím na kvalitní návrh řešení - strukturu kódu, modularitu, čitelnost, ošetření chyb, výběr vhodných nástrojů ...
Navrhněte program tak, aby byl otevřený modifikacím - možné změně vstupu, zpracování prvočísel a výstupu.
Použijte prosím nové vlastnosti jazyka Java, které jsou pro řešení vhodné.

Program by měl obsahovat JUnit testy funkcionality.

Vystup včetně zdrojových kódů prosím nahrát na github (případně zaslat zip se zdrojovými soubory).

Popis datového souboru:
Datovy soubor je ve formatu Excel 2007-2013 (xlsx).
Data jsou v prvním listu ve sloupci B.
Validní data jsou pouze kladná cela čísla, nevalidní data by měl program ignorovat.
Malý VZOREK dat je přílohou zadaní, jedna se opravdu o vzorek, finalni data mohou byt jina!
Může jich být více a větší (i více než 64 bitů), s vlivem na celkový výkon výpočtu.

Pokud se uchazeč rozhodne tuto úlohu vypracovat, je nutné, aby ji vypracoval samostatně bez pomoci jiných osob, GPT a obdobných AI nástrojů. Použití internetu je povoleno. Pokud při vypracování úlohy máte nejasnosti a nemáte dostatek informací, dotazy formulujte. Následně si na dotazy navrhněte odpověď a podle toho úlohu vypracujte. Dotazy a odpovědi prosím přiložte k vypracované úloze.

### Test excel file
|   | A | B | C        |
| ------------- | ------------- | ------------- |----------|
| 1 | 13 | 154 | =C2+C4   |
| 2 | -4 | 154,14 | -4       |
| 3 | 154,14 | 3 | 21,14    |
| 4 | text A4 | TRUE | 17       |
| 5 | 22 | -122 | text C5  |
| 6 | 7 | 22 | TRUE     |
| 7 | TRUE | -7 | 11       |
| 8 | =A5+A6 | =B6+B7 | FALSE    |
| 9 | FALSE | text B9 | 54       |
| 10 | text A10 | 13 | 47       |
| 11 | 11 | FALSE | text C11 |
### Optional run arguments
run example : java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-2 ct-2 rf-1 rt-9
* er : type of excel reader 
* l : file location 
* cf: column index from
* ct: column index to
* rf: row index from
* rt: row index to

- cf-2 ct-2: column with index 2 will be taken only
- rf-2 rt-9: rows with index >=2 and <= 9  will be taken only

Column and row arguments are optional. If no column/row limitations all sheet cells will be taken.

### excel reader options - specify which cell type options will be looked up
* er-a: all types
* er-n: numeric
* er-pn:prime numeric (default option if no "er-" argument)
* er-b: boolean
* er-s: String
* er-f: formulas

### Test file
Test files can be stored in main/resorces

### Run examples and results

* excel reader type argument not set - used default "pn"   <br />
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9   <br />
  args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9]   <br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=pn}   <br />
  MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]   <br />
  values=[3, 13]   <br />

* er-n - ExcelNumericReader   <br />
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-n   <br />
  args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-n]   <br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=n}   <br />
  MyExcelReader-ExcelNumericReader : values=[154.14, 3, -122, 22, -7, 13]   <br />
  values=[154.14, 3, -122, 22, -7, 13]   <br />
 
* er-pn - ExcelPrimeNumericReader   <br />
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-pn    <br />
  args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-pn]   <br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=pn}   <br />
  MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]   <br />
  values=[3, 13]   <br />

* er-s - ExcelStringReader   <br />
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-s    <br />
  args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-s]   <br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=s}   <br />
  MyExcelReader-ExcelStringReader : values=[text B9]   <br />
  values=[text B9]   <br />

* er-b - ExcelBooleanReader   <br />
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-b    <br />
  args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-b]   <br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=b}   <br />
  MyExcelReader-ExcelBooleanReader : values=[true]   <br />
  values=[true]   <br />

* er-f - ExcelFormulaReader   <br />
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-f    <br />
  args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-f]   <br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=f}   <br />
  MyExcelReader-ExcelFormulaReader : values=[B6+B7]   <br />
  values=[B6+B7]   <br />

* er-a - used all excel reader types   <br />
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-a   <br />
  args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-a]   <br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=a}   <br />
  MyExcelReader-ExcelNumericReader : values=[154.14, 3, -122, 22, -7, 13]   <br />
  MyExcelReader-ExcelPrimeNumericReader : values=[3, 13]   <br />
  MyExcelReader-ExcelStringReader : values=[text B9]   <br />
  MyExcelReader-ExcelBooleanReader : values=[true]   <br />
  MyExcelReader-ExcelFormulaReader : values=[B6+B7]   <br />
  values=[154.14, 3, -122, 22, -7, 13, 3, 13, text B9, true, B6+B7]   <br />

* arguments not set - all sheet cells checked, used default excel reader type "pn"   <br />
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx   <br />
  args=[l-TestData.xlsx]   <br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=0, columnTo=-1, rowFrom=0, rowTo=-1, excelReaderType=pn}   <br />
  MyExcelReader-ExcelPrimeNumericReader : values=[13, 3, 17, 7, 11, 13, 47, 11]   <br />
  values=[13, 3, 17, 7, 11, 13, 47, 11]   <br />

* use absolute path
####  java -jar SpringExcelReader-1.0.0.jar l-C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx  cf-2 ct-2 rf-1 rt-9<br />
  args=[l-C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx, cf-2, ct-2, rf-1, rt-9]<br />
  readerArgs=ReaderArguments{location='C:\Users\roman\Work\pohovor\projects\java\excelReader\SpringExcelReader\src\main\resources\TestData.xlsx', columnFrom=2, columnTo=2, rowFrom=1, rowTo=9, excelReaderType=pn}<br />
  MyExcelReader-ExcelPrimeNumericReader : values=[17, 11, 47]<br />
  values=[17, 11, 47]   <br />

* use excel info reader - info
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9 er-i<br />
  args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9, er-i]<br />
  readerArgs=ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9, excelReaderType=i}<br />
  MyExcelReader-ExcelInfoReader<br />
  Info <br />
  ExcellCellInfo = {type=NUMERIC, rowIndex=1, columnIndex=1, value='154.14'} <br />
  ExcellCellInfo = {type=NUMERIC, rowIndex=2, columnIndex=1, value='3'} <br />
  ExcellCellInfo = {type=BOOLEAN, rowIndex=3, columnIndex=1, value='true'} <br />
  ExcellCellInfo = {type=NUMERIC, rowIndex=4, columnIndex=1, value='-122'} <br />
  ExcellCellInfo = {type=NUMERIC, rowIndex=5, columnIndex=1, value='22'} <br />
  ExcellCellInfo = {type=NUMERIC, rowIndex=6, columnIndex=1, value='-7'} <br />
  ExcellCellInfo = {type=FORMULA, rowIndex=7, columnIndex=1, value='B6+B7'} <br />
  ExcellCellInfo = {type=STRING, rowIndex=8, columnIndex=1, value='text B9'} <br />
  ExcellCellInfo = {type=NUMERIC, rowIndex=9, columnIndex=1, value='13'} <br />

* use excel info reader - table
####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-2 rf-3 rt-6 er-t  <br />
  args=[l-TestData.xlsx, cf-1, ct-2, rf-3, rt-6, er-t] <br />
  MyExcelReader-ExcelInfoReader  <br />
         Table      <br />

|   | B    | C   |
|---|------|-----|
| 3 | true | 17 |
| 4 | -122 | text A5 |
| 5 | 22   | true |
| 6 | 17   | 11  |


####  java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx er-t                    
args=[l-TestData.xlsx, er-t]  <br />
MyExcelReader-ExcelInfoReader  <br />
Table      <br />

|   | A | B | C        |
| ------------- | ------------- | ------------- |----------|
| 1 | 13 | 154 | =C2+C4   |
| 2 | -4 | 154,14 | -4       |
| 3 | 154,14 | 3 | 21,14    |
| 4 | text A4 | TRUE | 17       |
| 5 | 22 | -122 | text C5  |
| 6 | 7 | 22 | TRUE     |
| 7 | TRUE | -7 | 11       |
| 8 | =A5+A6 | =B6+B7 | FALSE    |
| 9 | FALSE | text B9 | 54       |
| 10 | text A10 | 13 | 47       |
| 11 | 11 | FALSE | text C11 |