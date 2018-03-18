package assignment1;

public class Parent extends Friend {

	Dependent _dependent;

	public Parent(String firstname, String famname) {
		super(firstname, famname);
	}

	public String getDepname() {
		return _dependent.getname();

	}

	public String getDepfamname() {
		return _dependent.getsurname();

	}
}

