package assignment1;

public class Dependent extends Friend {
	Parent _parent;

	public Dependent(String firstname, String famname, Parent Parent)  {
		super(firstname, famname);
		this._parent = Parent;
	}

	public String getParentname() {
		return _parent.getname();

	}

	public String getParentfamname() {
		return _parent.getsurname();
	}
}
