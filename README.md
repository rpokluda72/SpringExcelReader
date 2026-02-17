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

### Run attributes

### Test excel file
|   | A | B | C |
| ------------- | ------------- | ------------- | ------------- |
| 1  | 13 | 154 | 154 |
| 1  | 13 | 154 | 154 |
| 2  | -4  | 3  | -4 |
| 3  | 154,14  | 154,14  | 154,14 |
| 4   | adad  | adad  | adad |
| 5  | 22  | 22  | 17 |
| 6  | 7  | -7  | 7 |
| 7  | 54  | 54  | 54 |
| 8  | fghfh  | fghfh  | fghfh |
| 9  | 11  | 11  | 11 |

### Optional run arguments
run example : l-TestData.xlsx cf-2 ct-2 rf-1 rt-9
l: file location 
cf: column index from
ct: column index to
rf: row index from
rt: row index to

cf-2 ct-2: column with index 2 will be taken only
rf-2 rt-9: rows with index >=2 and <= 9  will be taken only

Column and row arguments are optional. If no column/row limitations all sheet cells will be taken.

### Results
Test files can be stored in main/resorces

        // java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-2 ct-2 rf-1 rt-9
        // úno 17, 2026 12:51:12 ODP. my.excelreader.MyExcelReader log
        // INFO: args=[l-TestData.xlsx, cf-2, ct-2, rf-1, rt-9]
        // ReaderArguments{location='TestData.xlsx', columnFrom=2, columnTo=2, rowFrom=1, rowTo=9}
        // úno 17, 2026 12:51:13 ODP. my.excelreader.MyExcelReader log
        // INFO: primeNumbers=[17, 7, 11]

        // java -jar SpringExcelReader-1.0.0.jar l-TestData.xlsx cf-1 ct-1 rf-1 rt-9
        // úno 17, 2026 12:52:55 ODP. my.excelreader.MyExcelReader log
        // INFO: args=[l-TestData.xlsx, cf-1, ct-1, rf-1, rt-9]
        // ReaderArguments{location='TestData.xlsx', columnFrom=1, columnTo=1, rowFrom=1, rowTo=9}
        // úno 17, 2026 12:52:56 ODP. my.excelreader.MyExcelReader log
        // INFO: primeNumbers=[3, 11]