package assignment1;

import java.util.HashSet;
import java.util.Set;

public class Profile {
	protected String _name;
	protected String _surname;
	protected String _status;
	protected int _age;
	protected Set<Profile> _friendlist = new HashSet<>();
	protected Set<Dependent> _dependents = new HashSet<>();

	public Profile(String firstname, String famname, String status, int age) {
		this._name = firstname;
		this._surname = famname;
		this._status = status;
		this._age = age;
	}
	
	public Profile(String firstname, String famname) {
		this._name = firstname;
		this._surname = famname;
	}

	public void setFriendlist(Set<Profile> friendlist) {
		_friendlist = friendlist;
	}

	public void setname(String firstname) {
		_name = firstname;
	}

	public String getname() {
		return _name;
	}

	public void setsurname(String familyname) {
		_surname = familyname;
	}

	public String getsurname() {
		return _surname;
	}

	public String getstatus() {
		return _status;
	}

	public int getage() {
		return _age;
	}

	public Set<Profile> getfriendlist() {
		return _friendlist;
	}

	public void addfriend(Profile profile) {
		_friendlist.add(profile);
	}

	public Set<Profile> getRelatives() {
		Set<Profile> dependents = new HashSet<>();
		for (Profile friend : _friendlist) {
			if (friend instanceof Dependent) {
				dependents.add((Dependent)friend);
			}
		}
		return dependents;
	}

	public void removefriend(Profile profile) {
		if (_friendlist.contains(profile)) {
			_friendlist.remove(profile);
		}
	}

	public String toString() {
		String profileString = "";
		profileString += _name + " ";
		profileString += _surname + " - ";
		profileString += _age + " - ";
		profileString += _status;
		return profileString;
	}
}
