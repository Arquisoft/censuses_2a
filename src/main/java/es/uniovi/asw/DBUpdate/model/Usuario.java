package es.uniovi.asw.DBUpdate.model;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Clase para crear Usuarios
 * @author dario
 *
 */
public class Usuario {
	
	private String nombre;
	private String email;
	private String NIF;
	private String password;
	private int codColElectoral;
	private int id;
	private String login;
	
	public Usuario() {
		
		this.password = generarPassword(10);
		
	}

	public Usuario(String nombre, String email, String NIF, String password,
			int codColElectoral,int id,String Login) {
		
		this.nombre = nombre;
		//this.email = email;
		setEmail(email);
		setNIF(NIF);		
		this.password = password;
		this.codColElectoral = codColElectoral;
		this.id=id;
		
	}

	public Usuario(String nombre, String email, String NIF,
			int codColElectoral) {
		
		this.nombre = nombre;
		//this.email = email;
		setEmail(email);
		//comprobarNIF(NIF);
		setNIF(NIF);
		this.password = generarPassword(10);
		this.codColElectoral = codColElectoral;
		login=nombre.replace(" ", "");
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
		login=nombre.replace(" ", "");
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		
		if(!validarMail(email)){
			throw new IllegalArgumentException("Email " + email+ " mal formado");
		}
		this.email = email;
		
		
	}
	
	public String getNIF() {
		return NIF;
	}
	
	public void setNIF(String NIF) {
		if(!comprobarDNI(NIF)){
			throw new IllegalArgumentException("DNI " + NIF+ " Incorrecto");
		}
		this.NIF = NIF;
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



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", NIF="
				+ NIF + ", password=" + password + ", codColElectoral="
				+ codColElectoral + ", id=" + id + ", login=" + login + "]";
	}

	private boolean validarMail(String mail){
		
		String patronMail = "^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$";
		
        Pattern patron = Pattern.compile(patronMail);
 
        Matcher comparador = patron.matcher(mail);
       
        if(comparador.matches()){
        	
        	return true;
        }
        
        return false;
		
	}
	
	private boolean comprobarDNI(String dni){
		
		char[] letraDni = {
	            'T','R','W','A','G','M','Y',
	            'F','P','D','X','B','N','J',
	            'Z','S','Q','V','H','L','C',
	            'K','E'}; 
		
		int numero = Integer.valueOf(dni.substring(0, dni.length()-1));
		String letra = dni.substring(dni.length()-1, dni.length());
		numero = numero%23;
		String letraArray= String.valueOf(letraDni[numero]);
		if(!letra.equals( letraArray)){
			return false;
		}
		
		return true;
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
	
}
