/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/


		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		/* */
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if(n == 0)  System.out.println("Enter a valid number n");
		double xP3 = ((Math.sqrt(3.0) / 6) * (y1 - y2)) + ((x1 + x2) / 2);
		double yP3 = ((Math.sqrt(3.0) / 6) * (x2 - x1)) + ((y1 + y2) / 2);
		double newX1 = ((x2 - x1) / 3) + x1, newY1 = ((y2 - y1) / 3) + y1;
		double newX2 = (((x2 - x1) / 3) * 2) + x1, newY2 = (((y2 - y1) / 3) * 2) + y1;
		if(n == 1) {
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.line(newX1, newY1, newX2, newY2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(newX1, newY1, xP3, yP3);
			StdDraw.line(xP3, yP3, newX2, newY2);
		}
		else {
			curve(n - 1, x1, y1, newX1, newY1);
			curve(n - 1, newX1, newY1, xP3, yP3);
			curve(n - 1, xP3, yP3, newX2, newY2);
			curve(n - 1, newX2, newY2, x2, y2);
		}
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double x1 = 0.2, y1 = 0.6;
		double x2 = 0.6, y2 = 0.6;
		double x3 = 0.4, y3 = 1 - (0.4 * Math.sqrt(3.0));
		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}
