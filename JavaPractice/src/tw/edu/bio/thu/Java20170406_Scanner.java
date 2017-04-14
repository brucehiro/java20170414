package tw.edu.bio.thu;

import java.util.Scanner;

public class Java20170406_Scanner {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int answer = (int)(Math.random()*10);
		int guess;
		
		do
		{
			System.out.println("Guess a number between 0 and 9: ");
			guess = input.nextInt();
		}while(guess != answer);

		System.out.printf("%s%d","Correct! The answer is ", guess);
	}

}
