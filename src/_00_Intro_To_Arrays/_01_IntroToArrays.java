package _00_Intro_To_Arrays;

import java.util.Random;

public class _01_IntroToArrays {
    public static void main(String[] args) {
        // 1. declare and Initialize an array 5 Strings
String[] strng = new String[5];
strng[0]="2";
strng[1]="3";
strng[2]="4";
strng[3]="5";
strng[4]="6";
        // 2. print the third element in the array
System.out.println(strng[2]);
        // 3. set the third element to a different value
strng[2]="a different value";
        // 4. print the third element again
System.out.println(strng[2]);
        // 5. use a for loop to set all the elements in the array to a string
        //    of your choice
for (int i = 0; i < strng.length; i++) {
	strng[i]="I couldn't think of anything funny";
}
        // 6. use a for loop to print all the values in the array
        //    BE SURE TO USE THE ARRAY'S length VARIABLE
for (int i = 0; i < strng.length; i++) {
	System.out.println(strng[i]);
}
        // 7. make an array of 50 integers
Integer[] ger = new Integer[50];

        // 8. use a for loop to make every value of the integer array a random
        //    number
Random r = new Random();
for (int i = 0; i < ger.length; i++) {
	ger[i]=r.nextInt(50)+50;
}
        // 9. without printing the entire array, print only the smallest number
        //    on the array
int smallint=150;
for (int i = 0; i < ger.length; i++) {
	System.out.println(ger[i]);
	if(smallint>ger[i]) {
		smallint=ger[i];
	}
}
System.out.println("\n" + smallint);
        // 10 print the entire array to see if step 8 was correct
for (int i = 0; i < ger.length; i++) {
	
	if(smallint<ger[i]) {
		smallint=ger[i];
	}
}
        // 11. print the largest number in the array.
System.out.println("\n" + smallint);
        // 12. print only the last element in the array
System.out.println(ger[49]);
    }
}
