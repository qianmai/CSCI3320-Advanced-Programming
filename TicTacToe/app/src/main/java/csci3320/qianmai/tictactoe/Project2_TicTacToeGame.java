package csci3320.qianmai.tictactoe;

/**
 * Created by Qian Mai on 3/21/2015.
 */
import java.util.Random;


public class Project2_TicTacToeGame {

    private char chessboardSymbol[];
    private final static int boardButtonNum = 9;

    public static final char humanChar = 'O';
    public static final char computerChar = 'X';
    public static final char blankChar = ' ';

    private Random mRand;

    //Create new game structure
    public Project2_TicTacToeGame(){

        chessboardSymbol = new char[boardButtonNum];

        for (int i = 0; i < boardButtonNum; i++)
            chessboardSymbol[i] = blankChar;

        mRand = new Random();
    }

    //Clear all buttons on board
    public void clearBoard()
    {
        for (int i = 0; i < boardButtonNum; i++)
        {
            chessboardSymbol[i] = blankChar;
        }
    }

    //Set player movement
    public void setMove(char player, int location)
    {
        chessboardSymbol[location] = player;
    }

    //SetComputer movement
    public int getComputerMove()
    {
        int move;

        for (int i = 0; i < boardButtonNum; i++)
        {
            //Check available button for movement
            if (chessboardSymbol[i] != humanChar && chessboardSymbol[i] != computerChar)
            {
                char curr = chessboardSymbol[i];
                chessboardSymbol[i] = computerChar;
                //Get next movement button index if computer can win for the next step
                if (checkForWinner() == 3)
                {
                    setMove(computerChar, i);
                    return i;
                }
                else
                    chessboardSymbol[i] = curr;
            }
        }

        for (int i = 0; i < boardButtonNum; i++)
        {
            //Check available button for movement
            if (chessboardSymbol[i] != humanChar && chessboardSymbol[i] != computerChar)
            {
                char curr = chessboardSymbol[i];
                chessboardSymbol[i] = humanChar;
                //Get next movement button index to prevent player win
                //if player can win in the next step
                if (checkForWinner() == 2)
                {
                    setMove(computerChar, i);
                    return i;
                }
                else
                    chessboardSymbol[i] = curr;
            }
        }

        //Get next movement button index if it has not been taken
        do
        {
            //Set computer movement from board size
            move = mRand.nextInt(boardButtonNum);
        } while (chessboardSymbol[move] == humanChar || chessboardSymbol[move] == computerChar);

        //Get a random index for next movement button
        setMove(computerChar, move);
        return move;
    }

    //Check winner if there are 3 same letters
    public int checkForWinner()
    {
        //Check horizontal letters are the same or not
        for (int i = 0; i <= 6; i += 3)
        {
            if (chessboardSymbol[i] == humanChar &&
                    chessboardSymbol[i+1] == humanChar &&
                    chessboardSymbol[i+2] == humanChar)
                //If human wins return 2
                return 2;
            if (chessboardSymbol[i] == computerChar &&
                    chessboardSymbol[i+1] == computerChar &&
                    chessboardSymbol[i+2] == computerChar)
                //If computer wins return 3
                return 3;
        }

        //Check vertical letters are the same or not
        for (int i = 0; i <= 2; i++)
        {
            if (chessboardSymbol[i] == humanChar &&
                    chessboardSymbol[i+3] == humanChar &&
                    chessboardSymbol[i+6] == humanChar)
                return 2;
            if (chessboardSymbol[i] == computerChar &&
                    chessboardSymbol[i+3] == computerChar &&
                    chessboardSymbol[i+6] == computerChar)
                return 3;
        }

        //Check diagonal letters are the same or not
        if ((   chessboardSymbol[0] == humanChar &&
                chessboardSymbol[4] == humanChar &&
                chessboardSymbol[8] == humanChar)
                ||
                (chessboardSymbol[2] == humanChar &&
                 chessboardSymbol[4] == humanChar &&
                 chessboardSymbol[6] == humanChar) )
            return 2;
        if ((   chessboardSymbol[0] == computerChar &&
                chessboardSymbol[4] == computerChar &&
                chessboardSymbol[8] == computerChar)
                ||
                (chessboardSymbol[2] == computerChar &&
                 chessboardSymbol[4] == computerChar &&
                 chessboardSymbol[6] == computerChar) )
            return 3;

        //If no winner, check the game is finished or not, if not return 0
        for (int i = 0; i < boardButtonNum; i++)
        {
            if (chessboardSymbol[i] != humanChar && chessboardSymbol[i] != computerChar) {
                return 0;
            }
        }

        //If no winner and the game is finished, return 1 for tie
        return 1;
    }
}
