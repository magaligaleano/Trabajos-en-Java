package ar.edu.unlam.pb1;

import java.util.Scanner;

public class Prueba {
	
	public static void main(String[] args) {	
		Funcionalidades opcionElegida;
		Scanner teclado = new Scanner(System.in);
		Concesionaria actual;
		actual = new Concesionaria();
		actual.setNombre("Blue");
		System.out.println("Bienvenido a la concesionaria " + actual.getNombre());
		
		do {
			mostrarMenu();
			opcionElegida = ejecutarOpcionDeseada(teclado, actual);
		} while(opcionElegida!=Funcionalidades.SALIR);

	}

	private static Funcionalidades ejecutarOpcionDeseada(Scanner teclado, Concesionaria actual) {
		Funcionalidades opcionElegida = Funcionalidades.SALIR;
		System.out.println("Ingrese la opción deseada");
		Funcionalidades opcionesDisponibles[] = Funcionalidades.values();
		int opcionIngresada = teclado.nextInt();
		if(opcionIngresada>opcionesDisponibles.length) {
			System.out.println("Opción inválida");
		}
		else {
			opcionElegida = opcionesDisponibles[opcionIngresada-1];
		}	
		
		switch(opcionElegida) {
		case COMPRAR:
			comprarAuto(teclado, actual);
			break;
		case VENDER:
			venderAuto(teclado, actual);
			break;
		case CONSULTAR_STOCK:
			imprimirTitulo("Consultar Stock");
			actual.mostrarAutosDisponibles();
			System.out.println("Cantidad de autos en stock: " + actual.getCantidadStock());
			break;
		case BUSCAR:
			imprimirTitulo("Buscar auto");
			break;
		case CONSULTAR_SUMA_ASEGURADA:
			imprimirTitulo("Consultar suma asegurada");
			break;
		case SALIR:
			imprimirTitulo("Adios");
			break;
		default:
			System.out.println("Opción inválida");
		}
		return opcionElegida;
	}

	private static void venderAuto(Scanner teclado, Concesionaria actual) {
		int codigoDeAutoAVender=0;
		imprimirTitulo("Vender auto");
		System.out.println("Los autos actuales son: ");
		System.out.println(actual.mostrarAutosDisponibles());
		System.out.println("Ingrese el codigo del vehiculo que se vende:");
		codigoDeAutoAVender = teclado.nextInt();
		if(actual.venderAuto(codigoDeAutoAVender)) {
			System.out.println("La venta fue exitosa");
		}
		else {
			System.out.println("La venta no se pudo concretar");
		}
	}

	private static void comprarAuto(Scanner teclado, Concesionaria actual) {
		imprimirTitulo("Comprar auto");
		Auto nuevo = new Auto();
		
		System.out.println("Ingrese la marca");
		nuevo.setMarca(teclado.next());
		System.out.println("Ingrese modelo");
		nuevo.setModelo(teclado.next());
		System.out.println("Ingrese los kilómetros");
		nuevo.setKilometrosActuales(teclado.nextInt());
		if(!nuevo.esCeroKilometro()) {
			System.out.println("Ingrese la patente");
			nuevo.setPatente(teclado.next());
		}
		System.out.println("Ingrese el anio");
		nuevo.setAnio(teclado.nextInt());
		System.out.println("Ingrese el precio");
		nuevo.setPrecio(teclado.nextDouble());

		actual.guardarAuto(nuevo);
	}

	private static void imprimirTitulo(String titulo) {
		System.out.println("*****************");
		System.out.println(titulo);
		System.out.println("*****************");
	}
	
	private static void mostrarMenu() {
		System.out.println("1 - Agregar auto ");
		System.out.println("2 - Vender");
		System.out.println("3 - Consultar el stock");
		System.out.println("4 - Buscar");
		System.out.println("5 - Consultar la suma asegurada");
		System.out.println("6 - Salir");
	}

}
