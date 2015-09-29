package org;

public class StringvsStringBuilder {

	private static long start;
	private static long end;
	private static String p = "";
	private static String x = "";
	private static StringBuilder y = new StringBuilder();
	private static StringBuffer h = new StringBuffer();
	private static int a = 1000;

	public static void main(String[] args) {

		/* Using StringBuilder class and append */

		start = System.nanoTime();

		for (int i = 0; i < a; i++) {
			y.append("x");
		}

		end = System.nanoTime();

		System.out.println("StringBuilder =  " + ((end - start) / 1000F)%2.f);

		/*
		 * ======================================================================
		 * =
		 */

		/* Using String and concat */

		start = System.nanoTime();

		for (int i = 0; i < a; i++) {
			x.concat("x");
		}

		end = System.nanoTime();

		System.out.println("String with concat = " + ((end - start) / 1000F)%2.f);

		/*
		 * ======================================================================
		 * =
		 */

		/* Using String and concat */

		start = System.nanoTime();

		for (int i = 0; i < a; i++) {
			h.append("x");
		}

		end = System.nanoTime();

		System.out.println("StringBuffer = " + ((end - start) / 1000F)%2.f);

		/*
		 * ======================================================================
		 * =
		 */

		/* Using String and += */

		start = System.nanoTime();

		for (int i = 0; i < a; i++) {
			p += "x";
		}

		end = System.nanoTime();

		System.out.println("String with += = " + ((end - start) / 1000F)%2.10f);

		

	}
}
