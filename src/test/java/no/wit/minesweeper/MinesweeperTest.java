package no.wit.minesweeper;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MinesweeperTest {

    @Test
    public void shouldShowAVerySimpleBoard() {
        String[] field = {"."};
        assertArrayEquals(new String[]{"0"}, calculateHints(field));
    }

    @Test
    public void shouldShowLongerBoards() {
        String[] field = {"...."};
        assertArrayEquals(new String[]{"0000"}, calculateHints(field));
    }

    @Test
    public void shouldShowHigherBoards() {
        String[] field = {"....", "....", "...."};
        assertArrayEquals(new String[]{"0000", "0000", "0000"}, calculateHints(field));
    }

    @Test
    public void shouldShowAVerySimpleBoardWithMine() {
        String[] mine = {"*"};
        assertArrayEquals(new String[]{"*"}, calculateHints(mine));
    }

    @Test
    public void shouldCountMinesLeftOfSquare() {
        String[] mine = {"*."};
        assertArrayEquals(new String[]{"*1"}, calculateHints(mine));
    }

    @Test
    public void shouldCountMinesOnSameLine() {
        String[] mine = {"..*.**.."};
        assertArrayEquals(new String[]{"01*2**10"}, calculateHints(mine));
    }

    @Test
    public void shouldCountMinesOnSameColumn() {
        String[] mine = {
                ".", ".", "*", ".", "*", "*", ".", "."
        };
        assertArrayEquals(new String[]{"0", "1", "*", "2", "*", "*", "1", "0"}, calculateHints(mine));
    }

    @Test
    public void shouldCountMinesAroundCell() {
        String[] field = {"...", ".*.", "..."};
        assertArrayEquals(new String[]{"111", "1*1", "111"}, calculateHints(field));
    }

    @Test
    public void shouldTestTheWholeBoard() {
        String[] field = {
                "*....",
                "***.*",
                "....*",
                "..*.."
        };
        assertArrayEquals(new String[] {
                "*4221",
                "***3*",
                "2434*",
                "01*21"
        }, calculateHints(field));
    }

    private String[] calculateHints(String[] field) {
        return new Minesweeper(field).calculateHints();
    }

}
