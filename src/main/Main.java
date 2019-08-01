package main;

import Matrix.ComplementMinor;
import Matrix.Matrix;

public class Main {
	public static void main(String[] args) {
		double[][] a = { { 10000 }, { 12000 } };
		double[][] b = { { 1, 200, 300,102.1 }, { 1, 302, 313, 200 } };
		Matrix m = new Matrix(a, 2, 1);
		Matrix mat = new Matrix(b, 2, 4);
		System.out.println(mat.toString());
		// System.out.println(ComplementMinor.getComplementMinor(mat, 0, 2).toString());
		// ComplementMinor.getComplementMinor(mat, 1, 2);
		// System.out.println(ComplementMinor.getMatrixValue(mat));
		// System.out.println(ComplementMinor.getReMatrix(mat));
/*		System.out.println(mat.transpose().multiply(mat));
		System.out.println(ComplementMinor.getMatrixValue(mat.transpose().multiply(mat)));
		System.out.println(ComplementMinor.getReMatrix(mat.transpose().multiply(mat)));
		Matrix temp= ComplementMinor.getReMatrix(mat.transpose().multiply(mat));
		Matrix multemp= temp.multiply(mat.transpose());
		System.out.println(multemp.multiply(m));*/
		double[][] X = { { 1, 200, 300,102.1 }, { 1, 302, 313, 200 } };
		double[]Y= {1,2,5,3};
		//double[]
		new HIillClimbing.HillClimbing(X, Y).outputEquations();
	}
}
