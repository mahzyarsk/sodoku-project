package com.example.sodoco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Genetic {
    public static int gtable[] =new int[81];
    public static Sodoku_controller s;
    public static  GEN G;

    public static int generation =150000;
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

            int[] gtableCopy = new int[gtable.length];
            System.arraycopy(gtable, 0, gtableCopy, 0, gtable.length);
            G = new GEN(gtableCopy, j, Fitness(gtableCopy));
            Generation.add(G);
        }
        Collections.sort(Generation, Comparator.comparing(GEN::getFitness));
        Crossover();
    }


    public static void Crossover() {
        Random random = new Random();
        if (generation <= 5 ) {
            return;
        }

        for (int i = 0; i < generation ; i=i+1) {
            if (Generation.get(i).getFitness() == 0) {
            System.out.println("تناسب بهینه در اندیس " + i + " حاصل شد");
            return;
        }
            int[] genes1 = Generation.get(i).getGen();
            int[] genes2 = Generation.get(i + 1).getGen();
            int[] genes3 =Generation.get(i+1).getGen();
            int[] genes4 = Generation.get(i + 2).getGen();


            for (int j = 0; j < genes4.length / 2; j++) {
                int temp = genes4[j];
                genes4[j] = genes3[j];
                genes3[j] = temp;
            } for (int j = genes1.length-1; j > genes1.length / 2; j--) {
                int temp = genes1[j];
                genes1[j] = genes2[j];
                genes2[j] = temp;
            }
            G = new GEN(genes4,generation,Fitness(genes4));
            Generation.add(G);
            G = new GEN(genes1,generation,Fitness(genes1));
            Generation.add(G);

//            Generation.get(i+1).setGen(genes4);
//            Generation.get(i+1).setFitness(Fitness(genes4));
//            Generation.get(i).setGen(genes1);
//            Generation.get(i).setFitness(Fitness(genes1));



        }


        Generation.sort(Comparator.comparing(GEN::getFitness));
        for (int i = 0; i < generation / 2; i++){
            System.out.println("فرد " + i + " تناسب: " + Generation.get(i).getFitness());
        }
        generation = (generation/2);
        //Mutation();
        Crossover();
    }
    public static void Mutation(){
        Random random = new Random();
        int mutationRate = 15;
        for (int i = 0; i < Generation.get(1).getGen().length; i++) {
            int genes[] =Generation.get(i).getGen();
            if (random.nextInt(100) < mutationRate) {
                int newValue = random.nextInt(8) + 1;
                genes[i] = newValue;
                Generation.get(i).setGen(genes);
            }
        }


    }
//    public static void Mutation() {
//        Random rand = new Random();
//        int mutationRate = 10; // نرخ جهش به درصد، می‌توان آن را تنظیم کرد
//
//        for (int i = 0; i < generation; i++) {
//            int[] genes = Generation.get(i).getGen();
//
//            // اعمال جهش
//            for (int j = 0; j < genes.length; j++) {
//                if (rand.nextInt(100) < mutationRate) {
//                    // تغییر تصادفی ژن در این مکان
//                    genes[j] = rand.nextInt(10); // فرضاً عدد جدید بین 0 و 9 باشد
//                }
//            }
//
//            Generation.get(i).setGen(genes);
//            Generation.get(i).setFitness(Fitness(Generation.get(i).getGen()));
//        }
//    }

    public static int Fitness(int ftable[]) {
        int fitness = 0;

        // satr
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                for (int k = col + 1; k < 9; k++) {
                    if (ftable[row * 9 + col] == ftable[row * 9 + k]) {
                        fitness++;
                    }
                }
            }
        }

        // sotoon
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                for (int k = row + 1; k < 9; k++) {
                    if (ftable[row * 9 + col] == ftable[k * 9 + col]) {
                        fitness++;
                    }
                }
            }
        }

        return fitness;
    }
}
