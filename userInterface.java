import java.util.*;
import java.text.*;
import java.io.*;
public class userInterface{
	private static userInterface UI;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static final int EXIT = 0;
	private static final int ADD_SUPPLIER = 1;
	private static final int EDIT_SUPPLIER = 2;
	private static final int PRINT_SUPPLIER = 3;//number for commands here
	private static final int ADD_CLIENT = 4;
	private static final int EDIT_CLIENT = 5;
	private static final int PRINT_CLIENT = 6;
	private static final int ADD_PRODUCT = 7;
	private static final int EDIT_PRODUCT_NAME = 8;
	private static final int EDIT_PRODUCT_QUANTITY = 9;
	private static final int EDIT_PRODUCT_SALE = 10;
	private static final int EDIT_PRODUCT_SUPPLY = 11;
	private static final int PRINT_PRODUCT = 12;
	private static wareHouse warehouse = new wareHouse();
	
	
	private userInterface() {
		warehouse = wareHouse.instance();
	}
	public static userInterface instance() {
		if(UI == null) {
			return UI = new userInterface();
		}else {
			return UI;
		}
	}
	
	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if(tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			}catch(IOException ioe) {
				System.exit(0);
			}
		}while(true);
	}
	
	
	
	public int getCommand() {
		do {
			try {
				int value = Integer.parseInt(getToken("Enter command: "));
				if(value >= EXIT) {
					return value;
				}
			}catch(NumberFormatException nfe) {
				System.out.println("Enter a number");
			}
		}while(true);
	}
	
	
	//Functions here
	
	//Supplier Class
	public void addSupplier() {
		String name = getToken("Enter supplier name: ");
		supplier tempAdd;
		tempAdd = warehouse.addSupplier(name);
		System.out.println("Supplier added: " + tempAdd.getName() + " " + tempAdd.getId());
	}
	
	public void editSupplier() {
		String name = getToken("Enter new supplier name: ");
		String iD = getToken("Enter new supplier ID: ");
		
		supplier tempEdit;
		tempEdit = warehouse.editSupplier(name, iD);
		if(tempEdit == null) {
			System.out.println("Invalid supplier ID");
		}
		else {
			System.out.println("Supplier name changed: " + tempEdit);
		}
		
	}
	
	public void printSupplier() {
		warehouse.printSupplier();
	}
	
	
	//Client Class
	public void addClient() {
		String name = getToken("Enter client name: ");
		client tempAdd;
		tempAdd = warehouse.addClient(name);
		System.out.println("Client added: " + tempAdd.getName() + " " + tempAdd.getId());
	}
	
	public void editClient() {
		String name = getToken("Enter new client name: ");
		String iD = getToken("Enter new client ID: ");
		
		boolean result;
		result = warehouse.editClient(name, iD);
		if(result == false) {
			System.out.println("Invalid client ID");
		}
		else {
			client tempEdit = warehouse.getClient(iD);
			System.out.println("Client name changed: " + tempEdit);
		}
		
	}
	
	public void printClient() {
		warehouse.printClient();
	}
	
	//Product class
	public void addProduct() {
		String name = getToken("Enter product name: ");
		int quantity = Integer.parseInt(getToken("Enter quantity: "));
		double salePrice = Integer.parseInt(getToken("Enter sale price: "));
		double supplyPrice = Integer.parseInt(getToken("Enter supply price: "));
		Product tempAdd = new Product(name, quantity, salePrice, supplyPrice);
		tempAdd = warehouse.addProduct(tempAdd);
		System.out.println("Product added: " + tempAdd);
	}
	
	public void editProductName() {
		String name = getToken("Enter new product name: ");
		String iD = getToken("Enter ID of product: ");
		
		Product result = warehouse.editProductName(iD, name);
		if(result == null) {
			System.out.println("Invalid product ID");
		}
		else {
			System.out.println("Product name changed: " + result);
		}
	}
	
	public void editProductQuantity() {
		int quantity = Integer.parseInt(getToken("Enter new quantity: "));
		String iD = getToken("Enter ID of product: ");
		
		Product result = warehouse.editProductQuantity(iD, quantity);
		if(result == null) {
			System.out.println("Invalid product ID");
		}
		else {
			System.out.println("Product quantity changed: " + result);
		}
	}
	
	public void editProductSaleP() {
		double sale = Integer.parseInt(getToken("Enter new sale price: "));
		String iD = getToken("Enter ID of product: ");
		
		Product result = warehouse.editProductSaleP(iD, sale);
		if(result == null) {
			System.out.println("Invalid product ID");
		}
		else {
			System.out.println("Product sale price changed: " + result);
		}
	}
	
	public void editProductSupplyP() {
		double supply = Integer.parseInt(getToken("Enter new supply price: "));
		String iD = getToken("Enter ID of product: ");
		
		Product result = warehouse.editProductSuppP(iD, supply);
		if(result == null) {
			System.out.println("Invalid product ID");
		}
		else {
			System.out.println("Product supply price changed: " + result);
		}
	}
	
	public void printProduct() {
		warehouse.printProduct();
	}
	
	public void process() {
		int command;
		while((command = getCommand()) != EXIT) {
			switch(command) {
			case ADD_SUPPLIER: addSupplier();
							   break;
			case EDIT_SUPPLIER: editSupplier();
								break;
			case PRINT_SUPPLIER: printSupplier();
								 break;
			case ADD_CLIENT: addClient();
							 break;
			case EDIT_CLIENT: editClient();
							  break;
			case PRINT_CLIENT: printClient();
							   break;
			case ADD_PRODUCT: addProduct();
							  break;
			case EDIT_PRODUCT_NAME: editProductName();
									break;
			case EDIT_PRODUCT_QUANTITY: editProductQuantity();
										break;
			case EDIT_PRODUCT_SALE: editProductSaleP();
									break;
			case EDIT_PRODUCT_SUPPLY: editProductSupplyP();
									  break;
			case PRINT_PRODUCT: printProduct();
								break;
								 
			}
		}
	}
	
	public static void main(String[] s) {
		userInterface.instance().process();
	}
}