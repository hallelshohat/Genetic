import java.util.Arrays;

public class Main {
	static Population p;
	static byte[] solution = new byte[1000];

	public static void main(String[] args) {
		for (int i = 0; i < solution.length; i++) {
			solution[i] = (byte) Math.round(Math.random());
		}

		p = new Population(10);
		p.init();
		int itr = 0;
		while (FitnessCalc.getFittest(p).getFitness() < solution.length) {
			System.out.println(FitnessCalc.getFittest(p).getFitness());
			p = FitnessCalc.nextGeneration(p);
			itr++;
		}
		System.out.println(FitnessCalc.getFittest(p).getFitness() + " DONE!");
		System.out.println("Itrations: " + itr);
	}
}
