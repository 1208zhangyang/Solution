package HIillClimbing;

public class HillClimbing {
	double x[][];
	double a[];// 解集
	double y[];

	public HillClimbing(double[][] x, double[] y) {
		this.x = x;
		this.y = y;
		this.a = new double[x[0].length];
		for (int i = 0; i < a.length; i++) {
			a[i] = 1;
		}
	}

	public void outputEquations() {
//		System.out.println(x[0].length);
//		System.out.println(a.length);
//		System.out.println(y.length);
		for (int i = 0; i < x.length; i++) {
			System.out.print(y[i] + "=");
			for (int j = 0; j < x[i].length; j++) {
				System.out.print(x[i][j] + "  ");
			}
			System.out.println();
		}

	}

	public void getFinalResult() {
		double oldError;
		// 寻找最优平均解
		do {
			oldError = getError();
			// System.out.println(getError());
			for (int i = 0; i < a.length; i++) {
				a[i]++;
			}
		} while (oldError > getError());
		// System.out.println(getError());
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i] + " ");
//			a[i]--;
//		}
		// 此时得到的a为最有平均解
		// 开始寻找局部最优解
		for (int i = 0; i < a.length; i++) {
			do {
				oldError = getError();
				// System.out.println(getError());
				a[i]++;
			} while (oldError > getError());
			// System.out.println(getError());
			a[i]--;

			do {
				oldError = getError();
				System.out.println(getError());
				a[i]--;
			} while (oldError > getError()&&a[i]>0);
			// System.out.println(getError());
			a[i]++;
		}
		// 得到局部最优解
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public double getError() {
		double error = 0;
		double linshi = 0;
		for (int i = 0; i < x.length; i++) {
			linshi = 0;
			for (int j = 0; j < x[i].length; j++) {
				linshi += a[j] * x[i][j];
				// System.out.print(a[j] +"*"+ x[i][j]+" ");
			}
			// System.out.println("临时数据："+linshi);
			error += (Math.abs(y[i] - linshi) / y[i]);
		}
		// System.out.println(error);
		return error;
	}
}
