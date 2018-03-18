package assignment1;

import java.util.HashSet;
import java.util.Set;

public class Driver {

	private Set<Profile> _profiles = new HashSet<>();

	public void createProfile(String firstname, String famname, String status) {
		Profile profile = new Profile(firstname, famname, status);
		_profiles.add(profile);
	}

	public void AddFriend(Profile profile1, Profile profile2) {
		profile1.addfriend(profile2);
		profile2.addfriend(profile1);

	}

	public void RemoveFriend(Profile profile1, Profile profile2) {
		profile1.removefriend(profile2);
		profile2.removefriend(profile1);
	}

	public Profile getProfile(String name, String surname) {
		for (Profile p : _profiles) {
			if ((p.getname() == name) && (p.getsurname() == surname)) {
				return p;
			}
		}
		System.out.println("No profile with this name are found");
		return null;
	}

}
