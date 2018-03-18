package assignment1;

import java.util.HashSet;
import java.util.Set;

public class Profile {
	protected String _name;
	protected String _surname;
	protected String _status;
	protected Set<Profile> _friendlist = new HashSet<>();

	public Profile(String firstname, String famname, String status) {
		this._name = firstname;
		this._surname = famname;
		this._status = status;
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

	public Set<Profile> getfriendlist() {
		return _friendlist;
	}

	public void addfriend(Profile profile) {
		_friendlist.add(profile);
	}

	public void removefriend(Profile profile) {
		if (_friendlist.contains(profile)) {
			_friendlist.remove(profile);
		}
	}
}
