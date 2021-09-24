package training.patterns;

public interface CountryVisitor<T, J> {

    T visitChina(J data);
    T visitIndia(J data);
    T visitUnitedStates(J data);
    T visitBrazil(J data);
    T visitMexico(J data);
    T visitGermany(J data);

}
