
/**
* Name: CHECK ISBN-13
* File: Naghdi_Assignment2.java
* Description: A program that prompts the user to enter a string and ­displays the string in reverse order.
*/

import java.util.Scanner;

public class Naghdi_Assignment2 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("************************************************\r\n"
				+ "* Welcome to the Daily Book Inventory Program! *\r\n"
				+ "************************************************");
		// Integer Variables
		int returnNumbers = 0;
		int checkoutNumbers = 0;
		int totalNumbers = 0;
		
		// To continue receiving data from the user
		boolean cont = true;
        while (cont) {
				// Prompt the user to enter the first 12 digits of an ISBN-13 as string
				System.out.println("Enter the first 12 digits of an ISBN-13 as a string: ");
				String isbn = input.nextLine();
				
				// Verify string length
				if (isbn.length() != 12) {
					System.out.println("Invalid ISBN-13 number! Try again.");
					System.out.println("Enter the first 12 digits of an ISBN-13 as a string: ");
					isbn = input.nextLine();					
				}				
				
				// Calculate checksum using a for loop 
				int checksum = 0;
		        for (int i = 0; i < isbn.length(); i++) {
		            if ((i + 1) % 2 == 0) {
		            	checksum +=  (isbn.charAt(i) - '0') * 3;
		            } else {
		            	checksum  += isbn.charAt(i) - '0';
		            }
		        }
		        
		        checksum %= 10;
		        checksum = 10 - checksum;
		        if (checksum == 10) 
		        	isbn += "0";
		        else  isbn += checksum;

		        System.out.println("The ISBN-13 number is " + isbn);
		        System.out.println("");	
		        System.out.println("");
				// To determine returned or checked out books
				System.out.print("Enter 'R' for return or 'C' for check out: ");
				String status = input.nextLine();
				char ch = status.charAt(0);				
				
				if (ch == 'R') 
					returnNumbers ++;				
				else if (ch == 'C')
					checkoutNumbers ++;				
				// Total number of books processed
				totalNumbers = returnNumbers + checkoutNumbers;				
				
				System.out.println("************************************************\r\n"
						+ "*             Daily Book Inventory             *\r\n"
						+ "************************************************");
				
				System.out.println("Number of books returned:      " + returnNumbers);
				System.out.println("Number of books checked out:   " + checkoutNumbers);
				System.out.println("The total of books processed:  " + totalNumbers);
				System.out.println("************************************************");
				
				System.out.print("Enter 'Y' to continue, 'N' to quit: ");
				String option = input.nextLine();
				char proceed = option.charAt(0);
				System.out.println("");				
				
				// To ask if the user desire to proceed or exit
				if (proceed == 'Y') {
		                cont = true;		               	                
		            } 				
				else if (proceed == 'N') {
		                cont = false;
		                System.out.println("************************************************\r\n"
								+ "*             Daily Book Inventory             *\r\n"
								+ "************************************************");
						
						System.out.println("Number of books returned:      " + returnNumbers);
						System.out.println("Number of books checked out:   " + checkoutNumbers);
						System.out.println("The total of books processed:  " + totalNumbers);
						System.out.println("************************************************");
						break;
						}
			}
	}
}
	


