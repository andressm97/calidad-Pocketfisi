package proyecto.back.entity;

public class CursosSUM {
	
	private int id_programacion;
	private String docente;
	private String curso;
	private int ciclo;
	private String plan;
	private int matriculados;
	private String dia;
	private int h_inicio;
	private int h_fin;
	private String grupo;
	private String clase;
	private String siglas;
	public int getId_programacion() {
		return id_programacion;
	}
	public void setId_programacion(int id_programacion) {
		this.id_programacion = id_programacion;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public int getMatriculados() {
		return matriculados;
	}
	public void setMatriculados(int matriculados) {
		this.matriculados = matriculados;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public int getH_inicio() {
		return h_inicio;
	}
	public void setH_inicio(int h_inicio) {
		this.h_inicio = h_inicio;
	}
	public int getH_fin() {
		return h_fin;
	}
	public void setH_fin(int h_fin) {
		this.h_fin = h_fin;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String text) {
		this.clase = text;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public int getCiclo() {
		return ciclo;
	}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	

}
