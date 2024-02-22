
public class Board {

    /**
     * No piece in board (empty)
     */
    public static final int EMP = Game.EMP;
    /**
     * Connect-L Red Piece
     */
    public static final int RED = Game.RED;
    /**
     * Connect-L Blue Piece
     */
    public static final int BLU = Game.BLU;

    //Students should enter their functions below here


/**
 * Creates a 2D integer array representing a game board with the specified number of rows and columns.
 *
 * @param Rows    The number of rows in the game board.
 * @param Columns The number of columns in the game board.
 * @return A 2D integer array representing the initialized game board with all elements set to 0.
 *         The first index (i) represents the row, and the second index (j) represents the column.
 */
    public static int[][] createBoard(int Rows, int Columns) {

        //Create a 2D array to represent the game board with the given numbers in the parameters.
        int [][] Twodboard = new int[Rows][Columns];

        // Initialize each element of the game board to 0.
        for (int i=0; i < Rows; i++){
            for (int j = 0; j < Columns; j++){
                Twodboard[i][j] = 0;

            }
        }
        
        // Return the initialized game board.
        return Twodboard;
    }

    /**
     * Verify if the number of rows is not null.
     * @param board The 2D int[] representing the game board.
     * @return The number of rows in the game board. If null, return 0.
     */

    public static int rowCount(int[][] board) {

        // Check if the input board is null.
        if (board == null){
            return 0;
        }
        
        // Retrieve the number of rows in the game board.
        int countRows = board.length;

        return countRows;
    }

    /**
     * Verify if the number of columns is not null.
     * @param board The 2D int[] representing the game board.
     * @return The number of columns in the game board. 
     */


    public static int columnCount(int[][] board){

        // Retrieve the number of columns in the game board.
        int countColumns = board[0].length;


        return countColumns;
    }

    /**
     * Check if the specified row and column indices are valid within the bounds of the board
     * @param board The 2D integer array representing the game board.
     * @param row The row index to be checked.
     * @param column column The column index to be checked.
     * @return True if the indices are valid.
     */


    public static boolean valid(int[][] board, int row, int column){
        
        // Check if both row and column indices are within the valid bounds of the board.
        if ((row >= 0 && row < rowCount(board) ) && (column >= 0 && column < columnCount(board)) ){
            return true;

        } else{return false;
        } 
    }

    /**
     * Checks if a move is valid in the specified column.
     * @param board The 2D integer array representing the game board.
     * @param col The column index where the move is going to be checked.
     * @return True if there is a empty slot in the column.
     */

