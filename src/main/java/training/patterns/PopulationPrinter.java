package training.patterns;

public class PopulationPrinter implements CountryVisitor<String, String> {

    public String process(Country country,  String input){
        return country.accept(this, input);
    }

    @Override
    public String visitChina(String data) {
        return data + "3.4 millions";
    }

    @Override
    public String visitIndia(String data) {
        return data + "1.4 millions";
    }

    @Override
    public String visitUnitedStates(String data) {
        return data + "9.1 millions";
    }

    @Override
    public String visitBrazil(String data) {
        return data + "3.8 millions";
    }

    @Override
    public String visitMexico(String data) {
        return data + "2.4 millions";
    }

    @Override
    public String visitGermany(String data) {
        return data + "5.7 millions";
    }
}
