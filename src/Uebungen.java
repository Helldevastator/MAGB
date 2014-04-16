public class Uebungen {

	public static void Uebung3() {
		Vector up = new Vector(new double[] { 0, 1, 0 });
		Vector A = new Vector(new double[] { 5, 2, 10 });
		Vector B = new Vector(new double[] { 0, 0, 0 });

		Vector f3 = A.minus(B);
		Vector f1 = up.cross(f3);
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
		double x_lambda = -3.0 / 26.0 * 2;
		double y_lambda = 2.0 / 13.0 * 2;
		double z_lambda = -1.0 / 26.0 * 2;

		double[][] c = { { 1.0 + x_lambda * 3.0, x_lambda * -4.0, x_lambda * 1.0 }, { y_lambda * 3.0, 1.0 + y_lambda * -4.0, y_lambda * 1.0 },
				{ z_lambda * 3.0, z_lambda * -4.0, 1.0 + z_lambda * 1.0 } };
		System.out.println("\n c)");
		new Matrix(c).print();

	}

	public static void Uebung11() {
		// a)
		// 1. translate in z (M1), 2. rotate around y (M2) => M = M2*M1
		double alpha = 15.0;
		double a = 5;
		double s = Math.sin(alpha);
		double c = Math.cos(alpha);

		double[][] m1 = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, a }, { 0, 0, 0, 1 } };
		double[][] m2 = { { c, 0, s, 0 }, { 0, 1, 0, 0 }, { -s, 0, c, 0 }, { 0, 0, 0, 1 } };
		Matrix M = new Matrix(m2).times(new Matrix(m1));
		M.print();

		// b)
		// 1. rotate around z (M3), 2. translate on z (M1), 3. rotate around y
		// (M2) => M = M3*M2*M1
		double beta = 30.0;
		double s2 = Math.sin(beta);
		double c2 = Math.cos(beta);
		double[][] m3 = { { c2, -s2, 0, 0 }, { s2, c2, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		Matrix M2 = new Matrix(m3).times(M);
		M2.print();

	}

	public static void Uebung12Astra() {
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
		System.out.println(Math.toDegrees(Math.atan2(rot.el(1, 2), rot.el(1, 0))));
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

	public static void aufg2() {
		double elev = 20.0;
		double azim = 50.0;
		Matrix rot1 = Matrix.rotation(-elev, 1, 0, 0);
		Matrix rot2 = Matrix.rotation(azim, 0, 1, 0);

		Matrix rot = rot2.times(rot1);
		System.out.println(Math.toDegrees(Math.atan2(rot.el(1, 2), rot.el(1, 0))));
		System.out.println(Math.toDegrees(Math.acos(rot.el(1, 1))));
		System.out.println(Math.toDegrees(Math.atan2(rot.el(2, 1), -rot.el(0, 1))));
	}

	public static void main(String[] args) {
		// Uebung17();
		aufg2b();
	}

	public static void aufg2b() {
		double elev = 20.0;
		double azim = 50.0;
		Matrix rot1 = Matrix.rotation(-elev, 1, 0, 0);
		Matrix rot2 = Matrix.rotation(azim, 0, 1, 0);

		Matrix rot = rot2.times(rot1);
		rot.set(0, 3, 4);
		rot.set(1, 3, 2);
		rot.set(2, 3, 8);

		rot.print();

		//matlab eingeben, invertieren und berechnen
	}

	public static void aufg4() {
		Vector A = new Vector(new double[] { 3, 0, 0 });
		Vector L = new Vector(new double[] { 0, 10, 10 });
		Vector Beob = new Vector(new double[] { 8, 4, 10 });

		Vector B = new Vector(new double[] { 0, 2, 0 });
		Vector C = new Vector(new double[] { 0, 0, 1 });

		Vector v = B.minus(A);
		Vector m = C.minus(A);
		Vector n = v.cross(m).normalize();

		Vector toL = L.minus(A).normalize();
		Vector toE = Beob.minus(A).normalize();

		// orthogonalzerlegung mit normalisierten vectoren
		// Vector ref = n.times(toL.dot(n)).times(2).minus(toL).normalize();
		// //norm maybe not needed

		// b
		Vector h = toL.plus(toE).normalize();
		double eps = 2 * Math.acos(n.dot(h));

		double light = 0.4;
		light += 0.5 * n.dot(toL);
		light += 0.2 * Math.pow(eps, 20);
		System.out.println(light);
	}
}
