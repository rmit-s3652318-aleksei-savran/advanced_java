package assignment1;

import java.util.HashSet;
import java.util.Set;

public class Dependent extends Profile {
	Profile _parent1;
	Profile _parent2;
	int age;

	public Dependent(String firstname, String famname, String status, int age, Profile MumParent, Profile DadParent) {
		super(firstname, famname, status, age);
		this._parent1 = MumParent;
		this._parent2 = DadParent;

		this._parent1.addfriend(this);
		this._parent2.addfriend(this);
	}

	public Boolean addfriend(Profile profile) {
		if (profile.getage() <= 2 && this.getage() <= 2) {
			System.out.println("Younger than two year old, can not have any friend");
			return false;
		}

		int agediff = Math.abs(this.getage() - profile.getage());
		if (profile.getage() < 16 && agediff > 3) {
			_friendlist.add(profile);
		} else {
			System.out.println("You are not allowed to add a friend more than 3 years older than yourself");
			return false;
		}
		return true;
	}

	public Set<Profile> getRelatives() {
		Set<Profile> parents = new HashSet<>();
		parents.add(_parent1);
		parents.add(_parent2);
		return parents;
	}

	public String getMumname() {
		return _parent1.getname();

	}

	public String getMumfamname() {
		return _parent1.getsurname();
	}

	public String getDadname() {
		return _parent2.getname();

	}

	public String getDadfamname() {
		return _parent2.getsurname();
	}
}
