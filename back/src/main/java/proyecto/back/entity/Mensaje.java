package proyecto.back.entity;

public class Mensaje {
	
	private String id_usuario;
	private String asunto;
	private String mensaje;
	private String id_perfil;
	
	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(String id_perfil) {
		this.id_perfil = id_perfil;
	}
	@Override
	public String toString() {
		return "Mensaje [id_usuario=" + id_usuario + ", asunto=" + asunto + ", mensaje=" + mensaje + ", id_perfil="
				+ id_perfil + "]";
	}
	
	
	
	

}
