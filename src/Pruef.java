public class Pruef {

	public static void aufg2() {
		double elev = 20.0;
		double azim = 50.0;
		Matrix rot1 = Matrix.rotation(-elev, 1, 0, 0);
		Matrix rot2 = Matrix.rotation(azim, 0, 1, 0);

		Matrix rot = rot1.times(rot2);
		System.out.println(Math.toDegrees(Math.atan2(rot.el(1, 2), rot.el(1, 0))));
		System.out.println(Math.toDegrees(Math.acos(rot.el(1, 1))));
		System.out.println(Math.toDegrees(Math.atan2(rot.el(2, 1), -rot.el(0, 1))));
	}

	public static void main(String[] args) {
		aufg2();
	}
}
