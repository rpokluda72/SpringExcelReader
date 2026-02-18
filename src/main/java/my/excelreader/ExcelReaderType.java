package my.excelreader;

/**
 * er-a: all types
 * er-n: numeric
 * er-pn:prime numeric
 * er-b: boolean
 * er-s: String
 * er-f: formulas
 */
public enum ExcelReaderType {
    ALL_TYPES_READER("a"),
    NUMERIC_READER("n"),
    PRIME_NUMERIC_READER("pn"),
    BOOLEAN_READER("b"),
    STRING_READER("s"),
    FORMULA_READER("f");

    private String type;

    ExcelReaderType(String t) {
        type = t;
    }

    public String getType() {
        return type;
    }
}
