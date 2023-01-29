package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    @Override
    public boolean isValidType(Object object) {
        return object instanceof Integer;
    }

    @Override
    public NumberSchema required() {
        setRequired(true);
        checksList.add(x -> x instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = a -> a > 0;
        checksList.add(positive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = x -> (x >= min) && (x <= max);
        checksList.add(range);
        return this;
    }

}
