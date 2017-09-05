
public class Individual {
	private char [] gene;
	private int fitness;
	
	public Individual() {
		gene = new char[Main.solution.length];
	}
	
	public void init() {
		for(int i = 0; i < gene.length; i++) {
			gene[i] = FitnessCalc.getRandom();
		}
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public char[] getGene() {
		return gene;
	}

	public void setGene(char[] gene) {
		this.gene = gene;
	}
	
}
