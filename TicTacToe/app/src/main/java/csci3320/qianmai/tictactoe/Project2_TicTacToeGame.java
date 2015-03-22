package csci3320.qianmai.tictactoe;

/**
 * Created by Qian Mai on 3/21/2015.
 */
import java.util.Random;


public class Project2_TicTacToeGame {

    private char mBoard[];
    private final static int boardButtonNum = 9;

    public static final char humanChar = 'O';
    public static final char computerChar = 'X';
    public static final char blankChar = ' ';

    private Random mRand;

    //Create new game structure
    public Project2_TicTacToeGame(){

        mBoard = new char[boardButtonNum];

        for (int i = 0; i < boardButtonNum; i++)
            mBoard[i] = blankChar;

        mRand = new Random();
    }

    //Clear all buttons on board
    public void clearBoard()
    {
        for (int i = 0; i < boardButtonNum; i++)
        {
            mBoard[i] = blankChar;
        }
    }

    //Set player movement
    public void setMove(char player, int location)
    {
        mBoard[location] = player;
    }

    //SetComputer movement
    public int getComputerMove()
    {
        int move;

        for (int i = 0; i < boardButtonNum; i++)
        {
            //Check available button for movement
            if (mBoard[i] != humanChar && mBoard[i] != computerChar)
            {
                char curr = mBoard[i];
                mBoard[i] = computerChar;
                //Get next movement button index if computer can win for the next step
                if (checkForWinner() == 3)
                {
                    setMove(computerChar, i);
                    return i;
                }
                else
                    mBoard[i] = curr;
            }
        }

        for (int i = 0; i < boardButtonNum; i++)
        {
            //Check available button for movement
            if (mBoard[i] != humanChar && mBoard[i] != computerChar)
            {
                char curr = mBoard[i];
                mBoard[i] = humanChar;
                //Get next movement button index to prevent player win
                //if player can win in the next step
                if (checkForWinner() == 2)
                {
                    setMove(computerChar, i);
                    return i;
                }
                else
                    mBoard[i] = curr;
            }
        }

        //Get next movement button index if it has not been taken
        do
        {
            //Set computer movement from board size
            move = mRand.nextInt(boardButtonNum);
        } while (mBoard[move] == humanChar || mBoard[move] == computerChar);

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
            if (mBoard[i] == humanChar &&
                    mBoard[i+1] == humanChar &&
                    mBoard[i+2] == humanChar)
                //If human wins return 2
                return 2;
            if (mBoard[i] == computerChar &&
                    mBoard[i+1] == computerChar &&
                    mBoard[i+2] == computerChar)
                //If computer wins return 3
                return 3;
        }

        //Check vertical letters are the same or not
        for (int i = 0; i <= 2; i++)
        {
            if (mBoard[i] == humanChar &&
                    mBoard[i+3] == humanChar &&
                    mBoard[i+6] == humanChar)
                return 2;
            if (mBoard[i] == computerChar &&
                    mBoard[i+3] == computerChar &&
                    mBoard[i+6] == computerChar)
                return 3;
        }

        //Check diagonal letters are the same or not
        if ((   mBoard[0] == humanChar &&
                mBoard[4] == humanChar &&
                mBoard[8] == humanChar)
                ||
                (mBoard[2] == humanChar &&
                 mBoard[4] == humanChar &&
                 mBoard[6] == humanChar) )
            return 2;
        if ((   mBoard[0] == computerChar &&
                mBoard[4] == computerChar &&
                mBoard[8] == computerChar)
                ||
                (mBoard[2] == computerChar &&
                 mBoard[4] == computerChar &&
                 mBoard[6] == computerChar) )
            return 3;

        //If no winner, check the game is finished or not, if not return 0
        for (int i = 0; i < boardButtonNum; i++)
        {
            if (mBoard[i] != humanChar && mBoard[i] != computerChar) {
                return 0;
            }
        }

        //If no winner and the game is finished, return 1 for tie
        return 1;
    }
}
