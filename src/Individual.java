
public class Individual {
	private byte [] gene;
	private int fitness;
	
	public Individual() {
		gene = new byte[Main.solution.length];
	}
	
	public void init() {
		for(int i = 0; i < gene.length; i++) {
			gene[i] = (byte)(Math.round(Math.random()));
		}
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public byte[] getGene() {
		return gene;
	}

	public void setGene(byte[] gene) {
		this.gene = gene;
	}
	
}
