package com.example.tictactoe2players;

public class GameModule {
    public int isWin(Cell[][]arr){
        for (int line = 0; line<3; line++){
            if(arr[line][0].getVal()==arr[line][1].getVal() && arr[line][0].getVal()==arr[line][2].getVal() && arr[line][0].getVal()!=2){
                return arr[line][0].getVal();
            }
        }

        for (int col = 0; col<3; col++){
            if(arr[0][col].getVal()==arr[1][col].getVal() && arr[0][col].getVal()==arr[2][col].getVal() && arr[0][col].getVal()!=2){
                return arr[0][col].getVal();
            }
        }

        if(arr[0][0].getVal()==arr[1][1].getVal() && arr[0][0].getVal()==arr[2][2].getVal() && arr[0][0].getVal()!=2){
            return arr[0][0].getVal();
        }
        else if(arr[0][2].getVal()==arr[1][1].getVal() && arr[0][2].getVal()==arr[2][0].getVal() && arr[0][2].getVal()!=2){
            return arr[0][2].getVal();
        }

        return 2;
    }

}
