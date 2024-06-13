package com.example.sodoco;

import java.util.*;

public class Genetic2 {
    public static int gtable[][] =new int[9][9];
    public static Sodoku_controller s;
    public static  GEN2 G;
    public static List<GEN2> Generation = new ArrayList<>();

    public static int generation =5000;
    public static void genetic(int table[]) {
        Random random = new Random();


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
                        gtable[i][j] =  random.nextInt(8)+1;
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
        Mutation();
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
    public static void Crossover() {
        Random random = new Random();
        if (generation <= 5) {
           // p();
            return;
        }
        ArrayList<GEN2> newGeneration = new ArrayList<>();
        for (int i = 0; i < generation - 2; i += 1) {
            int[][] genes1 = Generation.get(i).getGen();
            int[][] genes2 = Generation.get(i + 1).getGen();

            // Create offspring by combining parts of parents
            int[][] offspring1 = new int[9][9];
            int[][] offspring2 = new int[9][9];

            int CrossoverP = random.nextInt(8) + 1;

            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < CrossoverP; k++) {
                    offspring1[j][k] = genes1[j][k];
                    offspring2[j][k] = genes2[j][k];
                }
                for (int k = CrossoverP; k < 9; k++) {
                    offspring1[j][k] = genes2[j][k];
                    offspring2[j][k] = genes1[j][k];
                }
            }

            newGeneration.add(new GEN2(offspring1, generation, Fitness(offspring1)));
            newGeneration.add(new GEN2(offspring2, generation, Fitness(offspring2)));

            // Check for optimal fitness
            if (newGeneration.get(newGeneration.size() - 1).getFitness() == 0) {
                System.out.println("تناسب بهینه در اندیس " + i + " حاصل شد");
                return;
            }
            if (newGeneration.get(newGeneration.size() - 2).getFitness() == 0) {
                System.out.println("تناسب بهینه در اندیس " + (i + 1) + " حاصل شد");
                return;
            }
        }

        // Add new generation to the main generation list
        Generation.addAll(newGeneration);

        // Sort generation based on fitness
        Collections.sort(Generation, Comparator.comparing(GEN2::getFitness));

        // Keep only the top half of the generation
        Generation = Generation.subList(0, generation / 2);

        // Update generation count
        generation = Generation.size();

        // Display top half fitness values
        for (int i = 0; i < generation; i++) {
            System.out.println("فرد " + i + " تناسب: " + Generation.get(i).getFitness());
        }

      //  Mutation();
        Crossover();
    }
    public static void Mutation() {
        Random rand = new Random();
        int mutationRate = 10; // نرخ جهش به درصد، می‌توان آن را تنظیم کرد

        for (int i = 0; i < generation; i++) {
            int[][] genes = Generation.get(i).getGen();

            // اعمال جهش
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (rand.nextInt(100) < mutationRate) {
                        // تغییر تصادفی ژن در این مکان
                        genes[j][k] = rand.nextInt(10); // فرضاً عدد جدید بین 0 و 9 باشد
                    }
                }
            }

            Generation.get(i).setGen(genes);
            Generation.get(i).setFitness(Fitness(genes));
        }
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
