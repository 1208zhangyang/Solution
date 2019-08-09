package Matrix;

public class ComplementMinor {
	/**
	 * 求矩阵在i,j处余子阵
	 * 
	 * @param mat
	 * @param i
	 * @param j
	 * @return
	 */
	public static Matrix getComplementMinor(Matrix mat, int i, int j) {
		// 创建一个新的矩阵用于接收表示该余子式，需删除本行本列的数值
		// Matrix m = new Matrix(mat.getRow()-1,mat.getCol()-1);
		// 用于遍历新矩阵m的变量
		double[][] complementMinorData = new double[mat.row - 1][mat.col - 1];
		int complementMinorRow = 0;
		int complementMinorCol = 0;
		for (int k = 0; k < mat.row; k++) {
			if (k == i) {
				continue;
			} else {

				for (int k2 = 0; k2 < mat.col; k2++) {
					if (k2 == j) {
						continue;
					} else {
						complementMinorData[complementMinorRow][complementMinorCol] = mat.data[k][k2];
						// System.out.println(mat.data[k][k2] + " " + k + " " + k2);
						// System.out.println(complementMinorRow + " " + complementMinorCol);
						complementMinorCol++;
					}
				}
				complementMinorRow++;
				complementMinorCol = 0;
			}
		}
		return new Matrix(complementMinorData, mat.row - 1, mat.col - 1);
	}

	/**
	 * 求矩阵的行列式的值
	 * 
	 * @param mat
	 * @return
	 */
	public static double getMatrixValue(Matrix mat) {
		if (mat.getRow() != mat.getCol()) {
			System.out.println("该矩阵不是方阵，没有行列式");
			return Double.MIN_VALUE;
		}
		// 若为1*1矩阵则直接返回
		if (mat.getRow() == 1) {
			return mat.getMatrix(0, 0);
		}
		// 若为2*2矩阵则直接计算返回结果
		if (mat.getRow() == 2) {
			// System.out.println(mat.getMatrix(0, 0) * mat.getMatrix(1, 1) -
			// mat.getMatrix(0, 1) * mat.getMatrix(1, 0));
			return mat.getMatrix(0, 0) * mat.getMatrix(1, 1) - mat.getMatrix(0, 1) * mat.getMatrix(1, 0);
		}
		// 行列式的值
		double matrixValue = 0;
		for (int i = 0; i < mat.getCol(); i++) {
			// 获取0，i位置的余子式，即第一行的余子式
			Matrix m = getComplementMinor(mat, 0, i);
			// System.out.println(m);
			// 将第一行的余子式相加 ，递归下去
			matrixValue += Math.pow(-1, i) * mat.getMatrix(0, i) * getMatrixValue(m);

		}
		// System.out.println(matrixValue);
		return matrixValue;
	}

	/**
	 * 求矩阵的伴随矩阵
	 * 
	 * @param mat
	 * @return
	 */
	public static Matrix getWithMatrix(Matrix mat) {
		// 创建一个矩阵存放伴随矩阵的值
		double[][] withMatrixData = new double[mat.row][mat.col];
		// 遍历withMatrix存放对应的mat的值
		for (int i = 0; i < mat.getRow(); i++) {
			for (int j = 0; j < mat.getCol(); j++) {
				withMatrixData[i][j] = Math.pow(-1, i + j) * getMatrixValue(getComplementMinor(mat, i, j));
			}
		}
		// 得到余子矩阵
		Matrix complementMinor = new Matrix(withMatrixData, mat.row, mat.col);
		// 返回结果，余子矩阵转置为伴随矩阵
		return complementMinor.transpose();
	}

	/**
	 * 求逆矩阵
	 * 
	 * @param mat
	 * @return
	 */
	public static Matrix getReMatrix(Matrix mat) {
		// 创建一个矩阵接收逆矩阵数据
		// Matrix reMatrix = new Matrix(mat.getRow(),mat.getCol());
		double[][] reMatrixData = new double[mat.row][mat.col];
		// 得到原矩阵行列式的值
		double value = getMatrixValue(mat);
		// 判断矩阵行列式的值是否为零
		if (Math.abs(value) <= 10e-6) {
			System.out.println("该矩阵不可逆！");
			return null;
		}
		// 将原矩阵mat赋值除以原行列式的值value给逆矩阵
		for (int i = 0; i < mat.getRow(); i++) {
			for (int j = 0; j < mat.getCol(); j++) {
				reMatrixData[i][j] = (getWithMatrix(mat).getMatrix(i, j) / value);
			}
		}
		return new Matrix(reMatrixData, mat.row, mat.col);

	}
}
