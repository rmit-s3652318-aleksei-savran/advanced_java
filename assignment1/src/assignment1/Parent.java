package assignment1;

public class Parent extends Profile{

	Dependent _dependent;
	
	public Parent( String firstname, String famname, Dependent dependent) {
		
		this.setname(firstname);
		this.setsurname(famname);
		this._dependent=dependent;
	}
	
	public String getDepname(){
		return _dependent.getname();
		
	}
	
	public String getDepfamname(){
		return _dependent.getsurname();
		
	}
}
