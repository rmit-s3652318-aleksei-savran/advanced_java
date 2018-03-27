package assignment1;

import java.math.*;
import java.util.HashSet;
import java.util.Set;

public class Driver {

	private Set<Profile> _profiles = new HashSet<>();

	public Driver() {
		Profile prof1 = new Profile("Romina", "Sharifpour", "Working at Deloitte", 21);
		Profile prof2 = new Profile("Nicholas", "de Weerd", "Working at CrownBet", 35);
		Profile prof3 = new Profile("Jhon", "Smith", "<3", 29);
		AddFriend(prof1, prof2);
		AddFriend(prof3, prof1);

		_profiles.add(prof1);
		_profiles.add(prof2);
		_profiles.add(prof3);
	}

	public Profile createProfile(String firstname, String famname, String status, int age) {
		Profile profile = new Profile(firstname, famname, status, age);
		_profiles.add(profile);
		return profile;
	}

	public void AddFriend(Profile profile1, Profile profile2) {
		profile1.addfriend(profile2);
		profile2.addfriend(profile1);
	}

	public void AddDependentFriend(Dependent dependent1, Dependent dependent2) {
		int agediff = Math.abs(dependent1.getage() - dependent2.getage());
		if (agediff >= 3) {
			dependent1.addfriend(dependent2);
			dependent2.addfriend(dependent1);
		} else {
			System.out.println("You are not allowed to add a friend more than 3 years older than yourself");
		}
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

	public void showRelatives(String name, String surname) {
		Profile profile = searchProfile(name, surname);
		Set<Profile> relatives = profile.getRelatives();
	}

	public Boolean areProfilesConnected(Profile profile1, Profile profile2) {		
		return profile1.getfriendlist().contains(profile2);
	}

	public Set<Profile> listMembers() {
		return _profiles;
	}

	public String DiplayProfile(String name, String surname) {
		Profile profile = searchProfile(name, surname);
		return profile.toString();
	}

	public String Diplayfriendlist(String name, String surname) {
		Profile profile = searchProfile(name, surname);
		Set<Profile> _friendlist = profile.getfriendlist();

		if (_friendlist.isEmpty()) {
			return "";
		} else {
			String friends = "\r\nFriend list: \r\n************ \r\n";

			for (Profile p : _friendlist) {
				friends += p.getname();
				friends += p.getsurname();
				friends += "\r\n";
			}
			return friends;
		}
	}
}
