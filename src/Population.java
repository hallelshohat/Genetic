
public class Population {
	private Individual[] ind;

	public Population(int size) {
		ind = new Individual[size];
	}
	
	public void init() {
		for(int i = 0; i < ind.length; i++) {
			ind[i] = new Individual();
			ind[i].init();
			ind[i].setFitness(FitnessCalc.calculateFitness(ind[i]));
		}
	}

	public Individual[] getInd() {
		return ind;
	}

	public void setIndividual(Individual ind, int place) {
		this.ind[place] = ind;
	}
}
