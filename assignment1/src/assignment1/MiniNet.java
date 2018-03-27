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
		System.out.println("4. Are this profiles connected");
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
				String friendlist = "";
				profile = driver.searchProfile(firstname, familyname);
				if (profile != null) {
					System.out.println(profile.toString());
					friendlist = driver.Diplayfriendlist(firstname, familyname);

					if (!friendlist.equals("")) {
						System.out.println(friendlist);
					} else {
						System.out.println(firstname + " has no friends");
					}

				} else {
					System.out.println("Profile doesn't exist");
				}
				break;

			case 4:

				break;

			case 5:
				System.out.println("Enter your first name");
				firstname1 = menu.readLine();

				System.out.println("Enter your surname");
				familyname1 = menu.readLine();
				profile = driver.searchProfile(firstname1, familyname1);

				System.out.println("Enter the first name of your friend");
				firstname2 = menu.readLine();

				System.out.println("Enter the surname of your friend");
				familyname2 = menu.readLine();

				profile2 = driver.searchProfile(firstname2, familyname2);

				if (profile != null && profile2 != null) {
					driver.AddFriend(profile, profile2);
					friendlist = driver.Diplayfriendlist(firstname1, familyname1);
					System.out.println(friendlist);
					System.out
							.println(profile.getname() + " and " + profile2.getname() + " are friends now, congratz!");
				} else {
					System.out.println("input error");
				}

				break;

			case 6:
				System.out.println("Enter your first name");
				firstname1 = menu.readLine();

				System.out.println("Enter your surname");
				familyname1 = menu.readLine();

				profile = driver.searchProfile(firstname1, familyname1);

				System.out.println("Enter the first name of the friend you want remove");
				firstname2 = menu.readLine();

				System.out.println("Enter the surname of the friend you want remove");
				familyname2 = menu.readLine();
				profile2 = driver.searchProfile(firstname2, familyname2);

				if (profile != null && profile2 != null && profile.getfriendlist().contains(profile2)) {
					profile.removefriend(profile);
					profile = driver.searchProfile(firstname1, familyname1);
					System.out.println(profile.getname() + " and " + profile2.getname() + " are not friends now, T_T");
				} else {
					System.out.println("Such profile doesn't exist in your friend list");
				}
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
