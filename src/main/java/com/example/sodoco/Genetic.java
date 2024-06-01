package com.example.sodoco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Genetic {
    public static int gtable[] =new int[81];
    public static Sodoku_controller s;
    public static  GEN G;

    public static int generation =1000000;
    public static ArrayList<GEN> Generation = new ArrayList<>();
    public static void genetic(int table[]) {
        Random random = new Random();
        int min = 1; // Minimum value of range
        int max = 9; // Maximum value of range

        for (int j = 0; j <= generation; j++) {
            for (int i = 0; i < gtable.length; i++) {
                gtable[i] = table[i];
            }

            for (int i = 0; i < gtable.length; i++) {
                if (gtable[i] == 0) {
                    gtable[i] = random.nextInt(max - min + 1) + min;
                }
            }

            // Make a copy of gtable
            int[] gtableCopy = new int[gtable.length];
            System.arraycopy(gtable, 0, gtableCopy, 0, gtable.length);
            G = new GEN(gtableCopy, j, Fitness(gtableCopy));
            Generation.add(G);
        }
        Collections.sort(Generation, Comparator.comparing(GEN::getFitness));
        Crossover();
    }

    public static void Crossover() {

        if (generation <= 10) {
            return;
        }


        for (int i = 0; i < generation ; i=i+2) {
            int[] genes1 = Generation.get(i).getGen();
            int[] genes2 = Generation.get(i + 1).getGen();
            int[] genes3 = Generation.get(i+2).getGen();
            int[] genes4 = Generation.get(i +1).getGen();

            for (int j = 0; j < genes4.length / 2; j++) {
                int temp = genes4[j];
                genes4[j] = genes3[j];
                genes3[j] = temp;
            } for (int j = 0; j < genes1.length / 2; j++) {
                int temp = genes1[j];
                genes1[j] = genes2[j];
                genes2[j] = temp;
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


        Collections.sort(Generation, Comparator.comparing(GEN::getFitness));
        for (int i = 0; i < generation / 2; i++){
            System.out.println("فرد " + i + " تناسب: " + Generation.get(i).getFitness());
        }
        generation = generation-10000;
        Mutation();
        Crossover();
    }
    public static void Mutation(){
        Random random = new Random();
        int mutationRate = 20;
        for (int i = 0; i < Generation.get(1).getGen().length; i++) {
            int genes[] =Generation.get(i).getGen();
            if (random.nextInt(100) < mutationRate) {
                int newValue = random.nextInt(8) + 1;
                genes[i] = newValue;
                Generation.get(i).setGen(genes);
            }
        }


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
