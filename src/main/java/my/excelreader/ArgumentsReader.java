package my.excelreader;

public class ArgumentsReader {
    public static final String DEFAULT_LOCATION = "MyData.xlsx";
    public final int DEFAULT_COLUMN_FROM = 0;
    public final int DEFAULT_COLUMN_TO = -1;
    public final int DEFAULT_ROW_FROM = 0;
    public final int DEFAULT_ROW_TO = -1;
    public final String LOCATION_ARG_PREFIX = "l-";
    public final String COLUMN_FROM_ARG_PREFIX = "cf-";
    public final String COLUMN_TO_ARG_PREFIX = "ct-";
    public final String ROW_FROM_ARG_PREFIX = "rf-";
    public final String ROW_TO_ARG_PREFIX = "rt-";

    private String location;
    private int columnFrom;
    private int columnTo;
    private int rowFrom;
    private int rowTo;

    public ArgumentsReader(String[] args) {
        setColumnFrom(getColumnFromArg(args));
        setColumnTo(getColumnToArg(args));
        setLocation(getLocationArg(args));
        setRowFrom(getRowFromArg(args));
        setRowTo(getRowToArg(args));
        System.out.println(this);
    }

    public boolean isLocationDefault(){
        return location.equals(DEFAULT_LOCATION);
    }

    public boolean isColumnDefault(){
        return columnFrom == DEFAULT_COLUMN_FROM && columnTo == DEFAULT_COLUMN_TO;
    }

    public boolean isRowDefault(){
        return rowFrom == DEFAULT_ROW_FROM && rowTo == DEFAULT_ROW_TO;
    }

    private String getLocationArg(String[] args) {
        for (String arg : args) {
            if (arg.startsWith(LOCATION_ARG_PREFIX)) {
                return arg.substring(LOCATION_ARG_PREFIX.length());
            }
        }
        return DEFAULT_LOCATION;
    }

    private int getColumnFromArg(String[] args) {
        for (String arg : args) {
            if (arg.startsWith(COLUMN_FROM_ARG_PREFIX)) {
                String colArgValue = arg.substring(COLUMN_FROM_ARG_PREFIX.length());
                try {
                    return Integer.parseInt(colArgValue);
                } catch (Exception e) {
                    return DEFAULT_COLUMN_FROM;
                }
            }
        }
        return DEFAULT_COLUMN_FROM;
    }

    private int getColumnToArg(String[] args) {
        for (String arg : args) {
            if (arg.startsWith(COLUMN_TO_ARG_PREFIX)) {
                String colArgValue = arg.substring(COLUMN_TO_ARG_PREFIX.length());
                try {
                    return Integer.parseInt(colArgValue);
                } catch (Exception e) {
                    return DEFAULT_COLUMN_TO;
                }
            }
        }
        return DEFAULT_COLUMN_TO;
    }

    private int getRowFromArg(String[] args) {
        for (String arg : args) {
            if (arg.startsWith(ROW_FROM_ARG_PREFIX)) {
                String argValue = arg.substring(ROW_FROM_ARG_PREFIX.length());
                try {
                    return Integer.parseInt(argValue);
                } catch (Exception e) {
                    return DEFAULT_ROW_FROM;
                }
            }
        }
        return DEFAULT_ROW_FROM;
    }


    private int getRowToArg(String[] args) {
        for (String arg : args) {
            if (arg.startsWith(ROW_TO_ARG_PREFIX)) {
                String argValue = arg.substring(ROW_TO_ARG_PREFIX.length());
                try {
                    return Integer.parseInt(argValue);
                } catch (Exception e) {
                    return DEFAULT_ROW_TO;
                }
            }
        }
        return DEFAULT_ROW_TO;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getColumnFrom() {
        return columnFrom;
    }

    public void setColumnFrom(int column) {
        this.columnFrom = column;
    }

    public int getColumnTo() {
        return columnTo;
    }

    public void setColumnTo(int column) {
        this.columnTo = column;
    }

    public int getRowFrom() {
        return rowFrom;
    }

    public void setRowFrom(int rowFrom) {
        this.rowFrom = rowFrom;
    }

    public int getRowTo() {
        return rowTo;
    }

    public void setRowTo(int rowTo) {
        this.rowTo = rowTo;
    }

    @Override
    public String toString() {
        return "ReaderArguments{" +
                "location='" + location + '\'' +
                ", columnFrom=" + columnFrom +
                ", columnTo=" + columnTo +
                ", rowFrom=" + rowFrom +
                ", rowTo=" + rowTo +
                '}';
    }
}
