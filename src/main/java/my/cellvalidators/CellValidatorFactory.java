package my.cellvalidators;

import my.excelreader.ArgumentsReader;
import org.apache.poi.ss.usermodel.Cell;

import java.util.ArrayList;

public class CellValidatorFactory {
    ArrayList<CellValidator> validators = new ArrayList<>();

    public void setValidators(ArrayList<CellValidator> validators) {
        this.validators = validators;
    }

    public ArrayList<CellValidator> getValidators() {
        return validators;
    }

    public void addValidator(CellValidator validator) {
        this.validators.add(validator);
    }

    public void setValidatorsFromArguments(ArgumentsReader argumentsReader) {
        if (!argumentsReader.isColumnDefault()) {
            addValidator(new ColumnValidator(argumentsReader.getColumnFrom(), argumentsReader.getColumnTo()));
        }
        if (!argumentsReader.isRowDefault()) {
            addValidator(new RowValidator(argumentsReader.getRowFrom(), argumentsReader.getRowTo()));
        }
    }

    public boolean isValid(Cell cell) {
        for (CellValidator validator :validators) {
            if (!validator.isValid(cell)) {
                return false;
            }
        }
        return true;
    }
}
