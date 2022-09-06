package reader;
import ticket.Ticket;
import product.TypeOfProduct;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.*; 

/**
 * Class Reader, which scans and processes a ticket.
 * @author: Andrea Olcina
 */
public class Reader {
	//Private Vars
	private Ticket t = new Ticket();

	/**
	 * Scans a ticket and generates a Ticket object. 
	 * @param filename
	 * @throws FileNotFoundException
	 * @throws URISyntaxException
	 */
	public void scan(String filename) throws FileNotFoundException, URISyntaxException {
		 File root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
	     File f = new File(root, filename);
	     Scanner sc = new Scanner(f);
	     
	     while (sc.hasNext()) {
			    String line = sc.nextLine();
			    String qty = "";
				try {
					qty = scanRegexp(line, "^(\\d+).*a");
				} catch (ReaderException e) {
					// TODO Auto-generated catch block
					System.out.println("Ha habido un error en el procesamiento de la línea " + line + ". Revise la cantidad del artículo.");
					return;
				}
		    	 String price = "";
				try {
					price = scanRegexp(line, "^.*a\\s*(\\d+[\\,|\\.]\\d{2})\\s*\\D").replace(",", ".");
				} catch (ReaderException e) {
					// TODO Auto-generated catch block
					System.out.println("Ha habido un error en el procesamiento de la línea '" + line + "'. Revise el precio unitario del artículo.");
					return;
				}
		    	String desc = "";
				try {
					desc = scanRegexp(line, "^\\d+\\s*(.*)\\s*a.*");
					
				} catch (ReaderException e) {
					// TODO Auto-generated catch block
					System.out.println("Ha habido un error en el procesamiento de la línea " + line + ". Revise la descripción del artículo.");
					return;
				}
				t.addProduct(Double.parseDouble(price), Integer.parseInt(qty), desc.trim(), setTypeOfProduct(line), isImported(line));
	     }
	     System.out.println(t);
	}

	/**
	 * Decides the type of the product based on its description.
	 * @param input
	 * @return TypeOfProduct object
	 */
	public TypeOfProduct setTypeOfProduct(String input) {
		Pattern p = Pattern.compile("(libro|bombones|barrita|pastillas)");
		Matcher m = p.matcher(input);
		if (m.find()) {
			return TypeOfProduct.EXEMPT;
		} else {
			return TypeOfProduct.GENERAL;
		}
	}
	
	/**
	 * Decides whether a product is imported or not based on its description.
	 * @param input
	 * @return true or false
	 */
	public boolean isImported(String input) {
		Pattern p = Pattern.compile(".*(importad[o|a]s?).*");
		Matcher m = p.matcher(input);
		return (m.find());
	}
	
	/**
	 * Scans a regular expression pattern (regexp) on an input line and returns its first match.
	 * @param input
	 * @param regexp
	 * @return first regexp match
	 * @throws ReaderException
	 */
	public String scanRegexp(String input, String regexp) throws ReaderException {
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(input);
		if (m.find()) {
			return m.group(1);
		} else {
			throw new ReaderException("Ha habido un problema en el procesamiento del ticket.");
		}
	}
}
