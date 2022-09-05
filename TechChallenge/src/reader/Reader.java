package reader;
import ticket.Ticket;
import product.TypeOfProduct;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.*; 

public class Reader {
	
	private Ticket t = new Ticket();

	public void scan(String filename) throws FileNotFoundException, URISyntaxException {
		 File root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
	     File f = new File(root, filename);
	     Scanner sc = new Scanner(f);
	     
	     while (sc.hasNext()) {
	    	 String line = sc.nextLine();
	    	 String qty = scanRegexp(line, "^(\\d+).*a");
	    	 String price = scanRegexp(line, "^.*a\\s*(\\d+[\\,|\\.]\\d{2})\\s*\\D").replace(",", ".");
	    	 String desc = scanRegexp(line, "^\\d+\\s*(.*)\\s*a.*");
	    	 if (qty.length() <= 0 || price.length() <= 0 || desc.length() <= 0) {
	    		 System.out.println("Ha habido un error en el procesamiento del ticket.");
	    		 break;
	    	 }
	    	 t.addProduct(Double.parseDouble(price), Integer.parseInt(qty), desc.trim(), setTypeOfProduct(line), isImported(line));
	     }
	}

	public void printTicket() {
		System.out.println(t);
	}
	
	public TypeOfProduct setTypeOfProduct(String input) {
		String match = scanRegexp(input,"(libro|bombones|barrita|pastillas)");
		if (match.length() > 0) {
			return TypeOfProduct.EXEMPT;
		} else {
			return TypeOfProduct.GENERAL;
		}
	}
	
	public boolean isImported(String input) {
		String match = scanRegexp(input, ".*(importados?).*");
		return (match.length() > 0);
	}
	
	public String scanRegexp(String input, String regexp) {
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(input);
		if (m.find()) {
			return m.group(1);
		} else {
			return "";
		}
	}
}
