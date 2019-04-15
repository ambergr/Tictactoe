package com.example.boterkaaseneieren;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.boterkaaseneieren.GameState.DRAW;
import static com.example.boterkaaseneieren.GameState.PLAYER_ONE;
import static com.example.boterkaaseneieren.GameState.PLAYER_TWO;

public class MainActivity extends AppCompatActivity {
    Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
        if (savedInstanceState != null) {
            game = (Game) savedInstanceState.getSerializable("Game");
            

            CharSequence Button1Visibility = savedInstanceState.getCharSequence("button1_visibility");
            Button button1 = (Button) findViewById(R.id.button1);
            button1.setText(Button1Visibility);

            CharSequence Button2Visibility = savedInstanceState.getCharSequence("button2_visibility");
            Button button2 = (Button) findViewById(R.id.button2);
            button2.setText(Button2Visibility);

            CharSequence Button3Visibility = savedInstanceState.getCharSequence("button3_visibility");
            Button button3 = (Button) findViewById(R.id.button3);
            button3.setText(Button3Visibility);

            CharSequence Button4Visibility = savedInstanceState.getCharSequence("button4_visibility");
            Button button4 = (Button) findViewById(R.id.button4);
            button4.setText(Button4Visibility);

            CharSequence Button5Visibility = savedInstanceState.getCharSequence("button5_visibility");
            Button button5 = (Button) findViewById(R.id.button5);
            button5.setText(Button5Visibility);

            CharSequence Button6Visibility = savedInstanceState.getCharSequence("button6_visibility");
            Button button6 = (Button) findViewById(R.id.button6);
            button6.setText(Button6Visibility);

            CharSequence Button7Visibility = savedInstanceState.getCharSequence("button7_visibility");
            Button button7 = (Button) findViewById(R.id.button7);
            button7.setText(Button7Visibility);

            CharSequence Button8Visibility = savedInstanceState.getCharSequence("button8_visibility");
            Button button8 = (Button) findViewById(R.id.button8);
            button8.setText(Button8Visibility);

            CharSequence Button9Visibility = savedInstanceState.getCharSequence("button9_visibility");
            Button button9 = (Button) findViewById(R.id.button9);
            button9.setText(Button9Visibility);

            CharSequence textview_vis = savedInstanceState.getCharSequence("textView_visibility");
            TextView Textviewsave = (TextView) findViewById(R.id.textView);
            Textviewsave.setText(textview_vis);

        }
    }


    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super
        outState.putSerializable("Game", game);

        Button button1 = (Button) findViewById(R.id.button1);
        CharSequence button1Vis = button1.getText();
        outState.putCharSequence("button1_visibility", button1Vis);

        Button button2 = (Button) findViewById(R.id.button2);
        CharSequence button2Vis = button2.getText();
        outState.putCharSequence("button2_visibility", button2Vis);

        Button button3 = (Button) findViewById(R.id.button3);
        CharSequence button3Vis = button3.getText();
        outState.putCharSequence("button3_visibility", button3Vis);

        Button button4 = (Button) findViewById(R.id.button4);
        CharSequence button4Vis = button4.getText();
        outState.putCharSequence("button4_visibility", button4Vis);

        Button button5 = (Button) findViewById(R.id.button5);
        CharSequence button5Vis = button5.getText();
        outState.putCharSequence("button5_visibility", button5Vis);

        Button button6 = (Button) findViewById(R.id.button6);
        CharSequence button6Vis = button6.getText();
        outState.putCharSequence("button6_visibility", button6Vis);

        Button button7 = (Button) findViewById(R.id.button7);
        CharSequence button7Vis = button7.getText();
        outState.putCharSequence("button7_visibility", button7Vis);

        Button button8 = (Button) findViewById(R.id.button8);
        CharSequence button8Vis = button8.getText();
        outState.putCharSequence("button8_visibility", button8Vis);

        Button button9 = (Button) findViewById(R.id.button9);
        CharSequence button9Vis = button9.getText();
        outState.putCharSequence("button9_visibility", button9Vis);

        TextView Textview_1 = (TextView) findViewById(R.id.textView);
        CharSequence Textviewsave = Textview_1.getText();
        outState.putCharSequence("textView_visibility", Textviewsave);

    }

    public void tileClicked(View view) {
        int id = view.getId();
        Button Butttonchange = (Button) view;
        int row = 0;
        int column = 0;
        switch(id) {
            case R.id.button1:
                row = 0;
                column = 0;
                break;
            case R.id.button2:
                row = 1;
                column = 0;
                break;
            case R.id.button3:
                row = 2;
                column = 0;
                break;
            case R.id.button4:
                row = 0;
                column = 1;
                break;
            case R.id.button5:
                row = 1;
                column = 1;
                break;
            case R.id.button6:
                row = 2;
                column = 1;
                break;
            case R.id.button7:
                row = 0;
                column = 2;
                break;
            case R.id.button8:
                row = 1;
                column = 2;
                break;
            case R.id.button9:
                row = 2;
                column = 2;
                break;
        }
        TileState state = game.choose(row, column);
        switch(state) {
            case CROSS:
                Butttonchange.setText("X");
                // do something
                break;
            case CIRCLE:
                Butttonchange.setText("O");
                // do something
                break;
            case INVALID:
                // do something different
                break;
        }
        TextView TextViewWon = (TextView) findViewById(R.id.textView) ;
        if (game.won() == PLAYER_ONE) {
            TextViewWon.setText("player 1 has won!");
        }
        else if (game.won() == PLAYER_TWO) {
            TextViewWon.setText("player 2 has won!");
        }
        else if (game.won() == DRAW) {
            TextViewWon.setText("It is a draw!");
        }


        if (game.gameOver){
            findViewById(R.id.button1).setClickable(false);
            findViewById(R.id.button2).setClickable(false);
            findViewById(R.id.button3).setClickable(false);
            findViewById(R.id.button4).setClickable(false);
            findViewById(R.id.button5).setClickable(false);
            findViewById(R.id.button6).setClickable(false);
            findViewById(R.id.button7).setClickable(false);
            findViewById(R.id.button8).setClickable(false);
            findViewById(R.id.button9).setClickable(false);
        }
    }

    public void resetClicked(View view) {
        // reset userface
        setContentView(R.layout.activity_main);
        game = new Game();
    }
}
