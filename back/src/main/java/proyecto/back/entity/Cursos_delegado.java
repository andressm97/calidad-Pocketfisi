package proyecto.back.entity;

public class Cursos_delegado {
	
	private int codigo;
	private String curso;
	private String profesor;
	private String salon;
	
	public String getSalon() {
		return salon;
	}
	public void setSalon(String salon) {
		this.salon = salon;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	@Override
	public String toString() {
		return "Cursos_delegado [codigo=" + codigo + ", curso=" + curso + ", profesor=" + profesor + ", salon=" + salon
				+ "]";
	}
	
	

}
