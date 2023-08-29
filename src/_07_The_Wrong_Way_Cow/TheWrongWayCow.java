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
 * The test cases will NOT test any situations where there are 'imaginary' cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * 'imaginary' cow may appear that in fact is just made of three other 'real' cows.
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
		 * String[][] field = new String[2][3]; for (int i =2; i < 2; i++) { for (int j =
		 * 2; j < 3; j++) { field[i][j]='cow'; } } field[2][2]='woc';
		 */
	//	String[][] field = new String[field.length][field[0].length];

		int north = 0;
		int south = 0;
		int east = 0;
		int west = 0;
		/*for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				field[i][j] = String.valueOf(field[i][j]);
			}
		}*/

		// getting the amount of cows facing each direction
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field[0].length; i++) {
				
				if (i+2<field[j].length) {
					if (field[j][i]==('c') && field[j][i + 1]==('o') && field[j][i + 2]==('w')) {

						west++;
					}
				}
				if (i+2<field[j].length) {
					if (field[j][i]==('w') && field[j][i + 1]==('o') && field[j][i + 2]==('c')) {

						east++;
					}
				}

				if (j+2<field.length) {
					if (field[j][i]==('c') && field[j + 1][i]==('o') && field[j + 2][i]==('w')) {

						north++;
					}

				}
				if (j+2<field.length) {
					if (field[j][i]==('w') && field[j + 1][i]==('o') && field[j + 2][i]==('c')) {

						south++;
					}
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
			System.out.println(north);
			System.out.println(south);
			System.out.println(east);
			System.out.println(west);
		}
System.out.println(wrng);
		// gets the position of the wrong way cow
		int wwcy = 0;
		int wwcx = 0;
		
		for (int i = 0; i < field[0].length; i++) {
			for (int j = 0; j < field.length; j++) {
				
				if (wrng == 1) {
					if (j+2<field.length) {
						if (field[j][i]==('c') && field[j + 1][i]==('o') && field[j + 2][i]==('w')) {

							wwcy = j;
							wwcx = i;

						}
					}
				}
					if (wrng == 2) {
						if (j+2<field.length) {
							if (field[j][i]==('w') && field[j + 1][i]==('o') && field[j + 2][i]==('c')) {
								wwcy = j+2;
								wwcx = i;
							}
						}
					}

					if (wrng == 3) {
						if (i+2<field[j].length) {
							if (field[j][i]==('w') && field[j][i + 1]==('o') && field[j][i + 2]==('c')) {
								wwcy = j;
								wwcx = i+2;
							}
						}
					}

					if (wrng == 4) {
						if (i+2<field[j].length) {
							if (field[j][i]==('c') && field[j][i + 1]==('o') && field[j][i + 2]==('w')) {
								wwcy = j;
								wwcx = i;
							}
						}
					
				}
			}
		}

		int[] op = new int[2];
		op[0] = wwcx;
		op[1] = wwcy;
		System.out.println("wwc should be at " + Arrays.toString(op));
		System.out.println(wrng);
		return op;
	}

}
