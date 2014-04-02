public class ModelSys {

	private Matrix U = Matrix.identity(4);

	public void rotateAbs(double phi, double a1, double a2, double a3) {
		Matrix R = Matrix.rotation(phi, a1, a2, a3);
		U = R.times(U);
	}

	public void translateAbs(double a1, double a2, double a3) {
		Matrix T = Matrix.translation(a1, a2, a3);
		U = T.times(U);
	}

	public void rotateRel(double phi, double a1, double a2, double a3) {
		Matrix R = Matrix.rotation(phi, a1, a2, a3);
		U = U.times(R);
	}

	/**
	 * Relative Translation
	 * 
	 * @param a1
	 *            Verschiebung Richtung x
	 * @param a2
	 *            Verschiebung Richtung y
	 * @param a3
	 *            Verschiebung Richtung z
	 */
	public void translateRel(double a1, double a2, double a3) {
		Matrix T = Matrix.translation(a1, a2, a3);
		U = U.times(T);
	}

	public Matrix getModelMatrix() {
		return U;
	}

	public double[] getModelMatrixLinear() {
		double[] a = new double[16];
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				a[j * 4 + i] = U.el(i, j);
			}
		}
		return a;
	}
}
