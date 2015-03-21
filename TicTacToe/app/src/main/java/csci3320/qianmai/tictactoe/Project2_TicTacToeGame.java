package csci3320.qianmai.tictactoe;

/**
 * Created by Qian Mai on 3/21/2015.
 */
import java.util.Random;


public class Project2_TicTacToeGame {

    private char mBoard[];
    private final static int BOARD_SIZE = 9;

    public static final char HUMAN_PLAYER = 'X';
    public static final char ANDROID_PLAYER = '0';
    public static final char EMPTY_SPACE = ' ';

    private Random mRand;

    //Get board size for random number for computer movement
    public static int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    //Create new game structure
    public Project2_TicTacToeGame(){

        mBoard = new char[BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++)
            mBoard[i] = EMPTY_SPACE;

        mRand = new Random();
    }

    //Clear all buttons on board
    public void clearBoard()
    {
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            mBoard[i] = EMPTY_SPACE;
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

        for (int i = 0; i < getBOARD_SIZE(); i++)
        {
            //Check available button for movement
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER)
            {
                char curr = mBoard[i];
                mBoard[i] = ANDROID_PLAYER;
                //Get next movement button index if computer can win for the next step
                if (checkForWinner() == 3)
                {
                    setMove(ANDROID_PLAYER, i);
                    return i;
                }
                else
                    mBoard[i] = curr;
            }
        }

        for (int i = 0; i < getBOARD_SIZE(); i++)
        {
            //Check available button for movement
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER)
            {
                char curr = mBoard[i];
                mBoard[i] = HUMAN_PLAYER;
                //Get next movement button index to prevent player win
                //if player can win in the next step
                if (checkForWinner() == 2)
                {
                    setMove(ANDROID_PLAYER, i);
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
            move = mRand.nextInt(getBOARD_SIZE());
        } while (mBoard[move] == HUMAN_PLAYER || mBoard[move] == ANDROID_PLAYER);

        //Get a random index for next movement button
        setMove(ANDROID_PLAYER, move);
        return move;
    }

    //Check winner if there are 3 same letters
    public int checkForWinner()
    {
        //Check horizontal letters are the same or not
        for (int i = 0; i <= 6; i += 3)
        {
            if (mBoard[i] == HUMAN_PLAYER &&
                    mBoard[i+1] == HUMAN_PLAYER &&
                    mBoard[i+2] == HUMAN_PLAYER)
                //If human wins return 2
                return 2;
            if (mBoard[i] == ANDROID_PLAYER &&
                    mBoard[i+1] == ANDROID_PLAYER &&
                    mBoard[i+2] == ANDROID_PLAYER)
                //If computer wins return 3
                return 3;
        }

        //Check vertical letters are the same or not
        for (int i = 0; i <= 2; i++)
        {
            if (mBoard[i] == HUMAN_PLAYER &&
                    mBoard[i+3] == HUMAN_PLAYER &&
                    mBoard[i+6] == HUMAN_PLAYER)
                return 2;
            if (mBoard[i] == ANDROID_PLAYER &&
                    mBoard[i+3] == ANDROID_PLAYER &&
                    mBoard[i+6] == ANDROID_PLAYER)
                return 3;
        }

        //Check diagonal letters are the same or not
        if ((   mBoard[0] == HUMAN_PLAYER &&
                mBoard[4] == HUMAN_PLAYER &&
                mBoard[8] == HUMAN_PLAYER)
                ||
                (mBoard[2] == HUMAN_PLAYER &&
                 mBoard[4] == HUMAN_PLAYER &&
                 mBoard[6] == HUMAN_PLAYER) )
            return 2;
        if ((   mBoard[0] == ANDROID_PLAYER &&
                mBoard[4] == ANDROID_PLAYER &&
                mBoard[8] == ANDROID_PLAYER)
                ||
                (mBoard[2] == ANDROID_PLAYER &&
                 mBoard[4] == ANDROID_PLAYER &&
                 mBoard[6] == ANDROID_PLAYER) )
            return 3;

        //If no winner, check the game is finished or not, if not return 0
        for (int i = 0; i < getBOARD_SIZE(); i++)
        {
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER)
                return 0;
        }

        //If no winner and the game is finished, return 1 for tie
        return 1;
    }
}
