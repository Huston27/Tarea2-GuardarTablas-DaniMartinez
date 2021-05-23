package Aplicacion;


public class Persona {
	
	
	public String Nombre;
	public String Apellido1;
	public String Apellido2;
	public String Edad;
	
	public Persona(String nombre, String apellido1, String apellido2, String edad) {
		this.Nombre = nombre;
		this.Apellido1 = apellido1;
		this.Apellido2 = apellido2;
		this.Edad = edad;
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido1() {
		return Apellido1;
	}

	public void setApellido1(String apellido1) {
		this.Apellido1 = apellido1;
	}

	public String getApellido2() {
		return Apellido2;
	}

	public void setApellido2(String apellido2) {
		this.Apellido2 = apellido2;
	}

	public String getEdad() {
		return Edad;
	}

	public void setEdad(String edad) {
		this.Edad = edad;
	}
	
	
	
	
}
