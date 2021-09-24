package training.oop;

public class Paper implements Game{

    @Override
    public Game vs(Game game) {
        return game.vs(this);
    }

    @Override
    public Game vs(Stone stone) {
        return this;
    }

    @Override
    public Game vs(Scissor scissor) {
        return scissor;
    }

    @Override
    public Game vs(Paper paper) {
        return this;
    }
}
