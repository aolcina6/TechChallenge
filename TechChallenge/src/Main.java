import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;
import reader.Reader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
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
				for (i = 1; i < 8; i++) {
					Reader r = new Reader();
					System.out.println("---- Prueba " + i + "-----");
					System.out.println("Resultado fichero prueba" + i + ".txt");
					try {
						r.scan("prueba" + i + ".txt");
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
