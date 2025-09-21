package com.example.tictactoe2players;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class BoardGame extends View {
    private Context context;
    Cell[][] arr;
    GameModule gameModule;
    private int count=0;
    private boolean isFirstTime=true;
    private int cellWidth, cellHieght;
    public BoardGame(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        //Paint p = new Paint();
        //canvas.drawCircle(200,200,100,p);
        if (isFirstTime)
        {
            cellWidth=canvas.getWidth()/3;
            cellHieght=cellWidth;
            Bitmap bitmapX= BitmapFactory.decodeResource(getResources(),R.drawable.x);
            Bitmap bitmapO= BitmapFactory.decodeResource(getResources(),R.drawable.o);
            bitmapX=Bitmap.createScaledBitmap(bitmapX,cellWidth-10,cellWidth-10,false);
            bitmapO=Bitmap.createScaledBitmap(bitmapO,cellWidth-10,cellWidth-10,false);
            arr=new Cell[3][3];
            for (int line = 0; line < 3; line++) {
                for (int col = 0; col < 3; col++) {
                    arr[line][col]=new Cell(line*cellWidth,col*cellHieght,bitmapX,bitmapO,cellWidth);
                }
            }

            isFirstTime=false;

        }
        for (int line = 0; line < 3; line++) {
            for (int col = 0; col < 3; col++) {
                arr[line][col].draw(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            float x = event.getX();
            float y = event.getY();
            /*int win=gameModule.isWin(arr);
            if( win==1 )
                 Toast.makeText(context, "O win", Toast.LENGTH_SHORT).show();
            if(win==0)
                Toast.makeText(context, "X win", Toast.LENGTH_SHORT).show(); */

            int line=(int)(y/cellWidth);
            int col=(int)(x/cellWidth);
            if(line<3&col<3)
            {
                if(arr[line][col].isEmpty())
                {

                    ((GameActivity)context).setNewTouch(line,col);


                }
                else {
                    Toast.makeText(context, "Not Empty", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(context, "outside of borders", Toast.LENGTH_SHORT).show();
                return false;

            }





        }


        return false;
    }

    public void setNewValOnBoard(int line, int col) {
        if(arr[line][col].setVal(count)==true)
            count=1-count;
        invalidate();//clears the canvas and redraws it by calling inDraw


    }
}
