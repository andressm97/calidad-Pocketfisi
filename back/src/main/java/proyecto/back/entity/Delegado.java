package proyecto.back.entity;

public class Delegado {
		
	private String id_user;
	private int id_programming;
	
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public int getId_programming() {
		return id_programming;
	}
	public void setId_programming(int id_programming) {
		this.id_programming = id_programming;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id_user:"+id_user+" "+"id_programming:"+id_programming;
	}
	

}
