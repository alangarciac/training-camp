package training.functional.predicate;


import model.Apple;

public class ApplePrintColor implements ApplePrinterPredicate {

    @Override
    public String print(Apple apple) {
        return apple.getColor().toString();
    }

}
