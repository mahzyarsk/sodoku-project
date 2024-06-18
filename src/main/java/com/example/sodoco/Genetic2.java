package com.example.sodoco;

import java.util.*;

public class Genetic2 {
    public static int gtable[][] =new int[9][9];
    public static Sodoku_controller s;
    public static  GEN2 G;
    public static List<GEN2> Generation = new ArrayList<>();
    public static ArrayList<Integer> Number = new ArrayList<>();

    public static int generation =5000;
    public static void genetic(int table[]) {
        for (int r = 1; r <10; r++) {
        Number.add(r);
    }
        for (int k = 0; k <= generation; k++) {
            int a =0;

            for (int i = 0; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    gtable[i][j] = table[a];
                    a++;
                }
            }

            for (int i = 0; i < 9; i++) {
                Shufflelist(Number);
                for (int j = 0; j < 9; j++) {
                    if (gtable[i][j] == 0) {
                        gtable[i][j] = Number.get(j);
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
       // Mutation();
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
            Sodoku_controller s = new Sodoku_controller();
            s.Panswer(Generation.get(0).getGen());
            return;
        }
        ArrayList<GEN2> newGeneration = new ArrayList<>();
        for (int i = 0; i < generation - 2; i += 1) {
            int[][] genes1 = Generation.get(i).getGen();
            int[][] genes2 = Generation.get(i + 1).getGen();
            int[][] kid1 = new int[9][9];
            int[][] kid2 = new int[9][9];
            int CrossoverP = random.nextInt(8) + 1;
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < CrossoverP; k++) {
                    kid1[j][k] = genes1[j][k];
                    kid2[j][k] = genes2[j][k];
                }
                for (int k = CrossoverP; k < 9; k++) {
                    kid1[j][k] = genes2[j][k];
                    kid2[j][k] = genes1[j][k];
                }
            }
            newGeneration.add(new GEN2(kid1, generation, Fitness(kid1)));
            newGeneration.add(new GEN2(kid2, generation, Fitness(kid2)));
            if (newGeneration.get(newGeneration.size() - 1).getFitness() == 0) {
                System.out.println("تناسب بهینه در اندیس " + i + " حاصل شد");
                return;
            }
            if (newGeneration.get(newGeneration.size() - 2).getFitness() == 0) {
                System.out.println("تناسب بهینه در اندیس " + (i + 1) + " حاصل شد");
                return;
            }
        }
        // ezafe kardan
        Generation.addAll(newGeneration);
        //sort
        Collections.sort(Generation, Comparator.comparing(GEN2::getFitness));
        // delet gen be arzesh
        Generation = Generation.subList(0, generation / 2);
        generation = Generation.size();
        for (int i = 0; i < generation; i++) {
            System.out.println("فرد " + i + " تناسب: " + Generation.get(i).getFitness());
        }

      //  Mutation();
        Crossover();
    }
    public static void Mutation() {
        Random rand = new Random();
        int mutationRate = 10;
        for (int i = 0; i < generation; i++) {
            int[][] genes = Generation.get(i).getGen();
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (rand.nextInt(100) < mutationRate) {
                        genes[j][k] = rand.nextInt(8)+1;
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

    public static void Shufflelist(ArrayList<Integer> list) {
        Random rand = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

}
