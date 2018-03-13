package assignment1;

public class Dependent extends Profile {
	Parent _parent;
	
	public Dependent (String firstname, String famname, Parent Parent) {
		this.setname(firstname);
		this.setsurname(famname);
		this._parent= Parent;
		}

	public String getParentname(){
		return _parent.getname();
		
	}
	
	public String getParentfamname(){
		return _parent.getsurname();
		
	}
	
}
