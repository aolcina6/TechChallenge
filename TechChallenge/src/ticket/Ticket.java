package ticket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import product.Product;
import product.TypeOfProduct;

public class Ticket {
	private double taxesCost;
	private double totalCost;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public Ticket() {
		// TODO Auto-generated constructor stub
		this.taxesCost = 0.0;
		this.totalCost = 0.0;
	}
	
	public void addProduct(double price, int qty, String desc, TypeOfProduct type, boolean isImported) {
		Product p = new Product(price, qty, desc, type, isImported);
		this.products.add(p);
	}
	
	public double getTaxesCost() {
		int i;
		for (i = 0; i < this.products.size(); i++) {
			this.taxesCost += this.products.get(i).getTotalTaxes();
		}
		this.taxesCost = Math.round(this.taxesCost*100)/100d;
		return this.taxesCost;
	}
	
	public double getTotalCost() {
		int i;
		for (i = 0; i < this.products.size(); i++) {
			this.totalCost += this.products.get(i).getPrice();
		}
		this.totalCost += this.taxesCost;
		this.totalCost = Math.round(this.totalCost*100)/100d;
		return this.totalCost;
	}
	
	@Override 
	public String toString() {
		DecimalFormat df = new DecimalFormat("##.00");
		String str = "";
		int i;
		for(i = 0; i < this.products.size(); i++) {
			str += this.products.get(i).toString();
			str += "\n";
		}
		str += "Impuestos sobre las ventas: ";
		str += df.format(getTaxesCost());
		str += "€";
		str += "\n";
		str += "Total: ";
		str += df.format(getTotalCost());
		str += "€";
		return str;
	}
}
