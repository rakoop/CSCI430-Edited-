import java.util.*;
import java.io.*;

public class supplier implements Serializable{
	private String name;
	private String id;
	private static final String SUPPLIER_STRING = "S";
	
	public supplier(String name) {
		this.name = name;
		id = SUPPLIER_STRING + (supplierIdServer.instance()).getId();
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String toString() {
		String string = "Supplier name " + name + " Id " + id;
		return string;
	}
	
}