package training.oop;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGame {

    private Stone stone = new Stone();
    private Paper paper = new Paper();
    private Scissor scissor = new Scissor();


    @Test
    public void stoneWinsScissor(){
        assertEquals(stone, stone.vs(scissor));
    }

    @Test
    public void scissorWinsPaper(){
        assertEquals(scissor, scissor.vs(paper));
    }

    @Test
    public void paperWinsStone(){
        assertEquals(paper, paper.vs(stone));
    }

    @Test
    public void stoneLoosePaper(){
        assertEquals(paper, stone.vs(paper));
    }

}
