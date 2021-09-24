package training.oop;

public class Stone implements Game{

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
        return this;
    }

    @Override
    public Game vs(Paper paper) {
        return paper;
    }
}
