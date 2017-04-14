package tw.edu.bio.thu;

public class Java20170406_array {

	public static void main(String[] args) {
		int[] a1 = {10,20,30,40};
		int[] a2 = a1;
		a1[0] = 99;
		System.out.println(a2[0]);

	}

}
