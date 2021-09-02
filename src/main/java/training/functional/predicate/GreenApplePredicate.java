package training.functional.predicate;

import model.Apple;
import model.Color;

public class GreenApplePredicate implements AppleFilterPredicate {

    @Override
    public boolean apply(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }

}
