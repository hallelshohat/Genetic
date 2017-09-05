import java.util.Arrays;

public class FitnessCalc {
	
	static double mutationRate = 0.01;
	static int tournamentSize = 5;

	public static Population nextGeneration(Population pop) {
		Population p = new Population(pop.getInd().length);
		p.setIndividual(getFittest(pop), 0);
		for(int i = 1; i < pop.getInd().length; i++) {
			Individual i1 = tournament(tournamentSize, pop);
			Individual i2 = tournament(tournamentSize, pop);
			Individual child = crossover(i1, i2);
			p.setIndividual(mutation(child, mutationRate), i);
			p.getInd()[i].setFitness(calculateFitness(p.getInd()[i]));
		}
		return p;
	}

	public static Individual getFittest(Population pop) {
		Individual ret = pop.getInd()[0];
		for (int i = 0; i < pop.getInd().length; i++) {
			if (ret.getFitness() <= pop.getInd()[i].getFitness()) {
				ret = pop.getInd()[i];
			}
		}
		return ret;
	}
	
	public static Individual crossover(Individual parent1, Individual parent2) {
		Individual child = new Individual();
		char[] newGene = new char[parent1.getGene().length];
		for(int i = 0; i < newGene.length; i++) {
			newGene[i] = (Math.random() >= 0.5) ? parent1.getGene()[i] : parent2.getGene()[i];
		}
		child.setGene(newGene);
		return child;
	}
	
	public static Individual mutation(Individual ind, double rate) {
		Individual newInd = new Individual();
		char[] gene = new char[newInd.getGene().length];
		for(int i = 0; i < newInd.getGene().length; i++) {
			if(Math.random() <= rate) {
				gene[i] = FitnessCalc.getRandom();
			}else {
				gene[i] = ind.getGene()[i];				
			}
		}
		newInd.setGene(gene);
		return newInd;
	}

	public static Individual tournament(int size, Population pop) {
		Population temp = new Population(size);
		for (int i = 0; i < size; i++) {
			Individual ind = pop.getInd()[(int) (Math.random() * pop.getInd().length)];
			temp.setIndividual(ind, i);
		}
		return getFittest(temp);
	}

	public static int calculateFitness(Individual ind) {
		char[] gene = ind.getGene();
		int fitness = 0;
		for (int i = 0; i < gene.length; i++) {
			if (gene[i] == Main.solution[i]) {
				fitness++;
			}
		}
		return fitness;
	}
	public static char getRandom() {
		int ch = (int)(Math.random()*95) + 32;
		if (ch == 96) ch = 32;
		return (char) ch;
	}
}
