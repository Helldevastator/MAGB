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

	public static void main(String[] args) {
		Uebung3();
	}
}
