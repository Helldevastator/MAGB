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

		//euler winkel
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

		//orthogonalzerlegung mit normalisierten vectoren
		//Vector ref = n.times(toL.dot(n)).times(2).minus(toL).normalize(); //norm maybe not needed
		Vector aPar = n.times(toL.dot(n));
		Vector ref = aPar.minus(toL).plus(aPar);
		System.out.println(Math.toDegrees(Math.acos(ref.dot(toE))));

		//b
		Vector h = toL.plus(toE).normalize();
		System.out.println(Math.toDegrees(Math.acos(n.dot(h))));

	}

	public static void main(String[] args) {
		Astra();
	}
}
