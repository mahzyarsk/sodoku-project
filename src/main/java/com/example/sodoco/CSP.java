package com.example.sodoco;

import java.util.ArrayList;
import java.util.Random;

public class CSP {
    public static int gtable[][] =new int[9][9];
    public static ArrayList<Integer> possible = new ArrayList<>();
    public static ArrayList<CSPC> CspNode = new ArrayList<>();
    public static CSPC C ;
    public static int node = 0  , level =0;
    public static void Csp(int table[]){
        int a =0;
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                gtable[i][j] = table[a];
                a++;
            }
        }
        C = new CSPC(gtable,0 ,Fitness(gtable));
        CspNode.add(C);
        slove();

    }
    public static void slove(){
        int tabel[][] = CspNode.get(node).getGen();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if(tabel[i][j]==0){
                    tabel[i][j]=Possivlemove(tabel,i,j);
                }
            }

        }
        C = new CSPC(tabel,1,Fitness(tabel));
        CspNode.add(C);
        System.out.println(Fitness(tabel));
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.println(CspNode.get(1).getGen()[i][j]);
//
//            }
//
//        }

    }
    public static int Possivlemove(int ptable[][] , int i , int j){
        Random random = new Random();
        possible.clear();
        possible.add(0);
        int f = Fitness(ptable) ,pnumber =0;
        for (int k = 1; k < 10; k++) {
            ptable[i][j]=k;
            if(Fitness(ptable) < f){
                possible.add(k);
                pnumber = k;

                f = Fitness(ptable);
            }

        }

        return possible.get(possible.size()-1);
    }
    public static int Fitness(int genes[][]){
        int fitness =0;
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10]; // 1 ta 9
            for (int j = 0; j < 9; j++) {
                int num = genes[i][j];
                if (num != 0) {
                    if (seen[num]) {
                        fitness++;
                    } else {
                        seen[num] = true;
                    }
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for (int i = 0; i < 9; i++) {
                int num = genes[i][j];
                if (num != 0) {
                    if (seen[num]) {
                        fitness++;
                    } else {
                        seen[num] = true;
                    }
                }
            }
        }
        return fitness;
    }


}
