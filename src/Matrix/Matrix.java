package Matrix;

public class Matrix {
	double[][] data;
	int row;
	int col;

	/**
	 * 创建并初始化一个矩阵类
	 * 
	 * @param data
	 * @param row
	 * @param col
	 */

	public Matrix(double[][] data, int row, int col) {
		this.data = data;
		this.row = row;
		this.col = col;
	}

	/**
	 * 获取矩阵的行和列
	 * 
	 * @return
	 */
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	/**
	 * 将已知位置的数据写入
	 * 
	 * @param row
	 * @param col
	 * @param value
	 */
	public void setMatrix(int row, int col, double value) {

		this.data[row - 1][col - 1] = value;

	}

	/**
	 * 读取已知位置的数据
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public double getMatrix(int row, int col) {

		return data[row][col];

	}

	@Override
	public String toString() {
		String returnString = new String();
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				returnString = returnString + " " + (data[i][j]);
			}
			returnString = returnString + "\n";
		}
		// System.out.println(returnString);
		return returnString;
	}

	/**
	 * 进行加法运算
	 * 
	 * @param matrix
	 * @return
	 */
	public Matrix add(Matrix matrix) {
		if (this.row == matrix.getRow() && this.col == matrix.getCol()) {
			double[][] addData = new double[this.row][this.col];
			for (int i = 0; i < this.row; i++) {
				for (int j = 0; j < this.col; j++) {
					addData[i][j] = this.data[i][j] + matrix.data[i][j];
				}
			}

			return new Matrix(addData, this.row, this.col);
		} else {
			System.out.println("矩阵运算不合法");
			return null;
		}

	}

	/**
	 * 矩阵乘法
	 * @param matrix
	 * @return
	 */
	public Matrix multiply(Matrix matrix) {
		if (this.col != matrix.row) {
			System.out.println("不合法");
			return null;
		}
		double mul[][] = new double[this.row][matrix.col];
		double temp = 0;
		for (int i = 0; i < this.row; i++) {
			for (int k = 0; k < matrix.col; k++) {
				for (int j = 0; j < this.col; j++) {
					temp += this.data[i][j] * matrix.data[j][k];
				}
				mul[i][k] = temp;
				temp = 0;
			}
		}
//		System.out.println("after multiply:");
		return new Matrix(mul, this.row, matrix.col);
	}
	
	public Matrix transpose() {
        double tran[][] = new double[this.col][this.row];
        for(int i = 0;i<this.row;i++) {
            for(int j = 0;j<this.col;j++) {
                tran[j][i] = this.data[i][j];
            }
        }
        Matrix another = new Matrix(tran,this.col, this.row);
        //System.out.println("after transpose:");
        return another;
    }

	

}
