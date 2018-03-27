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

	public void addfriend(Dependent dependent) {
		if (dependent.getage() < 16) {
			_friendlist.add(dependent);
		}
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
