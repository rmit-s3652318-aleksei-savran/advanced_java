package assignment1;

import java.util.HashSet;
import java.util.Set;

public class Driver {

	private Set<Profile> _profiles = new HashSet<>();

	public Driver() {
		_profiles.add(new Profile("Romina", "Sharifpour", "Working at Deloitte", 21));
		_profiles.add(new Profile("Nicholas", "de Weerd", "Working at CrownBet", 35));
	}

	public void createProfile(String firstname, String famname, String status, int age) {
		Profile profile = new Profile(firstname, famname, status, age);
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

	public Profile searchProfile(String name, String surname) {
		for (Profile p : _profiles) {
			if (p.getname().equals(name) && p.getsurname().equals(surname)) {
				return p;
			}
		}
		return null;
	}

	public Set<Profile> listMembers() {
		return _profiles;
	}


	public String DiplayProfile(String name, String surname) {
		Profile profile = searchProfile(name, surname);
		Set<Profile> _friendlist=Profile.getfriendlist()
		
		return profile.toString();
	}
	
	public String Diplayfriendlist(String name, String surname) {
		Profile profile = searchProfile(name, surname);
		return profile.toString();
	}

}
