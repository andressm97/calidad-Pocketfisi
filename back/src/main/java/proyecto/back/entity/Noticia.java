package proyecto.back.entity;

import java.sql.Date;

public class Noticia {
	
	private int id_news;
	private String title; 
	private String description;
	private String category;
	private String url;
	private Date start;
	private Date ending;
	private String imagen;
	private int id_state;
	private String id_user;
	
	public int getId_news() {
		return id_news;
	}
	public void setId_news(int id_news) {
		this.id_news = id_news;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnding() {
		return ending;
	}
	public void setEnding(Date ending) {
		this.ending = ending;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getId_state() {
		return id_state;
	}
	public void setId_state(int id_state) {
		this.id_state = id_state;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	
	@Override
	public String toString() {
		return "Noticia [id_news=" + id_news + ", title=" + title + ", description=" + description + ", category="
				+ category + ", url=" + url + ", start=" + start + ", ending=" + ending + ", imagen=" + imagen
				+ ", id_state=" + id_state + ", id_users=" + id_user + "]";
	}
	
	
	
	
	
}
