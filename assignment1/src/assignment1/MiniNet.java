package assignment1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class MiniNet {

	public static void main(String[] args) {
		System.out.println("        MiniNet Menu           ");
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.print(" Please select an option from 1-6\r\n");
        System.out.println("");
        System.out.println("1. List all the members' profiles");
        System.out.println("2. Look up a person");
        System.out.println("3. View the Person's profile");
        System.out.println("4. Display the profiles friend list");
        System.out.println("5. Are these two members connected\"");
        System.out.println("6. Exit the menue");
        
        
        BufferedReader menu = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int input = Integer.parseInt(menu.readLine());
            
            if(input < 0 || input > 7) {
                System.out.println("You have entered an invalid selection, please choose from the following options\r\n");
            } else if(input == 6) {
                System.out.println("You have exited the program\r\n");
                System.exit(1);
            } else {
                System.out.println("You have entered " + input + "\r\n");
            }
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your input!\r\n");
            System.exit(1);
        }
    }
	
}


