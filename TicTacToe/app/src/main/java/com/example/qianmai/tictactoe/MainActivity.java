package com.example.qianmai.tictactoe;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
//    private TicTacToeGame mGame;
//
//    private Button mBoardButtons[];
//
//    private TextView mInfoTextView;
//    private TextView mHumanCount;
//    private TextView mTieCount;
//    private TextView mAndroidCount;
//
//    private int mHumanCounter = 0;
//    private int mTieCounter = 0;
//    private int mAndroidCounter = 0;
//
//    private boolean mHumanFirst = true;
//    private boolean mGameOver = false;
//
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        mBoardButtons = new Button[mGame.getBOARD_SIZE()];
//        mBoardButtons[0] = (Button) findViewById(R.id.one);
//        mBoardButtons[1] = (Button) findViewById(R.id.two);
//        mBoardButtons[2] = (Button) findViewById(R.id.three);
//        mBoardButtons[3] = (Button) findViewById(R.id.four);
//        mBoardButtons[4] = (Button) findViewById(R.id.five);
//        mBoardButtons[5] = (Button) findViewById(R.id.six);
//        mBoardButtons[6] = (Button) findViewById(R.id.seven);
//        mBoardButtons[7] = (Button) findViewById(R.id.eight);
//        mBoardButtons[8] = (Button) findViewById(R.id.nine);
//
//        mInfoTextView = (TextView) findViewById(R.id.information);
//        mHumanCount = (TextView) findViewById(R.id.humanCount);
//        mTieCount = (TextView) findViewById(R.id.tiesCount);
//        mAndroidCount = (TextView) findViewById(R.id.androidCount);
//
//        mHumanCount.setText(Integer.toString(mHumanCounter));
//        mTieCount.setText(Integer.toString(mTieCounter));
//        mAndroidCount.setText(Integer.toString(mAndroidCounter));
//
//        mGame = new TicTacToeGame();
//
//        startNewGame();
//
//    }
//
//    private void startNewGame()
//    {
//        mGame.clearBoard();
//
//        for (int i = 0; i < mBoardButtons.length; i++)
//        {
//            mBoardButtons[i].setText("");
//            mBoardButtons[i].setEnabled(true);
//            mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
//        }
//
//        if (mHumanFirst)
//        {
//            mInfoTextView.setText(R.string.first_human);
//            mHumanFirst = false;
//        }
//        else
//        {
//            mInfoTextView.setText(R.string.turn_computer);
//            int move = mGame.getComputerMove();
//            setMove(mGame.ANDROID_PLAYER, move);
//            mHumanFirst = true;
//        }
//    }
//
//    private class ButtonClickListener implements View.OnClickListener
//    {
//        int location;
//
//        public ButtonClickListener(int location)
//        {
//            this.location = location;
//        }
//
//        public void onClick(View view)
//        {
//            if (!mGameOver)
//            {
//                if (mBoardButtons[location].isEnabled())
//                {
//                    setMove(mGame.HUMAN_PLAYER, location);
//
//                    int winner = mGame.checkForWinner();
//
//                    if (winner == 0)
//                    {
//                        mInfoTextView.setText(R.string.turn_computer);
//                        int move = mGame.getComputerMove();
//                        setMove(mGame.ANDROID_PLAYER, move);
//                        winner = mGame.checkForWinner();
//                    }
//
//                    if (winner == 0)
//                        mInfoTextView.setText(R.string.turn_human);
//                    else if (winner == 1)
//                    {
//                        mInfoTextView.setText(R.string.result_tie);
//                        mTieCounter++;
//                        mTieCount.setText(Integer.toString(mTieCounter));
//                        mGameOver = true;
//                    }
//                    else if (winner == 2)
//                    {
//                        mInfoTextView.setText(R.string.result_human_wins);
//                        mHumanCounter++;
//                        mHumanCount.setText(Integer.toString(mHumanCounter));
//                        mGameOver = true;
//                    }
//                    else
//                    {
//                        mInfoTextView.setText(R.string.result_android_wins);
//                        mAndroidCounter++;
//                        mAndroidCount.setText(Integer.toString(mAndroidCounter));
//                        mGameOver = true;
//                    }
//                }
//            }
//        }
//    }
//
//    private void setMove(char player, int location)
//    {
//        mGame.setMove(player, location);
//        mBoardButtons[location].setEnabled(false);
//        mBoardButtons[location].setText(String.valueOf(player));
//        if (player == mGame.HUMAN_PLAYER)
//            mBoardButtons[location].setTextColor(Color.GREEN);
//        else
//            mBoardButtons[location].setTextColor(Color.RED);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
