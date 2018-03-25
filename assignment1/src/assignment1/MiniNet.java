package assignment1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.io.BufferedReader;

public class MiniNet {

	//private static Set<Profile> friendlist;

	public static void main(String[] args) { 
		
		
		System.out.println("        MiniNet Menu           ");
		System.out.println("*******************************");
		System.out.print(" Please select an option from 1-8\r\n");
		System.out.println("");
		System.out.println("1. List all the members' profiles");
		System.out.println("2. Look up a person");
		System.out.println("3. View the Person's profile");
		System.out.println("4. Create profile");
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
			String firstname1;
			String familyname1;
			String firstname2;
			String familyname2;
			String status;
			int age;
			//friendlist = null;
			
			
			//Profile profile1;
			Profile profile2;
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

//<<<<<<< newBranch
				profile = driver.searchProfile(firstname, familyname);
				 if (profile != null) {
//=======
			//	profile = driver.DiplayProfile(firstname, familyname);

				//if (profile != null) {
//>>>>>>> master
					System.out.println(profile.toString());
				String friendlist=driver.Diplayfriendlist(firstname, familyname);
					System.out.println(friendlist);
				} else {
					System.out.println("Profile doesn't exist");
				}
				break;

			case 4:
				System.out.println("Enter your first name");
				firstname = menu.readLine();
				System.out.println("Enter your surname");
				familyname = menu.readLine();
				System.out.println("Write a status");
				status = menu.readLine();
				System.out.println("How old are you?");
				age = menu.read();
				profile = driver.createProfile(firstname, familyname, status, age);
				break;

			case 5:				
				System.out.println("Enter your first name");
				firstname1 = menu.readLine();
				System.out.println("Enter your surname");
				familyname1 = menu.readLine();
				profile = new Profile(firstname1, familyname1);				
				System.out.println("Enter the first name of your friend");
				firstname2 = menu.readLine();
				System.out.println("Enter the surname of your friend");
				familyname2 = menu.readLine();
				profile2 = new Profile(firstname2, familyname2);
				//if (profile2 != null) {
					driver.AddFriend(profile, profile2);
					System.out.println(profile2.getname() + " " + profile2.getsurname() + " is now your friend, congratz!");
				//} else {
					//System.out.println("Such profile doesn't exist");
				//}
				
				break;

			case 6:
				System.out.println("Enter the first name of your friend");
				firstname = menu.readLine();
				System.out.println("Enter the surname of your friend");
				familyname = menu.readLine();
				profile = driver.searchProfile(firstname, familyname);
				
				if (profile != null) {
					profile.removefriend(profile);
					System.out.println(profile.getname() + " " + profile.getsurname() + " is not your friend now");
				} else {
					System.out.println("Such profile doesn't exist");
				}
				break;

			case 7:
				System.out.println("You have exited the program\r\n");
				System.exit(1);
				break;
			default:
				System.out.println("You have entered an invalid selection, please choose from the following options\r\n");
				break;
			}
			
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your input!\r\n");
			System.exit(1);
		}
	
	}

}
