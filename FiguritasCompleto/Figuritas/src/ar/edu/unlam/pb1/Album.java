package ar.edu.unlam.pb1;

public class Album {
	
	private static String selecciones[] = {"Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Irán", "EEUU", "Gales", "Argentina", "Arabia Saudita", "México", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez", "España", "Costa Rica", "Alemania", "Japón", "Bélgica", "Canadá", "Marruecos", "Croacia", "Brasil", "Serbia", "Suiza", "Camerún", "Portugal", "Ghana", "Uruguay", "Corea del Sur"};
	
	private static Figurita figuritasDisponibles[] = new Figurita[704];
	private Figurita figuritasActuales[];
	
	public Album() {
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el correcto funcionamiento de la app
		 */
		figuritasActuales = new Figurita[2000];
	}
	
	public static void inicializarCodigosDeFiguritas() {
		/*
		 * Por cada país debe generar 22 códigos de manera automática por ejemplo QAT1, URU12, COS10
		 */

		int posicionEnFiguritasDisponibles = 0;
		for(int i=0;i<selecciones.length; i++) {
			String nombreCorto = selecciones[i].substring(0, 3).toUpperCase();
			for(int j=0; j<22; j++) {
				String codigoDeLaFigurita = nombreCorto + j;
				figuritasDisponibles[posicionEnFiguritasDisponibles++] = new Figurita(codigoDeLaFigurita, selecciones[i]);
			}
		}
		
	}
	
	public static void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
		/*
		 * En función del código de figurita, se deben actualizar los datos de la misma en figuritasDisponibles 
		 */
		for(int i=0; i<figuritasDisponibles.length; i++) {
			if(figuritasDisponibles[i].getCodigo().equalsIgnoreCase(codigo)) {
				figuritasDisponibles[i].setGrupo(grupo);
				figuritasDisponibles[i].setNombreJugador(nombreJugador);
				figuritasDisponibles[i].setValor(valor);
			}
		}
		
	}
	
	public static Figurita getFigurita(String codigo) {
		/*
		 * En función del código de figurita, devuelve la figurita de figuritasDisponibles
		 */
		Figurita buscada = null;
		for(int i=0; i<figuritasDisponibles.length; i++) {
			if(figuritasDisponibles[i].getCodigo().equalsIgnoreCase(codigo)) {
				buscada =  figuritasDisponibles[i];
			}
		}
		return buscada;
	}
	
	public Figurita[] generarSobre() {
		/*
		 * Se debe calcular y devolver 5 códigos de figurita de manera aleatoria.
		 */
		Figurita sobre[] = new Figurita[5];
		
		for(int i=0; i<sobre.length; i++) {
			int posicion = (int)(Math.random()*704);
			sobre[i] = figuritasDisponibles[posicion];
		}
		
		return sobre;
	}
	
	public boolean agregarFigurita(Figurita nueva) {
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
		for(int i=0; i<figuritasActuales.length;i++) {
			if(figuritasActuales[i] == null) {
				figuritasActuales[i] = nueva;
				return true;
			}
		}
		return false;
	}
	
	public void ordenarFiguritasActuales() {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
		for(int i=1; i<figuritasActuales.length; i++) {
			for(int j=0; j<figuritasActuales.length-1; j++) {
				if(figuritasActuales[j]!=null && figuritasActuales[j+1]!=null && figuritasActuales[j].getCodigo().compareTo(figuritasActuales[j+1].getCodigo())>0) {
					Figurita temporal = figuritasActuales[j];
					figuritasActuales[j] = figuritasActuales[j+1];
					figuritasActuales[j+1] = temporal;
				}
			}
		}
	}
	
	public boolean elAlbumEstaCompleto() {
		/*
		 * Debe verificar que todas las figuritas disponibles estén presentes al menos una vez en las figuritas actuales 
		 */		
		if(calcularPorcentajeCompletado()==100) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double calcularPorcentajeCompletado() {
		/*
		 * Debe calcular el porcentaje de figuritas del album que está completo. Para esto se debe basar en la información de las figuritasDisponibles en relación a las figuritasActuales que se tiene en el album.
		 */
		int figuritasSinRepetir = 0;
		double porcentaje = 0.0;
		for(int i=0; i<figuritasDisponibles.length; i++) {
			for(int j=0; j<figuritasActuales.length; j++) {
				if(figuritasDisponibles[i] != null && figuritasActuales[j]!=null && figuritasDisponibles[i].getCodigo().equals(figuritasActuales[j].getCodigo())) {
					figuritasSinRepetir++;
					i++;
				}
			}
		}
		porcentaje = (double)figuritasSinRepetir*100/figuritasDisponibles.length;
		return porcentaje;
	}
	
	public String toString() {
		String resultado = "";
		for(int i= 0; i<figuritasActuales.length; i++) {
			if(figuritasActuales[i]!=null) {
				resultado += figuritasActuales[i].toString() + "\n";				
			}
		}
		return resultado;
	}
}
