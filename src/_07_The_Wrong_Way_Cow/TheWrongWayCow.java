/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

import java.util.Arrays;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the [col, row] coordinate position of the
		// head (letter 'c') of the wrong way cow!
		/*
		 * String[][] fld = new String[2][3]; for (int i =2; i < 2; i++) { for (int j =
		 * 2; j < 3; j++) { fld[i][j]="cow"; } } fld[2][2]="woc";
		 */
		String[][] fld = new String[field.length][field[0].length];

		int north = 0;
		int south = 0;
		int east = 0;
		int west = 0;
		for (int i = 1; i < fld.length; i++) {
			for (int j = 1; j < fld[0].length; j++) {
				fld[i][j] = String.valueOf(field[i][j]);
			}
		}

		// getting the amount of cows facing each direction
		for (int i = 1; i < fld[0].length - 2 - 2; i++) {
			for (int j = 1; j < fld.length - 2 - 2; j++) {
				if (fld[j][i].equals("c") && fld[j + 1][i].equals("o") && fld[j + 2][i].equals("w")) {
					west++;
				}
				if (fld[j][i].equals("w") && fld[j + 1][i].equals("o") && fld[j + 2][i].equals("c")) {
					east++;
				}

				if (fld[j][i].equals("c") && fld[j][i + 1].equals("o") && fld[j][i + 2].equals("w")) {
					north++;
				}
				if (fld[j][i].equals("c") && fld[j][i + 1].equals("o") && fld[j][i + 2].equals("w")) {
					south++;
				}
			}
		}

		// finds the direction most of them are facing
		int wrng = 5; // north=1 south=2 east=3 west=4
		if (north == 1) {
			wrng = 1;
		}
		if (south == 1) {
			wrng = 2;
		}
		if (east == 1) {
			wrng = 3;
		}
		if (west == 1) {
			wrng = 4;
		}

		if (wrng == 5) {
			System.out.println("Didn't find any wrong way cows");
		}

		// gets the position of the wrong way cow
		int wwcy = 0;
		int wwcx = 0;
		String w = "w";
		String o = "o";
		String c = "c";
		if (wrng == 1) {
			for (int i = 1; i < fld[0].length - 2; i++) {
				for (int j = 1; j < fld.length - 2; j++) {
					if (fld[j][i].equals("c") && fld[j][i + 1].equals("o") && fld[j][i + 2].equals("w")) {
						wwcy = i;
						wwcx = j;
					}
				}
			}
		}
		if (wrng == 2) {
			for (int i = 1; i < fld[0].length - 2; i++) {
				for (int j = 1; j < fld.length - 2; j++) {
				try {	
					if (fld[j][i].equals("c") && fld[j][i + 1].equals("o") && fld[j][i + 2].equals("w")) {
						System.out.println("y x "+ wwcy + " " + wwcx);
						wwcy = i;
						wwcx = j;
					}
				}catch(NullPointerException e) {
					System.out.println("sdas g grf ");
				}
				}
			}
		}
		if (wrng == 3) {
			for (int i = 1; i < fld[0].length - 2; i++) {
				for (int j = 1; j < fld.length - 2; j++) {							
					if (fld[j][i].equals("w") && fld[j + 1][i].equals("o") && fld[j + 2][i].equals("c")) {
						wwcy = i;
						wwcx = j;
						
					}
				}
		}
		}
		if (wrng == 4) {
			for (int i = 1; i < fld[0].length - 2; i++) {
				for (int j = 1; j < fld.length - 2; j++) {
					if (fld[j][i].equals("w") && fld[j + 1][i].equals("o") && fld[j + 2][i].equals("c")) {
						wwcy = i;
						wwcx = j;
					}
				}
			}
		}

		int[] op = new int[2];
		op[0] = wwcx;
		op[1] = wwcy;
		System.out.println("wwc should be at " + Arrays.toString(op));
		return op;
	}

}
