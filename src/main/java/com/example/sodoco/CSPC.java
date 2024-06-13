package com.example.sodoco;

public class CSPC {
    private  int gen[][] =new int[9][9];
    private  int first;
    private  int fitness;

    public CSPC(int[][] gen, int generation, int fitness) {
        this.gen = gen;
        this.first = generation;
        this.fitness = fitness;
    }

    public int[][] getGen() {
        return gen;
    }

    public void setGen(int[][] gen) {
        this.gen = gen;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }


}
