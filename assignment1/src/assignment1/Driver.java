package assignment1;

import java.math.*;
import java.util.HashSet;
import java.util.Set;

public class Driver {

	private Set<Profile> _profiles = new HashSet<>();

	public Driver() {
		Profile prof1 = new Profile("Romina", "Sharifpour", "Working at Deloitte", 21);
		Profile prof2 = new Profile("Nicholas", "de Weerd", "Working at CrownBet", 35);
		Profile prof3 = new Profile("John", "Smith", "<3", 29);
		Profile prof4 = new Profile("Lisa", "Chan", "nurse", 26);
		Dependent dependent = new Dependent("Baby", "Lee", "Hi!", 13, prof1, prof2);
		Dependent dependent2 = new Dependent("Baby", "Sugar", "Weeee", 6, prof1, prof2);
		Dependent dependent3 = new Dependent("Honey", "Bee", "Weeee", 2, prof4, prof3);

		AddFriend(prof1, prof2);
		AddFriend(prof3, prof1);
		// AddFriend(prof3, dependent);
		// AddFriend(dependent, dependent2);

		_profiles.add(prof1);
		_profiles.add(prof2);
		_profiles.add(prof3);
		_profiles.add(dependent);
		_profiles.add(dependent2);
		_profiles.add(dependent3);
	}

	public Boolean createProfile(String firstname, String famname, String status, int age) {
		if (searchProfile(firstname, famname) == null) {
			Profile profile = new Profile(firstname, famname, status, age);
			_profiles.add(profile);
			return true;
		}
		return false;
	}

	public Boolean createDependent(String firstname, String famname, String status, int age, Profile parent1,
			Profile parent2) {
		if (searchProfile(firstname, famname) == null) {
			Profile profile = new Dependent(firstname, famname, status, age, parent1, parent2);
			_profiles.add(profile);
			return true;
		}
		return false;
	}

	public Boolean AddFriend(Profile profile1, Profile profile2) {
		Boolean success = profile1.addfriend(profile2);
		if (!success) {
			return false;
		}
		success = profile2.addfriend(profile1);
		return success;
	}

	public void removeFriend(Profile profile1, Profile profile2) {
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

	public Set<Profile> showRelatives(Profile profile) {
		return profile.getRelatives();
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
