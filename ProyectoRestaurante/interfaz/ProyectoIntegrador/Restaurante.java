package ProyectoIntegrador;

import java.util.Scanner;


public class Restaurante {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Funcionalidades opcionElegida;
		Reserva actual;
		Reserva reservas []=new Reserva[9];
		
		actual = new Reserva();
		
		
		System.out.println("*****Bienvenidos al restaurante Churrasic Park*****\n");
		do {
		mostrarMenu();
		opcionElegida = ejecutarOpcionDeseada(teclado, actual, reservas);
		
		}while(opcionElegida!=Funcionalidades.SALIR);
		 
		 
	}
	private static Funcionalidades ejecutarOpcionDeseada(Scanner teclado, Reserva actual, Reserva reservas[]) {
		Funcionalidades opcionElegida = Funcionalidades.SALIR;
		System.out.println("Ingrese la opcion deseada");
		Funcionalidades opcionesDisponibles[] = Funcionalidades.values();
		int opcionIngresada = teclado.nextInt();
		if(opcionIngresada>opcionesDisponibles.length) {
			System.out.println("Opcion invalida");
		}
		else {
			opcionElegida = opcionesDisponibles[opcionIngresada-1];
		}
		switch(opcionElegida) {
		case RESERVAR:
			Reservar(teclado, actual, reservas);
			
			break;
		case VER_RESERVAS:
			verMisReservas(teclado, reservas);
			
			break;
		case COMPRAR:
			
			int opcion, opcionComida, opcionBebida = 0, opcionPizza;
			String comprar= "" ;
			String comprarMas= "";
			do {
			opcion= mostrarMenuCompra(teclado);
			if(opcion==1) {
				
			
			opcionComida= teclado.nextInt();
			
			switch(opcionComida) {
			case 1: 
				comprar=mostrarPrecio(teclado, 900);
				comprarMas= comprarMas(teclado, comprar);
				
	
			break;
			case 2: 
				comprar=mostrarPrecio(teclado, 2300);
				comprarMas= comprarMas(teclado, comprar);
				
			break;
			case 3:
				comprar=mostrarPrecio(teclado, 1500);
				comprarMas= comprarMas(teclado, comprar);

			break;
			case 4: 
				System.out.println("1. Muzarrella \n"
						+ "2. Jamon y morron\n"
						+ "3. Napolitana \n"
						+ "4. Fugazzetta");
				opcionPizza= teclado.nextInt();
				comprar=mostrarPrecio(teclado, 1300);
				comprarMas= comprarMas(teclado, comprar);
				

			break;
			case 5:
				comprar=mostrarPrecio(teclado, 3300);
				comprarMas= comprarMas(teclado, comprar);
				
			
			break;
			}
			
			}
			 if (opcion==2) {

				 opcionBebida= teclado.nextInt();
			switch(opcionBebida) {
			case 1: 
				comprar=mostrarPrecio(teclado, 3300);
				comprarMas= comprarMas(teclado, comprar);

			break;
			case 2: 
			
				break;
			case 3:
				comprar=mostrarPrecio(teclado, 568);
				comprarMas= comprarMas(teclado, comprar);

//				
				break;
			case 4:
				comprar=mostrarPrecio(teclado, 568);
				comprarMas= comprarMas(teclado, comprar);

				break;
			case 5:
				comprar=mostrarPrecio(teclado, 680);
				comprarMas= comprarMas(teclado, comprar);

				break;
			case 6:
				comprar=mostrarPrecio(teclado, 200);
				comprarMas= comprarMas(teclado, comprar);			
				break;
			}
			 }
			 
			}while(!comprar.equals("N")&& !comprarMas.equals("N"));
			break;
			
		case SALIR:
			System.out.println("*****Saliendo******");
			
			break;
		}
		return opcionElegida;
	}

	private static void mostrarMenu() {
		System.out.println("1 - Realizar una reserva ");
		System.out.println("2 - Ver mis reservas ");
		System.out.println("3 - Realizar una compra");
		System.out.println("4 - Salir");
		
	}
	private static void Reservar(Scanner teclado, Reserva actual, Reserva reservas[]) {
		String nombre, apellido;
		int dni, nuevaReserva = 0;
		char nMesaReservada;
		if(actual.todasLasMesasOcupadas()==true) {
			System.out.println("Todas las mesas ya fueron reservadas :c \n");
		}else {
		System.out.println("Ingrese su nombre:");
		nombre= teclado.next();
		System.out.println("Ingrese su apellido:");
		apellido= teclado.next();
		System.out.println("Ingrese su dni: ");
		dni = teclado.nextInt();
		System.out.println("Estas son las mesas disponibles: ");
		actual.mostrarMesasDisponibles();
		System.out.println("Ingrese el numero de mesa");
		nMesaReservada=teclado.next().charAt(0);
		if(actual.verificarMesaOcupada(nMesaReservada)==true) {
				
		actual = new Reserva(nombre, apellido, dni, nMesaReservada);
		nuevaReserva++;
		reservas[nuevaReserva-1]= actual; 
		
		System.out.println("*******Reserva realizada exitosamente*******\n");

		}else {
			System.out.println("La mesa ya fue reservada \n");
		}
	}
	}
	private static void verMisReservas(Scanner teclado, Reserva reservas[]) {
		int dni;
		boolean dniEncontrado=false;
		System.out.println("Ingrese su dni: ");
		dni= teclado.nextInt();
		for(int i=0;i<reservas.length;i++) {
			if(reservas[i]!=null) {
				
			if(reservas[i].getDni()==dni) {
				dniEncontrado=true;
			}
			if(dniEncontrado==true) {
				System.out.println(reservas[i].toString());
				break;
			}
		}
		
	} if(dniEncontrado==false) {
		System.out.println("No se ha encontrado el dni");
	}

}
	private static int mostrarMenuCompra(Scanner teclado) {
		int opcion = 0;
		do {
		System.out.println("Que desea comprar? \n"
				+ "1 - Platos del menu \n"
				+ "2 - Bebidas");
		opcion = teclado.nextInt();
		if(opcion==1) {
			
		System.out.println("Elija una opcion del menu");
		System.out.println("1 - Churrasco con pure\n"
				+ "2 - Milanesa(napolitana, a caballo) con porcion de papas fritas. Comen 2 personas\n"
				+ "3 - Hamburguesa con porcion papas fritas\n"
				+ "4 - Pizza a eleccion(muzzarella, jamon y morron, napolitana,fugazzetta)\n"
				+ "5 - Picada(papas con o sin cheddar + bastones de muzzarella + aros de cebolla + rabas). Comen 4 personas\n"
				+ "6 - Churrasco de la Casa(cebolla caramelizada + morron asado + porcion de papas fritas/pure)");
		
		}
		if(opcion==2) {
			System.out.println("Elija una bebida");
			System.out.println("1 - Coca cola 2.25L\n"
					+ "2 - Seven Up 2.25L\n"
					+ "3 - Cerveza Patagonia (Amber Lager)730 cc \n"
					+ "4 - Cerveza Patagonia (Porter)730 cc\n"
					+ "5 - Cerveza Corona (Rubia)710 ml \n"
					+ "6 - Agua Mineral Villavicencio 2L\n");
		} 
		if(opcion!=1 && opcion!=2) {
			System.out.println("Opcion Invalida");
		}
		}while(opcion!=1 && opcion!=2);
		return opcion;
	}
	private static String comprarMas(Scanner teclado, String comprar) {
		String comprarMas="";
		if(comprar.equals("S")) {
			System.out.println("Compra realizada exitosamente \n"
					+ "Desea realizar otra compra? \n"
					+ "S----Si \n"
					+ "N----No");
			comprarMas= teclado.next().toUpperCase();
		}
		return comprarMas;
		
	}
	
	private static String mostrarPrecio(Scanner teclado,int precio) {
		String comprar="";
		System.out.println("El precio es de $"+precio+ "\n"
				+ "Desea comprar? \n"
				+ "S----Si \n"
				+ "N----No");
		comprar = teclado.next().toUpperCase();
		
	
		return comprar;
	}
}