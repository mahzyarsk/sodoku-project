package com.example.sodoco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Genetic {
    public static int gtable[] =new int[81];
    public static Sodoku_controller s;
    public static  GEN G;

    public static int generation =400;
    public static ArrayList<GEN> Generation = new ArrayList<>();
    public static void genetic(int table[]) {


        int min = 1; // Minimum value of range
        int max = 9; // Maximum value of range

        for (int j = 0; j <= generation; j++) {
            for (int i = 0; i < gtable.length; i++) {
                gtable[i] = table[i];

            }


            for (int i = 0; i < gtable.length; i++) {
                if(gtable[i]==0){
                    gtable[i] = (int)Math.floor(Math.random() * (max - min + 1) + min);
                }
            }
            G =new GEN(gtable,j,Fitness(gtable));
            Generation.add(G);
            Collections.sort(Generation,Comparator.comparing(GEN::getFitness));

            System.out.println(Generation.get(j).getFitness());


        }


    }
    public static void mix(){

    }
    public static int Fitness(int ftable[]){
        int fitness =0;
        for (int i = 0; i < ftable.length; i++) {
            for (int j = i+1; j < ftable.length; j =j+ 9) {
                if(ftable[i]==ftable[j]){
                    fitness++;
                }
            }
            for (int j = i+1; j%10 < 9  && j < 81; j++) {
                if(ftable[i]==ftable[j]){
                    fitness++;
                }
            }

        }
        return fitness;

    }
}
