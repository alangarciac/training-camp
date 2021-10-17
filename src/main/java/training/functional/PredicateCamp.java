package training.functional;


import model.Apple;
import model.Color;
import training.functional.predicate.ApplePrintColor;
import training.functional.predicate.ApplePrintColorAndWeight;
import training.functional.predicate.ApplePrinterPredicate;
import training.functional.predicate.GreenApplePredicate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Write a prettyPrintApple method that takes a List of Apples and that can be
 * parameterized with multiple ways to generate a String output from an apple (a bit
 * like multiple customized toString methods). For example, you could tell your
 * prettyPrintApple method to print only the weight of each apple. In addition, you
 * could tell your prettyPrintApple method to print each apple individually and men-
 * tion whether it’s heavy or light. The solution is similar to the filtering examples we’ve
 * explored so far. To help you get started, we provide a rough skeleton of the pretty-
 * PrintApple method:
 *
 * public static void prettyPrintApple(List<Apple> inventory, ???)
 *
 * */
public class PredicateCamp {

    public static void main(String[] args){

        List<Apple> apples = initApples();

        System.out.println("Printing Apples colors ... ");
        prettyPrintApple(apples, new ApplePrintColor());
        System.out.println("--");

        System.out.println("Printing Apples colors and weight ... ");
        prettyPrintApple(apples, new ApplePrintColorAndWeight());
        System.out.println("--");

        System.out.println("Printing only Green Apples ... ");
        prettyPrintApple(
                apples.stream()
                .filter(apple -> new GreenApplePredicate()
                        .apply(apple))
                        .collect(Collectors.toList()),
                new ApplePrintColorAndWeight()
        );

        System.out.println("Printing only Red Apples ... ");
        Predicate<Apple> onlyRedApples = (Apple a) -> a.getColor().equals(Color.RED);
        prettyPrintApplePredicate(apples, onlyRedApples);

        System.out.println("--");

        System.out.println("Printing Apples ordering by weight DESC ... ");
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        prettyPrintApple(apples, new ApplePrintColorAndWeight());
        System.out.println("--");
    }

    private static void prettyPrintApple(List<Apple> inventory, ApplePrinterPredicate applePrinterPredicate) {
        inventory.forEach(apple -> System.out.println(applePrinterPredicate.print(apple)));
    }

    private static void prettyPrintApplePredicate(List<Apple> inventory, Predicate<Apple> predicate) {
        inventory.stream().filter(predicate).forEach(a -> System.out.println(a.toString()));
    }

    private static List<Apple> initApples() {

        return Arrays.asList(
                new Apple(Color.GREEN, "190,5"),
                new Apple(Color.RED, "127,0"),
                new Apple(Color.GREEN, "155,9"),
                new Apple(Color.GREEN, "115,5"),
                new Apple(Color.RED, "180,1"),
                new Apple(Color.GREEN, "111,5"),
                new Apple(Color.GREEN, "201,9")
        );

    }

}
