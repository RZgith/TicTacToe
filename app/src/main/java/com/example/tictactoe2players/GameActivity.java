package com.example.tictactoe2players;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {

    private FbModule fbModule;
    private BoardGame boardGame;
    private GameModule gameModule;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);
        boardGame = new BoardGame(this);
        setContentView(boardGame);

        fbModule = new FbModule(this);
        gameModule=new GameModule();
    }


    public void setPositionFromFb(Position position) {
        int line=position.getLine();
        int col=position.getCol();
        boardGame.setNewValOnBoard(line,col);
        int win=gameModule.isWin(boardGame.arr);
        if( win==1 )
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show();
            
        if(win==0)
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show();
    }

    public void setNewTouch(int line, int col) {
        Position position = new Position(line,col);
        fbModule.setPositionInFirebase(position);
    }
}