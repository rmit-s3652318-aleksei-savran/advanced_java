package assignment1;

public abstract class Profile {
	protected String _name;
	protected String _surname;
	protected String _status;
	//protected friendlist;
	
	public void setname(String firstname) {
		_name=firstname;
	}
	
	public String getname() {
		return _name;
	}
	
	public void setsurname(String familyname) {
		_surname=familyname;
	}
	
	public String getsurname() {
		return _surname;
	}

	
	public String getstatus() {
		return _status;
	}
	
	
	//public String getfriendlist() {
		//return friendlist;
	
}
