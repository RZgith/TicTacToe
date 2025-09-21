package com.example.tictactoe2players;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Cell {

    final int Xval=0;
    final int Oval=1;
    final int EmptyVal=2;
    private int x,y;
    private int cellWidth;
    Bitmap bitmapX,bitmetO;
    private int val;
    private Paint p;


    public Cell(int y, int x, Bitmap bitmapX, Bitmap bitmetO, int cellWidth) {
        this.y = y;
        this.x = x;
        this.cellWidth = cellWidth;
        this.bitmapX = bitmapX;
        this.bitmetO = bitmetO;
        this.val=EmptyVal;
        this.p=new Paint();
    }
    public void draw(Canvas canvas){

        p.setStrokeWidth(30);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawRect(x,y,x+cellWidth,y+cellWidth,p);
        if(val==Xval)
            canvas.drawBitmap(bitmapX,x+10,y+10,null);
        if (val==Oval)
            canvas.drawBitmap(bitmetO,x+10,y+10,null);

    }

    public int getVal() {
        return val;
    }

    public boolean isEmpty() {
        return val==EmptyVal;
    }

    public boolean setVal(int val) {
        if(this.val==EmptyVal)
        {
            this.val=val;
            return true;
        }
        return false;
    }
}
