public class Uebungen {

	public static void Uebung3() {
		Vector up = new Vector(new double[] { 0, 1, 0 });
		Vector A = new Vector(new double[] { 5, 2, 10 });
		Vector B = new Vector(new double[] { 0, 0, 0 });

		Vector f3 = A.minus(B);
		Vector f1 = f3.cross(up);
		Vector f2 = f3.cross(f1);

		System.out.println("System VOR normierung!!!");
		f1.print();
		f2.print();
		f3.print();

	}

	public static void Uebung4() {
		double f = 1;
		Vector S = new Vector(0, 0, 0);
		Vector D = new Vector(0, 0, -f);

		Vector X = new Vector(1, 2, 3);
		double t = -(f / X.x(2));

		Vector X_result = new Vector(t * X.x(0), t * X.x(0), t * X.x(0));
		X_result.print();
	}

	public static void Uebung7() {
		double[][] a = { { 3, -1, 2 }, { 5, 6, 4 }, { 1, 1, -1 } };
		double[][] b = { { 2, -1, 0 }, { 3, 3, 2 }, { 4, -2, 6 } };
		Matrix A = new Matrix(a);
		Matrix B = new Matrix(b);
		/*
		 * 2AX - I = 3BX; 2AX - 3BX = I; (2A - 3B)X = I; X = (2A - 3B)^-1
		 * matlab: inv(2*A-3*B)
		 */

	}

	public static void Uebung8() {
		// a) E: z = 0
		double[][] a = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println("a)");
		new Matrix(a).print();

		// b) E: x = y
		double[][] b = { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 } };
		System.out.println("\n b)");
		new Matrix(b).print();

		// c) E: 3x - 4y + z = 0
		// E = [3 -4 1]^T
		// Loese fuer g1: x = e_1 + lambda*E => 3(3*lambda +
		// 1)-4(-4*lambda)+lambda = 0 => 2*lambda = -3/13
		// lambda in g1 einsetzen
		double x_lambda = -3 / 26;
		double y_lambda = 2 / 13;
		double z_lambda = -1 / 26;

		double[][] c = { { 1.0 + x_lambda * 3.0, x_lambda * -4.0, x_lambda * 1.0 }, { y_lambda * 3.0, 1.0 + y_lambda * -4.0, y_lambda * 1.0 },
				{ z_lambda * 3.0, z_lambda * -4.0, 1.0 + z_lambda * 1.0 } };
		System.out.println("\n c)" + (x_lambda));
		new Matrix(c).print();

	}

	public static void Astra() {
		System.out.println(Math.toDegrees(Math.atan2(-7771, 30409)));
	}

	public static void Uebung17() {
		Vector a = new Vector(new double[] { 1, 3, 2 });
		a = a.normalize();
		Matrix rot = Matrix.rotation(45, a.x(0), a.x(1), a.x(2));
		double[] tmp = new double[3];
		tmp[0] = rot.el(0, 1);
		tmp[1] = rot.el(1, 1);
		tmp[2] = rot.el(2, 1);

		/*
		 * System.out.println(tmp[0]); System.out.println(tmp[1]);
		 * System.out.println(tmp[2]);
		 */

		// euler winkel
		Vector e2 = new Vector(new double[] { 0, 1, 0 });
		Vector e2dash = new Vector(tmp);

		Vector v = e2.cross(e2dash);
		System.out.println(Math.toDegrees(Math.atan2(rot.el(1, 2), rot.el(0, 0))));
		System.out.println(Math.toDegrees(Math.acos(rot.el(1, 1))));
		System.out.println(Math.toDegrees(Math.atan2(rot.el(2, 1), -rot.el(0, 1))));
	}

	public static void Uebung18() {
		Vector RD = new Vector(new double[] { 2, 3, 6 });
		Vector RQ = new Vector(new double[] { 4, 10, 12 });
		Vector RB = new Vector(new double[] { 10, 6, 23 });

		Vector n = RD.normalize();
		Vector toL = RQ.minus(RD).normalize();
		Vector toE = RB.minus(RD).normalize();

		// orthogonalzerlegung mit normalisierten vectoren
		// Vector ref = n.times(toL.dot(n)).times(2).minus(toL).normalize();
		// //norm maybe not needed
		Vector aPar = n.times(toL.dot(n));
		Vector ref = aPar.minus(toL).plus(aPar);
		System.out.println(Math.toDegrees(Math.acos(ref.dot(toE))));

		// b
		Vector h = toL.plus(toE).normalize();
		System.out.println(Math.toDegrees(Math.acos(n.dot(h))));

	}

	public static void main(String[] args) {
		// Uebung17();
		Uebung8();
	}
}
