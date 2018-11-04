package proyecto.back.entity;

public class Perfil {
	
	private String id_profile;
	private String name;
	private String description;
	
	public String getId_profile() {
		return id_profile;
	}
	public void setId_profile(String id_profile) {
		this.id_profile = id_profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name : "+name+"id : "+id_profile+"description: "+description;
	}

	
}
