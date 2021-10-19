import java.util.*;
import java.io.*;

public class client implements Serializable{
	private String name;
	private String id;
	private static final String CLIENT_STRING = "M";
	
	public client(String name) {
		this.name = name;
		id = CLIENT_STRING + (clientIdServer.instance()).getId();
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
		String string = "Client name " + name + " Id " + id;
		return string;
	}
	
}