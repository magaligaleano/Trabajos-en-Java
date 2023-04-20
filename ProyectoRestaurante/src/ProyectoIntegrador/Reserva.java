package ProyectoIntegrador;

import java.util.Scanner;

public class Reserva {
	Scanner teclado = new Scanner(System.in);
	private char cantidadDeMesas[] = {'1','2','3','4','5','6','7','8','9'};
	private String nombre;
	private String apellido;
	private int dni;
	private char nMesaReservada;
	private char mesasOcupadas[];
	private char mesaOcupada;
	
	public Reserva() {
		
	}
	
	public Reserva(String nombre, String apellido,int dni, char nMesaReservada ) {
		 
		 this.nombre = nombre;
		 this.apellido = apellido;
		 this.dni=dni;
		 this.nMesaReservada = nMesaReservada;
		
	}
	public void mostrarMesasDisponibles() {
		for (int i=0;i<cantidadDeMesas.length;i++) {
			if(cantidadDeMesas[i]==' ') {
				System.out.println("Mesa ocupada");
			}else {
			System.out.println("Mesa "+cantidadDeMesas[i]);
				
			}
		}
	}
	
	


public  String getNombre() {
	return nombre;
}


public  String getApellido() {
	return apellido;
}

public long getDni() {
	return dni;
}
public char getNMesaReservada() {
	return nMesaReservada;
}
public String toString() {
	return "Nombre: "+ this.nombre +"\n"+"Apellido: "+this.apellido+"\n"+"Dni: "
			+ this.dni+"\n"+"Numero de mesa reservada: "+this.nMesaReservada +"\n";
}
public boolean verificarMesaOcupada(char nMesa) {
	boolean mesaDisponible=false;
	for(int i=0;i<cantidadDeMesas.length;i++) {

		if(cantidadDeMesas[i]==nMesa) {
			mesaDisponible=true;
			cantidadDeMesas[i]=' ';
			mesaOcupada++;
			mesasOcupadas= new char[mesaOcupada];
			mesasOcupadas[mesaOcupada-1]= nMesa;
			
			
		}
	}return mesaDisponible;
}
public boolean todasLasMesasOcupadas() {
	boolean todasOcupadas = false;
	if(mesasOcupadas==null) {
		return false;
	}
		if(mesasOcupadas.length==9) {
			todasOcupadas=true;
	}
	return todasOcupadas;
}


}