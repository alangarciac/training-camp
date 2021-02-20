package training.functional;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCamp {

    private static final Integer AMOUNT_OF_ELEMENTS = 5000000 ; // 5M

    public static void main(String[] args){
        LambdaCamp app = new LambdaCamp();
        Instant start, end;
        List<String> list = initList();
        List<String> numbersList = initNumbersList();

        // basics
        Log("Input:" + list);
        list = app.sortByLambda(list);
        Log("Sorted Output:" + list);

        // lambda throw interface
        Operation operation = (x, y) -> (x+y)/2;
        Log("The AVG btw 5 and 18 is: " + operation.avg(5,18));

        // streams
        Log("Elements starting with A: " + list.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList()));
        Log("ASC Ordered elements :" + list.stream().sorted().collect(Collectors.toList()));
        Log("DESC Ordered elements :" + list.stream().sorted((x,y) -> y.compareTo(x)).collect(Collectors.toList()));
        Log("Transform all elements to UPPERCASE :" + list.stream().map(String::toUpperCase).collect(Collectors.toList()));
        Log("Limit only 2 elements" + list.stream().limit(2).collect(Collectors.toList()));

        start = Instant.now();
        Log("Transforming "+AMOUNT_OF_ELEMENTS+" elements String to Integer and multiplies by 2");
        numbersList.stream().map(x -> Integer.parseInt(x) * 2);
        end = Instant.now();
        Log("Elapsed time in ns: " + Duration.between(start,end).toNanos());

        // parallel streams
        start = Instant.now();
        Log("Transforming "+AMOUNT_OF_ELEMENTS+" elements String to Integer and multiplies by 2 in parallel");
        numbersList.parallelStream().map(x -> Integer.parseInt(x)*2);
        end = Instant.now();
        Log("Elapsed time in ns: " + Duration.between(start,end).toNanos());
    }

    private List<String> sortByLambda(List<String> input){
        Collections.sort(input, String::compareToIgnoreCase);
        return input;
    }

    private static List<String> initNumbersList() {
        List<String> list = new ArrayList<>();
        for (Integer i = 0; i < AMOUNT_OF_ELEMENTS; i++) {
            list.add(i.toString());
        }
        return list;
    }

    private static List<String> initList() {
        List<String> list = new ArrayList<>();
        list.add("Juan");
        list.add("Adolfo");
        list.add("Pedro");
        list.add("Alan");
        return list;
    }

    private static void Log(Object message) {
        System.out.println(String.format("%s", message.toString()));
    }

}
