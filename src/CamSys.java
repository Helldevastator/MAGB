public class CamSys {

	private Matrix V = Matrix.identity(4);

	public void rotateAbs(double phi, double a1, double a2, double a3) {
		Matrix Rinv = Matrix.rotation(phi, a1, a2, a3);
		V = V.times(Rinv);
	}

	public void translateAbs(double a1, double a2, double a3) {
		Matrix Tinv = Matrix.translation(a1, a2, a3);
		V = V.times(Tinv);
	}

	public void rotateRel(double phi, double a1, double a2, double a3) {
		Matrix Rinv = Matrix.rotation(phi, a1, a2, a3);
		V = Rinv.times(V);
	}

	public void translateRel(double a1, double a2, double a3) {
		Matrix Tinv = Matrix.translation(a1, a2, a3);
		V = Tinv.times(V);
	}

	public Matrix getViewMatrix() {
		return V;
	}

	public double[] getViewMatrixLinear() {
		double[] a = new double[16];
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				a[j * 4 + i] = V.el(i, j);
			}
		}
		return a;
	}

	public static Matrix calcNormalProjectionMatrix(double n, double f, double l, double r, double t, double b) {
		Matrix m = new Matrix(4, 4);
		m.set(0, 0, 2 / (r - l));
		m.set(1, 1, 2 / (t - b));
		m.set(2, 2, -2 / (f - n));
		m.set(3, 3, 1);
		m.set(0, 3, -(r + l) / (r - l));
		m.set(1, 3, -(t + b) / (t - b));
		m.set(2, 3, -(f + n) / (f - n));

		return m;
	}

	public static Matrix calcCentralProjectionMatrix(double n, double f, double l, double r, double t, double b) {
		Matrix m = new Matrix(4, 4);
		m.set(0, 0, 2 * n / (r - l));
		m.set(1, 1, 2 * n / (t - b));
		m.set(0, 2, (r + l) / (r - l));
		m.set(1, 2, (t + b) / (t - b));
		m.set(2, 2, -(f + n) / (f - n));

		m.set(2, 3, -2 * f * n / (f - n));
		m.set(3, 2, -1);

		return m;
	}

}
