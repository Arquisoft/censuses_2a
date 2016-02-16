package es.uniovi.asw.DBUpdate.model;

import java.util.Random;

public class Usuario {
	
	private String nombre;
	private String email;
	private String NIF;
	private String password;
	private int codColElectoral;
	private int id;
	
	
	
	public Usuario(String nombre, String email, String NIF, String password,
			int codColElectoral) {
		
		this.nombre = nombre;
		this.email = email;
		this.NIF = NIF;
		this.password = password;
		this.codColElectoral = codColElectoral;
		
	}

	public Usuario(String nombre, String email, String NIF,
			int codColElectoral) {
		
		this.nombre = nombre;
		this.email = email;
		this.NIF = NIF;
		this.password = generarPassword(10);
		this.codColElectoral = codColElectoral;
		
	}
	
	private String generarPassword(int longitud) {
		
		String clave = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r= new Random();
		String retorno="";
		
		for(int i=0;i<longitud;i++){
			
			retorno+=clave.charAt(r.nextInt(clave.length()));
			
		}
		
		return retorno;
		
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNIF() {
		return NIF;
	}
	
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCodColElectoral() {
		return codColElectoral;
	}
	
	public void setCodColElectoral(int codColElectoral) {
		this.codColElectoral = codColElectoral;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", NIF="
				+ NIF + ", password=" + password + ", codColElectoral="
				+ codColElectoral + ", id=" + id + "]";
	}
	
	
	
}
