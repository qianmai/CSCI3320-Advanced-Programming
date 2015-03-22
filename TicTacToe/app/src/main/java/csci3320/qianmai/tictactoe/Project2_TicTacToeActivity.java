package csci3320.qianmai.tictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Create Project2_TicTacToeActivity under the Activity
public class Project2_TicTacToeActivity extends Activity {

    private Project2_TicTacToeGame mGame;

    private Button mBoardButtons[];

    private TextView mInfoTextView;
    private TextView humanWinCountText;
    private TextView tieGamesCountText;
    private TextView computerWinCountText;

    private int humanWinCount = 0;
    private int tieGamesCount = 0;
    private int computerWinCount = 0;

    private boolean mHumanFirst = true;
    private boolean mGameOver = false;

    //Interface initialization
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBoardButtons = new Button[9];
        mBoardButtons[0] = (Button) findViewById(R.id.one);
        mBoardButtons[1] = (Button) findViewById(R.id.two);
        mBoardButtons[2] = (Button) findViewById(R.id.three);
        mBoardButtons[3] = (Button) findViewById(R.id.four);
        mBoardButtons[4] = (Button) findViewById(R.id.five);
        mBoardButtons[5] = (Button) findViewById(R.id.six);
        mBoardButtons[6] = (Button) findViewById(R.id.seven);
        mBoardButtons[7] = (Button) findViewById(R.id.eight);
        mBoardButtons[8] = (Button) findViewById(R.id.nine);

        mInfoTextView = (TextView) findViewById(R.id.information);
        humanWinCountText = (TextView) findViewById(R.id.humanCount);
        tieGamesCountText = (TextView) findViewById(R.id.tiesCount);
        computerWinCountText = (TextView) findViewById(R.id.androidCount);

        humanWinCountText.setText(Integer.toString(humanWinCount));
        tieGamesCountText.setText(Integer.toString(tieGamesCount));
        computerWinCountText.setText(Integer.toString(computerWinCount));

        mGame = new Project2_TicTacToeGame();

        startNewGame();
    }

    //Create menu options
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);

        return true;
    }

    //Define menu options details
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.newGame:
                startNewGame();
                break;
            case R.id.exitGame:
                Project2_TicTacToeActivity.this.finish();
                break;
        }

        return true;
    }

    //Start new game method but still keep the game record
    private void startNewGame()
    {
        mGame.clearBoard();

        for (int i = 0; i < mBoardButtons.length; i++)
        {
            mBoardButtons[i].setText("");
            mBoardButtons[i].setEnabled(true);
            mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
        }

        if (mHumanFirst)
        {
            mInfoTextView.setText(R.string.first_human);
            mHumanFirst = false;
        }
        else
        {
            mInfoTextView.setText(R.string.turn_computer);
            int move = mGame.getComputerMove();
            setMove(mGame.computerChar, move);
            mHumanFirst = true;
        }

        mGameOver = false;
    }

    //Button click handler
    private class ButtonClickListener implements View.OnClickListener
    {
        int location;

        public ButtonClickListener(int location)
        {
            this.location = location;
        }

        public void onClick(View view)
        {
            if (!mGameOver)
            {
                if (mBoardButtons[location].isEnabled())
                {
                    setMove(mGame.humanChar, location);

                    int winner = mGame.checkForWinner();

                    //If the game is not finished yet, get player's next movement
                    if (winner == 0)
                    {
                        mInfoTextView.setText(R.string.turn_computer);
                        int move = mGame.getComputerMove();
                        setMove(mGame.computerChar, move);
                        winner = mGame.checkForWinner();
                    }

                    //If the game is not finished yet, switch player
                    if (winner == 0) {
                        mInfoTextView.setText(R.string.turn_human);
                    }
                    //If the game is tie
                    else if (winner == 1)
                    {
                        mInfoTextView.setText(R.string.result_tie);
                        tieGamesCount++;
                        tieGamesCountText.setText(Integer.toString(tieGamesCount));
                        mGameOver = true;
                    }
                    //If human wins, update human score
                    else if (winner == 2)
                    {
                        mInfoTextView.setText(R.string.result_human_wins);
                        humanWinCount++;
                        humanWinCountText.setText(Integer.toString(humanWinCount));
                        mGameOver = true;
                    }
                    //If computer wins, update computer score
                    else
                    {
                        mInfoTextView.setText(R.string.result_android_wins);
                        computerWinCount++;
                        computerWinCountText.setText(Integer.toString(computerWinCount));
                        mGameOver = true;
                    }
                }
            }
        }
    }

    //Set movement and update button status
    private void setMove(char player, int location)
    {
        mGame.setMove(player, location);
        mBoardButtons[location].setEnabled(false);
        mBoardButtons[location].setText(String.valueOf(player));
        if (player == mGame.humanChar) {
            mBoardButtons[location].setTextColor(Color.RED);
//            mBoardButtons[location].setBackgroundColor(Color.GREEN);
        } else {
            mBoardButtons[location].setTextColor(Color.BLUE);
//            mBoardButtons[location].setBackgroundColor(Color.WHITE);
        }
    }
}

