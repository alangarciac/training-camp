package training.oop;

public interface Game {

    public Game vs(Game game);

    public Game vs(Stone stone);

    public Game vs(Scissor scissor);

    public Game vs(Paper paper);

}
