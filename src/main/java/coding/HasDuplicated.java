package coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class HasDuplicated {

    /**
     * Giving 10 numbers between 1..10, check if exist any duplicates.
     * hasDuplicates(List<Integer> numbers)
     * */

    public static  void main(String[] args){

        List<Integer> numbers = Arrays.asList(1,4,5,3,3,10,2,6,8,6);
        System.out.println(hasDuplicates(numbers));

    }

    private static boolean hasDuplicates(List<Integer> numbers) {

        if(numbers.size()> 10) return true;

        HashSet<Integer> occur = new HashSet<>();
        return !numbers.stream().filter(e -> !occur.add(e)).collect(Collectors.toList()).isEmpty();
    }

    private static boolean hasDuplicates1(List<Integer> numbers){

        if(numbers.size()> 10) return true;

        HashSet<Integer> occur = new HashSet<>();
        for (Integer n: numbers){
           if(occur.contains(n)) return true;
        }
        return false;
    }

}