import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;
import reader.Reader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
		// TODO Auto-generated constructor stub
		//Ticket t = new Ticket();
		//Product p1 = new Product(12.49, 1, "libro", TypeOfProduct.EXEMPT, false);
		//Product p2 = new Product(14.99, 1, "CD de música", TypeOfProduct.GENERAL, false);
		//Product p3 = new Product(0.85, 1, "barrita de chocolate", TypeOfProduct.EXEMPT, false);
		
		//t.addProduct(12.49, 1, "libro", TypeOfProduct.EXEMPT, false);
		//t.addProduct(14.99, 1, "CD de música", TypeOfProduct.GENERAL, false);
		//t.addProduct(0.85, 1, "barrita de chocolate", TypeOfProduct.EXEMPT, false);
		
		//System.out.println(t);
		
		//Reader r = new Reader();
		//r.scan("prueba2.txt");
		//r.printTicket();
		
		while(true) {
			Scanner read = new Scanner(System.in);
			System.out.println("Por favor, selecciona un modo: ");
			System.out.println("1 - Ejecución automatizada de pruebas.");
			System.out.println("2 - Introducción manual del nombre del fichero de pruebas.");
			System.out.println("3 - Salir.");
			
			int modo = read.nextInt();
			if (modo == 1) {
				System.out.println("Ejecución automatizada de pruebas.");
				int i = 0;
				for (i = 1; i < 4; i++) {
					Reader r = new Reader();
					System.out.println("---- Prueba " + i + "-----");
					System.out.println("Resultado fichero prueba" + i + ".txt");
					try {
						r.scan("prueba" + i + ".txt");
						r.printTicket();
					} catch (FileNotFoundException e) {
						System.out.println("Parece que el fichero no existe, por favor, revisa la ruta o inténtalo de nuevo.");
					}
				}
			} else if (modo == 2) {
				System.out.println("Introduzca el nombre del fichero con tu ticket: ");
				String filename = read.next();
				Reader r = new Reader();
				try {
					r.scan(filename);
					r.printTicket();
				} catch (FileNotFoundException e) {
					System.out.println("Parece que el fichero no existe, por favor, revisa la ruta o inténtalo de nuevo.");
				}
			} else if (modo == 3) {
				return;
			} else {
				System.out.println("Por favor, introduzca una repsuesta válida.");
			}
			System.out.println("\n");
		}
	}

}
