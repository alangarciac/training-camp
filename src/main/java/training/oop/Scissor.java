package training.oop;

public class Scissor implements Game{

    @Override
    public Game vs(Game game) {
        return game.vs(this);
    }

    @Override
    public Game vs(Stone stone) {
        return stone;
    }

    @Override
    public Game vs(Scissor scissor) {
        return this;
    }

    @Override
    public Game vs(Paper paper) {
        return this;
    }
}
