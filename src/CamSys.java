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
}
