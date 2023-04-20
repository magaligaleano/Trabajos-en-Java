package ar.edu.unlam.pb1;

public class Concesionaria {

	private String nombre;
	private Auto flota[];
	private Auto losAutosVendidos[];
	private int cantidadDeAutosVendidos;
	private final int CANTIDAD_MAXIMA = 100;
	
	public Concesionaria() {
		flota = new Auto[CANTIDAD_MAXIMA];
		losAutosVendidos = new Auto[CANTIDAD_MAXIMA];
		cantidadDeAutosVendidos = 0;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean guardarAuto(Auto nuevo) {
		for(int i=0; i<flota.length; i++) {
			if(flota[i]==null) {
				flota[i] = nuevo;
				return true;
			}
		}
		return false;
	}
	
	public boolean venderAuto(int codigoDeAuto) {
		boolean sePudoVender=false;

		if(codigoDeAuto<flota.length && flota[codigoDeAuto-1]!=null) {
			losAutosVendidos[cantidadDeAutosVendidos++] = flota[codigoDeAuto];
			flota[codigoDeAuto-1] = null;
			sePudoVender=true;
		}
		
		return sePudoVender;

	}
	
	public String mostrarAutosDisponibles(){
		
		String resultado ="";
		
		for(int i=0; i<flota.length; i++) {
			if(flota[i]!=null) {
				resultado += "[" + (i+1) + "]" + flota[i].toString() + ", \n";	
			}
		}
		
		return resultado;		
	}
	
	public int getCantidadStock() {
		int cantidadDeAutosEnStock = 0;
		for(int i=0; i<flota.length; i++) {
			if(flota[i]!=null) {
				cantidadDeAutosEnStock++;
			}
		}
		
		return cantidadDeAutosEnStock;
	}

}
