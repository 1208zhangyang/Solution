package HIillClimbing;

public class HillClimbing {
	double X[][];
	double a[];
	double Y[];

	public HillClimbing(double[][] x, double[] y) {
		X = x;
		Y = y;
	}

	public void outputEquations() {
		System.out.println(X[0].length);
//		System.out.println(a.length);
		System.out.println(Y.length);
	}

	public void getFinalResult() {
	}
}
