package assignment1;

public class Dependent extends Friend {
	Parent _parent1;
	Parent _parent2;

	public Dependent(String firstname, String famname, Parent MumParent, Parent DadParent)  {
		super(firstname, famname);
		this._parent1 = MumParent;
		this._parent2= DadParent;
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
