package training.patterns;

public class Main {

    public static void main (String[] args){
        PopulationPrinter populationPrinter = new PopulationPrinter();
        System.out.println(populationPrinter.process(Country.UNOTED_STATES, "Population is "));
    }


}
