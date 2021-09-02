package training.functional.predicate;

import model.Apple;

public class ApplePrintColorAndWeight implements ApplePrinterPredicate {

    @Override
    public String print(Apple apple) {
        return apple.getColor().toString() + ", " +apple.getWeight();
    }

}
