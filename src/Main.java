public class Main {
	static Population p;
	static String str = "Netanel 1234567890";
	static char[] solution = str.toCharArray();

	public static void main(String[] args) {
		p = new Population(50);
		p.init();
		int itr = 0;
		while (FitnessCalc.getFittest(p).getFitness() < solution.length) {
			System.out.println(FitnessCalc.getFittest(p).getGene());
			p = FitnessCalc.nextGeneration(p);
			itr++;
			try {
				//Thread.sleep(100);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(FitnessCalc.getFittest(p).getGene());
		System.out.println("DONE!");
		System.out.println("Fitness: " + FitnessCalc.getFittest(p).getFitness());
		System.out.println("Itrations: " + itr);
	}
}
