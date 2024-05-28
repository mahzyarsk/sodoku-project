package com.example.sodoco;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Sodoku_controller {

    public static boolean set = false;
    public int[] temp;

    private TextField[] textFields = new TextField[99];
    public TextField T11, T12, T13, T14, T15, T16, T17, T18, T19, T21, T22, T23, T24, T25, T26, T27, T28, T29, T31, T32, T33, T34, T35, T36, T37, T38, T39, T41, T42, T43, T44, T45, T46, T47, T48, T49, T51, T52, T53, T54, T55, T56, T57, T58, T59, T61, T62, T63, T64, T65, T66, T67, T68, T69, T71, T72, T73, T74, T75, T76, T77, T78, T79, T81, T82, T83, T84, T85, T86, T87, T88, T89, T91, T92, T93, T94, T95, T96, T97, T98, T99;


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
}