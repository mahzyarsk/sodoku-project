package com.example.sodoco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Genetic2 {
    public static int gtable[][] =new int[9][9];
    public static Sodoku_controller s;
    public static  GEN2 G;
    public static ArrayList<GEN2> Generation = new ArrayList<>();

    public static int generation =1000000;
    public static void genetic(int table[]) {
        Random random = new Random();

        int min = 1; // Minimum value of range
        int max = 9; // Maximum value of range
        for (int k = 0; k < generation; k++) {
            int a =0;
            for (int i = 0; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    gtable[i][j] = table[a];
                    a++;
                }
            }
            for (int i = 0; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    if(  gtable[i][j] == 0){
                        gtable[i][j] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            int[][] gtableCopy = new int [9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    gtableCopy[i][j] = gtable[i][j];
                }
            }
            G = new GEN2(gtableCopy, k, Fitness(gtableCopy));
            Generation.add(G);
        }
       // p();
        Collections.sort(Generation, Comparator.comparing(GEN2::getFitness));

        Crossover();

    }
    public static void p(){
        for (int i = 0; i < Generation.size(); i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    System.out.print(Generation.get(i).getGen()[j][k]);
                }
            }
            System.out.println();
        }
    }
    public static void Crossover(){
        if (generation <= 5) {
            return;
        }
        for (int i = 0; i < generation -10; i=i+2){
            int[][] genes1 = Generation.get(i).getGen();
            int[][] genes2 = Generation.get(i + 1).getGen();
            int[][] genes3 = Generation.get(i+2).getGen();
            int[][] genes4 = Generation.get(i +1).getGen();
            for (int j = 0; j < 9; j++) {
                for (int k = 3; k < 9; k++) {
                    int temp = genes4[j][k];
                    genes4[j][k] = genes3[j][k];
                    genes3[j][k] = temp;
                }
            }
            for (int j = 0; j < 9; j++) {
                for (int k = 4; k < 9; k++) {
                    int temp = genes1[j][k];
                    genes1[j][k] = genes2[j][k];
                    genes2[j][k] = temp;
                }
            }

            Generation.get(i+1).setGen(genes4);
            Generation.get(i+1).setFitness(Fitness(genes4));
            Generation.get(i).setGen(genes1);
            Generation.get(i).setFitness(Fitness(genes1));
            if (Generation.get(i).getFitness() == 0) {
                System.out.println("تناسب بهینه در اندیس " + i + " حاصل شد");
                return;
            }
        }
        Collections.sort(Generation, Comparator.comparing(GEN2::getFitness));
        for (int i = 0; i < generation / 2; i++){
            System.out.println("فرد " + i + " تناسب: " + Generation.get(i).getFitness());
        }
        generation = generation/2;
        Crossover();
    }
    public static int Fitness(int ftable[][]){
        int fitness =0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if(ftable[i][j] == ftable[i][k]){
                        fitness++;
                    }
                }

                for (int k = 0; k < 9; k++) {
                    if(ftable[i][j] == ftable[k][j]){
                        fitness++;
                    }
                }
                fitness= fitness -2;
            }
        }
        return fitness;
    }

}
