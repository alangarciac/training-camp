package training.oop;

public interface Game {

    public Game vs(Stone stone);

    public Game vs(Scissor scissor);

    public Game vs(Paper paper);

}
