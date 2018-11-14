package proyecto.back.entity;

public class UsuarioCambioPass {
	
	private String usuario;
	private String oldpass;
	private String newpass;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getOldpass() {
		return oldpass;
	}
	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}
	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	
	@Override
	public String toString() {
		return "UsuarioCambioPass [usuario=" + usuario + ", oldpass=" + oldpass + ", newpass=" + newpass + "]";
	}
	
	
	
	

}
