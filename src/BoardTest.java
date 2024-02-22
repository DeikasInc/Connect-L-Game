import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    /**
     * Used to make a copy of board before functions run, so that verify a function was non-destructive on board is easy
     * @param board The board to make deep copy of
     * @return A deep copy of given board
     */
    public int[][] deepCopy(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copy;
    }

    @Test
    public void deepCopyTestWithoutDeepEquals() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        assertEquals(expected[0][0], actual[0][0]);
        assertEquals(expected[0][1], actual[0][1]);
    }


    @Test
    public void deepCopyTestNoChange() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void deepCopyTestChangeEntryIn2D() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0][0] = 99;
        assertTrue(!Arrays.deepEquals(expected, actual));
    }

    @Test
    public void deepCopyTestSet1DRefToDiffButIdenticalArray() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0] = new int[]{0,1};
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void deepCopyTestSet1DRefToDiffArray() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0] = new int[]{0,99};
        assertTrue(!Arrays.deepEquals(expected, actual));
    }






    @Test
    public void testCreateBoardValidEMPBoard(){
        int[][] expected = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        int[][] actual = Board.createBoard(4,4);

        assertTrue(Arrays.deepEquals(expected,actual));
    }

    @Test 
    public void createBoardDifferentsizes(){
        int[][] expected = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        int [][] actual = Board.createBoard(6, 4);

        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void createBoardFullNonEMP(){
        int[][] unexpected = new int[][]{
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };

        int[][] actual = Board.createBoard(5,5);

        assertFalse(Arrays.deepEquals(unexpected, actual));
    }

    @Test
    public void createBoardONENonEMP(){
        int[][] unexpected = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.RED}
        };


        int[][] actual = Board.createBoard(5, 5);
        
        assertFalse(Arrays.deepEquals(unexpected, actual)); 
    }


    @Test
    public void createBoardHalfEMPandHalfNonEMP(){
        int[][] unexpected = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };

        int[][] actual =  Board.createBoard(5, 5);

        assertFalse(Arrays.deepEquals(unexpected, actual));
    }

    @Test
    public void rowCountWithValidBoard(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(4, Board.rowCount(validBoard));
    }

    @Test
    public void rowCountBoard3x4(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP}
    };
        assertEquals(3, Board.rowCount(validBoard));

    }


    @Test
    public void rowCountInvalidBoard(){
        int[][] invalidBoard = new int[][]{};

        assertEquals(0, Board.rowCount(invalidBoard));
    }

    @Test 
    public void rowCountBoard8x8(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(8, Board.rowCount(validBoard));
    }

    @Test
    public void rowCountBoard6x4(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(6, Board.rowCount(validBoard));
    }


    @Test 
    public void columnCountValidBoard(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };  

        assertEquals(4, Board.columnCount(validBoard));
    }

    @Test
    public void columnCountBoardMaxSize(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(8, Board.columnCount(validBoard));
    }

    @Test
    public void columnCountWithSingleColumns(){
        int[][] invalidBoard = new int[][]{{Board.EMP},{Board.EMP}};

        assertEquals(1, Board.columnCount(invalidBoard));
    }

    @Test
    public void columnCountBoard6x6(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(6, Board.columnCount(validBoard));
    }

    @Test
    public void columnCountBoard4x5(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(5, Board.columnCount(validBoard));
    }

    @Test
    public void validWithIndex00(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };
        int row = 0;
        int col = 0;

        assertTrue(Board.valid(validBoard, row, col));
    }

    @Test
    public void validWithInvalidColumnIndex(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };
        int row = 0;
        int col = -2;

        assertFalse(Board.valid(validBoard, row, col));
    }

    @Test 
    public void validInvalidRowIndex(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };
        int row,col;
        row = -1;
        col = 0;
        assertFalse(Board.valid(validBoard, row, col));
    }

    @Test
    public void validColumnGreaterThanColumnCount(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        int row = 2;
        int col = 5;
        assertFalse(Board.valid(validBoard, row, col));
    }

    @Test
    public void validlidWithIndicesBeyondBoardSize(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };
        assertFalse(Board.valid(validBoard, 5, 5));
    }

    @Test
    public void canPlayEmptyColumn(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };
        assertTrue(Board.canPlay(validBoard, 0));
    }

    @Test 
    public void canPlayFullColumn(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.BLU, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertFalse(Board.canPlay(validBoard, 0));
    }

    @Test
    public void canPlayOnlyOneEmptySpace(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.BLU, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };
        assertTrue(Board.canPlay(validBoard, 0));
    }

    @Test
    public void CanPlayWithPartiallyFilledColumn() {
        int[][] board = {{1, 0, 1}, {2, 0, 2}, {1, 0, 1}};
        assertTrue(Board.canPlay(board, 1));
    }

    @Test
    public void canPlayFullBoard(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.BLU, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };
        assertFalse(Board.canPlay(validBoard, 1));
    }

    @Test
    public void playFullBoard(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.BLU, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };

        assertEquals(-1, Board.play(validBoard, 0, 1));
    }

    @Test
    public void playWithEmptyColumn(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.BLU, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };

        assertEquals(0, Board.play(validBoard, 0, 1));
    }

    @Test
    public void playEMPBoard(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(3, Board.play(validBoard, 0, 1));
    }

    @Test
    public void playWithFullColumn(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(-1, Board.play(validBoard, 0, 1));
    }

    @Test
    public void playWithPieceRed() {
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int rowIndex = Board.play(board, 1, 1);
        assertEquals(2, rowIndex);
        assertEquals(1, board[rowIndex][1]);
    }

    @Test
    public void removeLastPlayFullBoard(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.BLU, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };

        assertEquals(Board.RED, Board.removeLastPlay(validBoard, 0));
    }

    @Test
    public void removeLastPlayEmptyColumn(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.BLU, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(Board.BLU, Board.removeLastPlay(validBoard, 0));
    }

    @Test
    public void removeLastPlayEmptyBoard(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(-1, Board.removeLastPlay(validBoard, 0));
    }
    
    @Test
    public void removeLastPlayWithPieceFromTop(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertEquals(1, Board.removeLastPlay(validBoard, 0));
    }

    @Test
    public void removeLastPlayWithPieceFromBottom(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.RED, Board.EMP, Board.EMP}
        };

        assertEquals(1, Board.removeLastPlay(validBoard, 2));
    }

    @Test
    public void fullEmptyBoard(){
        int[][] validBoard = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertFalse(Board.full(validBoard));
    }

    @Test void fullOnePieceinBoard(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.RED, Board.EMP}
        };
        assertFalse(Board.full(validBoard));
    }
    
    @Test 
    public void fullBoard(){
        int[][] validBoard = new int[][]{
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.BLU, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };
        assertTrue(Board.full(validBoard));
    }

    @Test
    public void fullHalfBoardEmpty(){
        int[][] unexpected = new int[][]{
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.EMP, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };

        assertFalse(Board.full(unexpected));
    }

    @Test
    public void fullOneColumnFull(){
        int[][] unexpected = new int[][]{
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP},
            {Board.RED, Board.EMP, Board.EMP, Board.EMP, Board.EMP}
        };

        assertFalse(Board.full(unexpected));
    }

    @Test
    public void winInRowHorizontalL(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
        };

        assertTrue(Board.winInRow(expected, 3, 1, 4));
    }
    @Test
    public void winInRowInvertedHorizontalL(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0}
        };

        assertTrue(Board.winInRow(expected, 3, 1, 4));
    }
    @Test
    public void winInRowHRightSideHorizontalL(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
        };

        assertTrue(Board.winInRow(expected, 3, 1, 4));
    }
    @Test
    public void winInRowOnlyLengthRequirement(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
        };

        assertFalse(Board.winInRow(expected, 3, 1, 4));
    }
    @Test
    public void winInRowRightSideInvertedHorizont2alL(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0}
        };

        assertTrue(Board.winInRow(expected, 3, 1, 4));
    }

    @Test
    public void winInColumnVerticalL(){
        int[][] expected = new int[][]{
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        assertTrue(Board.winInColumn(expected, 0, 1, 3));
    }

    @Test
    public void winInColumnOnlyLenght(){
        int[][] expected = new int[][]{
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        assertFalse(Board.winInColumn(expected, 0, 1, 3));
    }
    @Test
    public void winInColumnOnePieceColumn(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        assertFalse(Board.winInColumn(expected, 1, 1, 3));
    }

    @Test
    public void winInColumnInvertedVerticalL(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
  
        assertTrue(Board.winInColumn(expected, 4, 1, 3));
    }
    @Test
    public void winInColumnPerpendicularLAtTop(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0}
        };
  
        assertTrue(Board.winInColumn(expected, 1, 1, 3));
    }

    @Test
    public void winInDiagonalBackslashBigDiagonal(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };

        assertFalse(Board.winInDiagonalBackslash(expected, 1, 4));
    }

    @Test
    public void winInDiagonalBackslashL(){
        int[][] expected = new int[][]{
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0}
        };

        assertTrue(Board.winInDiagonalBackslash(expected, 1, 4));
    }

    @Test
    public void winInDiagonalBackslashInvertedL(){
        int[][] expected = new int[][]{
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        assertTrue(Board.winInDiagonalBackslash(expected, 1, 3));
    }

    @Test
    public void winInDiagonalBackslashPerpendicularLatBottom(){
        int[][] expected = new int[][]{
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };

        assertTrue(Board.winInDiagonalBackslash(expected, 1, 3));
    }

    @Test
    public void winInDiagonalBackslashBottomDiagonal(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0}
        };

        assertFalse(Board.winInDiagonalBackslash(expected, 1, 3));
    }
    
    @Test
    public void winInDiagonalForwardSlashInvalidDiagonal(){
        int[][] expected = new int[][]{
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1}
        };

        assertFalse(Board.winInDiagonalForwardSlash(expected, 1, 4));
    }
    @Test
    public void winInDiagonalForwardSlashL(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0}
        };

        assertTrue(Board.winInDiagonalForwardSlash(expected, 1, 4));
    }

    @Test
    public void winInDiagonalForwardSlashTopL(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };

        assertTrue(Board.winInDiagonalForwardSlash(expected, 1, 3));
    }
    @Test
    public void tWinInDiagonalForwardSlashWithNoWinningSequence() {
        int[][] board = {
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}
        };
        assertFalse(Board.winInDiagonalForwardSlash(board, 1, 3));
    }
    @Test
    public void winInDiagonalForwardSlashWithValidWinningSequence(){
        int[][] expected = new int[][]{
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };

        assertTrue(Board.winInDiagonalForwardSlash(expected, 1, 3));
    }

    @Test
    public void hintDiagonalBackSlashWinning(){
        int[][] board = new int[][]{
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        int[] hintIdx= {3,2};
        assertArrayEquals(hintIdx, Board.hint(board, 1, 3));
    }

    @Test
    public void hintFullBoard(){
        int[][] board = new int[][]{
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED},
            {Board.RED, Board.RED, Board.RED, Board.RED, Board.RED}
        };
        int[] hintIdx= {-1,-1};

        assertArrayEquals(hintIdx, Board.hint(board, 1, 3));
    }

    @Test
    public void hintEMPoard(){
        int[][] board = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        int[] hintIdx= {-1,-1};
        assertArrayEquals(hintIdx, Board.hint(board, 1, 3));
    }

    @Test
    public void hintVerticalL(){
        int[][] board = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 0, 2, 2},
            {2, 1, 1, 2, 2},
            {2, 2, 1, 2, 1}
        };

        int[] hintIdx= {0,1};
        assertArrayEquals(hintIdx, Board.hint(board, 1, 4));
    }

    @Test
    public void hintWithWinningMoveInDiagonalForwardSlash() {
        int[][] board = {
            {0, 0, 0, 1},
            {0, 0, 2, 1},
            {0, 2, 1, 1},
            {2, 1, 2, 2}
        };
        int[] hintIdx= {2,0};
        assertArrayEquals(hintIdx, Board.hint(board, 1, 3));
    }
}

