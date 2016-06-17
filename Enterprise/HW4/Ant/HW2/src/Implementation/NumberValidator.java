package Implementation;

import Interface.Validator;

public class NumberValidator implements Validator<Number> {

    @Override
    public boolean isValid(Number result) {
        return (result.longValue() % 2 != 0); //if result odd return true
    }
}
