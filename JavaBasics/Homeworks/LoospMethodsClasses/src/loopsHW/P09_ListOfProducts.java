package loopsHW;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P09_ListOfProducts {
	public static void main(String[] args) throws IOException {
		List<Product> products = new ArrayList<Product>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/loopsHW/products.txt"));
			String line;
			
			while ((line = in.readLine()) != null) {
				String[] product = line.split(" ");
				Product prod = new Product(product[0], Double.parseDouble(product[1]));				
				products.add(prod);
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
		
		Collections.sort(products);
		
		PrintWriter writer = new PrintWriter("src/loopsHW/output.txt", "UTF-8");
		for (Product i : products) {
			writer.printf("%.2f %s%n", i.price, i.name);
		}		
		writer.close();		
	}
}

class Product implements Comparable<Product> {
	String name;
	double price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return (double) price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int compareTo(Product arg0) {		
		return Double.compare(price, arg0.price);
	}	
}
