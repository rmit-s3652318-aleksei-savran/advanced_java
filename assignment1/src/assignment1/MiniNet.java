package assignment1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.io.BufferedReader;

public class MiniNet {

	public static void main(String[] args) {
		System.out.println("        MiniNet Menu           ");
		System.out.println("*******************************");
		System.out.print(" Please select an option from 1-8\r\n");
		System.out.println("");
		System.out.println("1. List all the members' profiles");
		System.out.println("2. Look up a person");
		System.out.println("3. View the Person's profile");
		System.out.println("4. Are these two members connected?");
		System.out.println("5. Add a friend");
		System.out.println("6. Remove a friend");
		System.out.println("7. Exit the menu");

		// creating the menu
		BufferedReader menu = new BufferedReader(new InputStreamReader(System.in));

		try {
			int input = Integer.parseInt(menu.readLine());
			System.out.println("You have entered " + input + "\r\n");

			Driver driver = new Driver();
			
			Set<Profile> profiles;
			Profile profile = null;
			String firstname;
			String familyname;
			
			switch (input) {

			case 1: //// listing all the profiles
				profiles = driver.listMembers();
				for (Profile p : profiles) {
					System.out.println(p.toString());
				}
				break;

			case 2:
				System.out.println("Enter the first name:");
				firstname = menu.readLine();

				System.out.println("Enter the surname:");
				familyname = menu.readLine();

				profile = driver.searchProfile(firstname, familyname);

				if (profile != null) {
					System.out.println(profile.getname() + " " + profile.getsurname());
				} else {
					System.out.println("Profile doesn't exist");
				}
				break;

			case 3:
				System.out.println("Enter the first name:");
				firstname = menu.readLine();

				System.out.println("Enter the surname:");
				familyname = menu.readLine();

				profile = driver.searchProfile(firstname, familyname);

				if (profile != null) {
					System.out.println(profile.toString());
				} else {
					System.out.println("Profile doesn't exist");
				}
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				break;

			case 7:
				System.out.println("You have exited the program\r\n");
				System.exit(1);
				break;
			default:
				System.out
						.println("You have entered an invalid selection, please choose from the following options\r\n");
				break;
			}
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your input!\r\n");
			System.exit(1);
		}
	}

}
