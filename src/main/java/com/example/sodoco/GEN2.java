package com.example.sodoco;

public class GEN2 {
    private  int gen[][] =new int[9][9];
    private  int generation;
    private  int fitness;

    public GEN2(int[][] gen, int generation, int fitness) {
        this.gen = gen;
        this.generation = generation;
        this.fitness = fitness;
    }

    public int[][] getGen() {
        return gen;
    }

    public void setGen(int[][] gen) {
        this.gen = gen;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }


}
