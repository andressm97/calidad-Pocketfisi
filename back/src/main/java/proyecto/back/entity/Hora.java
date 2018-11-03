package proyecto.back.entity;

public class Hora {
    private int hora;
    private int minutos;
    
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
     @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "la hora es: "+hora+":"+minutos;
    }
    
}
