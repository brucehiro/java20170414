package tw.edu.bio.thu;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Java20170407_String {

	public static void main(String[] args) {
//		Scanner Input = new Scanner(System.in);
		long Number = 0;
		long Sum = 0;
		int counter = 0;
		
		do
		{
//			System.out.println("Input a number or input -1 to exit: ");
//			String input = JOptionPane.showInputDialog("Input a number or input -1 to exit: ");
			
			for(int i = 0; i < args.length; i++)
			{
				Number = Long.parseLong(args[i]);
				
				if(Number != -1)
				{
					Sum += Number;
					counter++;
				}
			}
						
		}while(Number != -1);

		System.out.printf("%s %.2f","The mean is:", (double)Sum / counter);
		
	}

}
