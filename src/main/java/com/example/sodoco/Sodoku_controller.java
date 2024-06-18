package com.example.sodoco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Sodoku_controller {
    public static boolean set = false;
    public static int answer[][];
    public int[] temp;
    public static int a=0;
    @FXML public TextField T11, T12, T13, T14, T15, T16, T17, T18, T19, T21, T22, T23, T24, T25, T26, T27, T28, T29, T31, T32, T33, T34, T35, T36, T37, T38, T39, T41, T42, T43, T44, T45, T46, T47, T48, T49, T51, T52, T53, T54, T55, T56, T57, T58, T59, T61, T62, T63, T64, T65, T66, T67, T68, T69, T71, T72, T73, T74, T75, T76, T77, T78, T79, T81, T82, T83, T84, T85, T86, T87, T88, T89, T91, T92, T93, T94, T95, T96, T97, T98, T99;
    @FXML
    public void initialize() {
        if(a!=0){
            T11.setText(String.valueOf(answer[0][0]));
            T12.setText(String.valueOf(answer[0][1]));
            T13.setText(String.valueOf(answer[0][2]));
            T14.setText(String.valueOf(answer[0][3]));
            T15.setText(String.valueOf(answer[0][4]));
            T16.setText(String.valueOf(answer[0][5]));
            T17.setText(String.valueOf(answer[0][6]));
            T18.setText(String.valueOf(answer[0][7]));
            T19.setText(String.valueOf(answer[0][8]));
            T21.setText(String.valueOf(answer[1][0]));
            T22.setText(String.valueOf(answer[1][1]));
            T23.setText(String.valueOf(answer[1][2]));
            T24.setText(String.valueOf(answer[1][3]));
            T25.setText(String.valueOf(answer[1][4]));
            T26.setText(String.valueOf(answer[1][5]));
            T27.setText(String.valueOf(answer[1][6]));
            T28.setText(String.valueOf(answer[1][7]));
            T29.setText(String.valueOf(answer[1][8]));
            T31.setText(String.valueOf(answer[2][0]));
            T32.setText(String.valueOf(answer[2][1]));
            T33.setText(String.valueOf(answer[2][2]));
            T34.setText(String.valueOf(answer[2][3]));
            T35.setText(String.valueOf(answer[2][4]));
            T36.setText(String.valueOf(answer[2][5]));
            T37.setText(String.valueOf(answer[2][6]));
            T38.setText(String.valueOf(answer[2][7]));
            T39.setText(String.valueOf(answer[2][8]));
            T41.setText(String.valueOf(answer[3][0]));
            T42.setText(String.valueOf(answer[3][1]));
            T43.setText(String.valueOf(answer[3][2]));
            T44.setText(String.valueOf(answer[3][3]));
            T45.setText(String.valueOf(answer[3][4]));
            T46.setText(String.valueOf(answer[3][5]));
            T47.setText(String.valueOf(answer[3][6]));
            T48.setText(String.valueOf(answer[3][7]));
            T49.setText(String.valueOf(answer[3][8]));
            T51.setText(String.valueOf(answer[4][0]));
            T52.setText(String.valueOf(answer[4][1]));
            T53.setText(String.valueOf(answer[4][2]));
            T54.setText(String.valueOf(answer[4][3]));
            T55.setText(String.valueOf(answer[4][4]));
            T56.setText(String.valueOf(answer[4][5]));
            T57.setText(String.valueOf(answer[4][6]));
            T58.setText(String.valueOf(answer[4][7]));
            T59.setText(String.valueOf(answer[4][8]));
            T61.setText(String.valueOf(answer[5][0]));
            T62.setText(String.valueOf(answer[5][1]));
            T63.setText(String.valueOf(answer[5][2]));
            T64.setText(String.valueOf(answer[5][3]));
            T65.setText(String.valueOf(answer[5][4]));
            T66.setText(String.valueOf(answer[5][5]));
            T67.setText(String.valueOf(answer[5][6]));
            T68.setText(String.valueOf(answer[5][7]));
            T69.setText(String.valueOf(answer[5][8]));
            T71.setText(String.valueOf(answer[6][0]));
            T72.setText(String.valueOf(answer[6][1]));
            T73.setText(String.valueOf(answer[6][2]));
            T74.setText(String.valueOf(answer[6][3]));
            T75.setText(String.valueOf(answer[6][4]));
            T76.setText(String.valueOf(answer[6][5]));
            T77.setText(String.valueOf(answer[6][6]));
            T78.setText(String.valueOf(answer[6][7]));
            T79.setText(String.valueOf(answer[6][8]));
            T81.setText(String.valueOf(answer[7][0]));
            T82.setText(String.valueOf(answer[7][1]));
            T83.setText(String.valueOf(answer[7][2]));
            T84.setText(String.valueOf(answer[7][3]));
            T85.setText(String.valueOf(answer[7][4]));
            T86.setText(String.valueOf(answer[7][5]));
            T87.setText(String.valueOf(answer[7][6]));
            T88.setText(String.valueOf(answer[7][7]));
            T89.setText(String.valueOf(answer[7][8]));
            T91.setText(String.valueOf(answer[8][0]));
            T92.setText(String.valueOf(answer[8][1]));
            T93.setText(String.valueOf(answer[8][2]));
            T94.setText(String.valueOf(answer[8][3]));
            T95.setText(String.valueOf(answer[8][4]));
            T96.setText(String.valueOf(answer[8][5]));
            T97.setText(String.valueOf(answer[8][6]));
            T98.setText(String.valueOf(answer[8][7]));
            T99.setText(String.valueOf(answer[8][8]));
        }
        a++;

    }

    public void Next_BTN(ActionEvent event) {
        if (set){
            Genetic g =new Genetic();
            g.genetic(temp);
        }

    }

    public void Set_BTN(ActionEvent event) {
        if(!set){
            final int table[] = new int[]{Integer.parseInt(T11.getText()), Integer.parseInt(T12.getText()), Integer.parseInt(T13.getText()), Integer.parseInt(T14.getText()), Integer.parseInt(T15.getText()), Integer.parseInt(T16.getText()), Integer.parseInt(T17.getText()), Integer.parseInt(T18.getText()), Integer.parseInt(T19.getText()), Integer.parseInt(T21.getText()), Integer.parseInt(T22.getText()), Integer.parseInt(T23.getText()), Integer.parseInt(T24.getText()), Integer.parseInt(T25.getText()), Integer.parseInt(T26.getText()), Integer.parseInt(T27.getText()), Integer.parseInt(T28.getText()), Integer.parseInt(T29.getText()), Integer.parseInt(T31.getText()), Integer.parseInt(T32.getText()), Integer.parseInt(T33.getText()), Integer.parseInt(T34.getText()), Integer.parseInt(T35.getText()), Integer.parseInt(T36.getText()), Integer.parseInt(T37.getText()), Integer.parseInt(T38.getText()), Integer.parseInt(T39.getText()), Integer.parseInt(T41.getText()), Integer.parseInt(T42.getText()), Integer.parseInt(T43.getText()), Integer.parseInt(T44.getText()), Integer.parseInt(T45.getText()), Integer.parseInt(T46.getText()), Integer.parseInt(T47.getText()), Integer.parseInt(T48.getText()), Integer.parseInt(T49.getText()), Integer.parseInt(T51.getText()), Integer.parseInt(T52.getText()), Integer.parseInt(T53.getText()), Integer.parseInt(T54.getText()), Integer.parseInt(T55.getText()), Integer.parseInt(T56.getText()), Integer.parseInt(T57.getText()), Integer.parseInt(T58.getText()), Integer.parseInt(T59.getText()), Integer.parseInt(T61.getText()), Integer.parseInt(T62.getText()), Integer.parseInt(T63.getText()), Integer.parseInt(T64.getText()), Integer.parseInt(T65.getText()), Integer.parseInt(T66.getText()), Integer.parseInt(T67.getText()), Integer.parseInt(T68.getText()), Integer.parseInt(T69.getText()), Integer.parseInt(T71.getText()), Integer.parseInt(T72.getText()), Integer.parseInt(T73.getText()), Integer.parseInt(T74.getText()), Integer.parseInt(T75.getText()), Integer.parseInt(T76.getText()), Integer.parseInt(T77.getText()), Integer.parseInt(T78.getText()), Integer.parseInt(T79.getText()), Integer.parseInt(T81.getText()), Integer.parseInt(T82.getText()), Integer.parseInt(T83.getText()), Integer.parseInt(T84.getText()), Integer.parseInt(T85.getText()), Integer.parseInt(T86.getText()), Integer.parseInt(T87.getText()), Integer.parseInt(T88.getText()), Integer.parseInt(T89.getText()), Integer.parseInt(T91.getText()), Integer.parseInt(T92.getText()), Integer.parseInt(T93.getText()), Integer.parseInt(T94.getText()), Integer.parseInt(T95.getText()), Integer.parseInt(T96.getText()), Integer.parseInt(T97.getText()), Integer.parseInt(T98.getText()), Integer.parseInt(T99.getText())};
            set=true;
            temp = table;
        }



    }

    public void Gen_BTN(ActionEvent event) {
        if (set){
            Genetic2 g =new Genetic2();
            g.genetic(temp);
        }
    }

    public void Csp_BTN(ActionEvent event) {
        if (set){
            CSP g =new CSP();
            g.Csp(temp);
        }
    }
    public void Panswer(int javab[][]){
        for (int i = 0; i < javab.length; i++) {
            for (int j = 0; j < javab[i].length; j++) {
                System.out.print(javab[i][j] + "\t");
            }
            System.out.println();
        }
      //  initialize();
    }
}