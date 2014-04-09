public class Pruefung {

	public static void Auf2() {
		double azim = 50;
		double elev = 20;

		double s = Math.sin(azim);
		double c = Math.cos(azim);
		double s2 = Math.sin(elev);
		double c2 = Math.cos(elev);

		double[][] m1 = { { c, 0, s, 0 }, { 0, 1, 0, 0 }, { -s, 0, c, 0 }, { 0, 0, 0, 1 } };
		double[][] m2 = { { c2, -s2, 0, 0 }, { s2, c2, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };

		Matrix R = new Matrix(m1).times(new Matrix(m2));
		// R.print();

		System.out.println(Math.toDegrees(Math.atan2(R.el(1, 2), R.el(1, 0))));
		System.out.println(Math.toDegrees(Math.acos(R.el(1, 1))));
		System.out.println(Math.toDegrees(Math.atan2(R.el(2, 1), -R.el(0, 1))));
	}

	public static void main(String[] args) {
		Auf2();
	}
}