    public static boolean canPlay(int[][] board, int col) {

        // Iterate through each row in the specified column to check for any empty spaces
        for (int i=0; i<board.length; i++){
            for (int j=0; j < board[0].length; j++){
                // Check if the current position in the column is empty.
                if (board[i][j] == 0 && board[i][col]==0){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Attempts to make a move in the specified column in the 2D board.
     * @param board The 2D integer array representing the board.
     * @param column The column index where the move is to be played.
     * @param piece The integer representing the player's piece (RED OR BLUE).
     * @return The row where the move is successfully made, or -1 if the move is not valid.
     */

    public static int play(int[][] board, int column, int piece) {

        int indexfreeSpace;

        //Check if the move is valid in the specified column.
        if (canPlay(board, column)){

            // Iterate from the bottom to find the first empty space in the specified column.
            for (int i=board.length -1; i>=0; i--){
                indexfreeSpace = board[i][column];
                if (indexfreeSpace == 0){
                    //make the move by placing the player's piece in the EMP.
                    board[i][column] = piece;
                    // The row index where the move is successfully made.
                    return i;
                }
            }
        }else{
            //if the move is not valid.
            return -1;
        }

        return -1;
    }

    /**
     * Removes the last move made in the specified column.
     * @param board The 2D integer array representing the board.
     * @param column The column index from which the last move is to be removed.
     * @return The row the piece was removed from or -1 if there was no pieces in the column to remove.
     */

    public static int removeLastPlay(int[][] board, int column) {

        // Iterate through each row in the specified column to find the last move made.
        for (int i=0; i<board.length; i++){
            int indexfreeSpace = board[i][column];
            if (indexfreeSpace != 0){
                // Remove the last move by setting the value at the found position to 0.
                board[i][column] = 0;
                // Return the value of the piece removed.
                return indexfreeSpace;
            }
        }

        // If the specified column is empty, return -1.
        return -1;
    }

    /**
     * Checks if the board is completely filled with player moves.
     * @param board The 2D integer array representing the board.
     * @return True if every position on the game is filled with pieces.
     */
    public static boolean full(int[][] board) {

        int count = 0;
        int NMP; 

        // Iterate through each position on the game board.
        for (int i=0; i < board.length; i++){
            for (int j=0; j <board[0].length;j++){
                NMP = board[i][j];
                //Checks if the position is filled with a piece.
                if (NMP !=0){
                    count++;
                }else{
                    count--;
                }
            }
        }

        // Check if every position on the board is filled with pieces. 
        if (count == board.length*board[0].length){
            return true;
        }else{
            return false;       
        }
    }

    /**
     * Checks if the player has won by achieving the form of a horizontal L form.
     * @param board The 2D integer array representing the game board.
     * @param row The row index to check for a winning sequence.
     * @param piece The integer representing the player's piece.
     * @param length The length of the winning sequence to check for.
     * @return True if it found a form of the specified L is found.
     */

    public static boolean winInRow(int[][] board, int row, int piece, int length) {
        //Part of this code was made with chat GPT.
        int columns = board[0].length;

        //Iterate through each possible starting position in the row.
        for (int j = 0; j <= columns - length; j++) {
            boolean consecutive = true;

            // Check if the piece length is valid
            for (int k = 0; k < length; k++) {
                if (board[row][j + k] != piece) {
                    consecutive = false;
                }
            }
            
            // If a winning sentence is found, checks for the perpendicular L piece.
            if (consecutive) {
                if ((row - 1 >= 0 && board[row - 1][j + length - 1] == piece)
                || (row + 1 < board.length && board[row + 1][j + length - 1] == piece)) {
                        return true;
                    }

                if ((row + 1 < board.length && board[row + 1][j] == piece)
                    || (row - 1 >= 0 && board[row - 1][j] == piece)) {
                    return true;
                }
            }
        }

        // If no winning L is found.
        return false;
    }

    /**
     * Checks if the player has won by achieving the form of a vertical L form.
     * @param board The 2D integer array representing the game board.
     * @param col The column index to check for a winning sentence.
     * @param piece The integer representing the player's piece.
     * @param length The length of the winning sequence to check for.
     * @return True if a winning sequence of the specified L forms are found.
     */

    public static boolean winInColumn(int[][] board, int col, int piece, int length) {

        int rows = board.length;
        int columns = board[0].length;
    
        //Iterate through each possible starting position in the column.
        for (int i = 0; i < rows; i++) {
            boolean consecutive = true;
            for (int j = 0; j < length; j++) {

                // Check if the piece length is valid.
                if (i + j >= rows || board[i + j][col] != piece) {
                    consecutive = false;
                }
            }

            // If a winning sentence is found, checks for the perpendicular L piece.
            if (consecutive) {
                if ((col - 1 >= 0 && board[i + length - 1][col - 1] == piece)
                        || (col + 1 < columns && board[i + length - 1][col + 1] == piece)) {
                    return true;
                }
    
                if ((col + 1 < columns && board[i][col + 1] == piece)
                        || (col - 1 >= 0 && board[i][col - 1] == piece)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the player has won by achieving the form of a \ diagonal back-slash L form.
     * @param board The 2D integer array representing the game board.
     * @param piece The integer representing the player's piece.
     * @param length The length of the winning sequence to check for.
     * @return True if a winning sequence of the specified L forms are found.
     */

    public static boolean winInDiagonalBackslash(int[][] board, int piece, int length) {
        
        int cols = board[0].length;
        int rows = board.length;
        // Iterate through each possible starting position in the diagonal.
        for(int i=0; i<=rows-length; i++){
            for(int j=0; j<=cols-length;j++){
                boolean consecutive = true;

                // Check if the piece length is valid.
                for(int k=0; k<length; k++){
                    if (board[i+k][j+k]!=piece){
                        consecutive = false;
                    }
                }

                // Checks for the different positions of the perpendicilar L.
                if (consecutive){

                    
                    if (i -1 >=0 &&board[i-1][j+1]==piece){
                        return true;
                    }
                    
                    if (j - 1 >=0 && board[i+1][j-1]==piece){
                        return true;
                    }
                    
                    if (i + length < rows && board[i+length][j+length-2]==piece){
                        return true;
                    }
                    
                    if (j+length < cols && board[i+length-2][j+length]==piece){
                        return true;
                    }
                }
            }
        }


        return false;
    }

    /**
     * Checks if the player has won by achieving the form of a / diagonal forward-slash L form.
     * @param board The 2D integer array representing the game board.
     * @param piece The integer representing the player's piece.
     * @param length The length of the winning sequence to check for.
     * @return True if a winning sequence of the specified L forms are found.
     */

    public static boolean winInDiagonalForwardSlash(int[][] board, int piece, int length) {

        int cols = board[0].length;
        int rows = board.length;

        // Iterate through each position on the game board.
        for (int i=0; i<rows; i++ ){
            for (int j=0; j<cols; j++){
                // Check if the current position contains the player's piece.
                if (board[i][j]==piece){
                    // Check if there is enough space in both directions to form a winning sequence.
                    if (i>=length -1  && j<=cols -length){

                        boolean consecutive = true;
                        // Check if the piece length is valid.
                        for(int k=0; k<length;k++){
                            if (board[i-k][j+k]!=piece){
                                consecutive = false;
                            }
                        }

                        // Checks for the different positions of the perpendicilar L.

                        if (consecutive){
        
                            if (j - 1 >=0 && board[i -1][j -1]==piece){
                                return true;
                            }

                            if (i+1 <= rows-1 &&board[i+1][j+1]==piece){
                                return true;
                            }
        
                            if (i - length >=0 && board[i-length][j+length-2]==piece){
                                return true;
                            }
                            
                            if (j+length < cols && board[i-length+2][j+length]==piece){
                                return true;
                            }
        
                        }
                        

                    }

                }

            }
        }
    
        return false;

    }

    /**
     * Determine if playing one piece will win the game for a player piece.
     * @param board The 2D integer array representing the game board.
     * @param piece The integer representing the player's piece.
     * @param length The length of the winning sequence to check for.
     * @return A int[] containing the row and column indices of a potential winning move
     */
    public static int[] hint(int[][] board, int piece, int length) {

        int cols = board[0].length;
        int rows = board.length;
        // Initialize the hint array with default values.
        int hint[] = {-1,-1};

        // Iterate through each column on the game board to simulate potential moves.
        for (int i=0; i<rows;i++){
            for (int j=0; j<cols; j++){
                // Check if a move is valid in the current column.
                if (canPlay(board, j)){
                    // Simulate the move and retrieve the row index.
                    int row = play(board, j, piece);
                    // Check if the simulated move results in a winning state.
                    if (winInAnyColumn(board, piece, length)||winInAnyRow(board, piece, length)
                    ||winInDiagonalBackslash(board, piece, length)||winInDiagonalForwardSlash(board, piece, length)){
                        removeLastPlay(board, j);
                        // If winning, remove the simulated move, and set the hint array with the winning move indices.
                        hint[0]= row;
                        hint[1]=j;
                        return hint;
                    }else{
                        // If not winning, remove the simulated move.
                        removeLastPlay(board, j);
                    }


                }


            }
        }

        // Return the hint array with default values indicating no winning move was found.
        return hint;
    }



    //Students should enter their functions above here
    /**
     * Is there a win in given board in any row of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any row
     * @return True if there is length in any row, False otherwise
     */
    private static boolean winInAnyRow(int[][] board, int piece, int length) {
        for (int row = 0; row < board.length; row++) {
            if (winInRow(board, row, piece, length)) {
                return true;
            }
        }
        return false;
    }



    /**
     * Is there a win in given board in any column of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any column
     * @return True if there is length in any column, False otherwise
     */
    private static boolean winInAnyColumn(int[][] board, int piece, int length) {
        for (int col = 0; col < board[0].length; col++) {
            if (winInColumn(board, col, piece, length)) {
                return true;
            }
        }
        return false;
    }



    /**
     * Is there a win in given board in any diagonal of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any diagonal
     * @return True if there is length in any diagonal /\, False otherwise
     */
    private static boolean winInAnyDiagonal(int[][] board, int piece, int length) {
        return winInDiagonalBackslash(board, piece, length) || winInDiagonalForwardSlash(board, piece, length);
    }


    /**
     * Has the given piece won the board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to check for a win
     * @return True if piece has won
     */
    public static boolean won(int[][] board, int piece, int length) {
        return winInAnyRow(board, piece, length) || winInAnyColumn(board, piece, length) || winInAnyDiagonal(board, piece, length);
    }

    /**
     * This function determines if the game is complete due to a win or tie by either player
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @return True if game is complete, False otherwise
     */
    public static boolean isGameOver(int[][] board, int length) {
        return full(board) || won(board, RED, length) || won(board, BLU, length);
    }

}
