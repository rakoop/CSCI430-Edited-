import java.util.*;
import java.io.*;
public class ProductList implements Serializable {
  private static final long serialVersionUID = 1L;
  private List products = new LinkedList();
  private static ProductList productList;
  public ProductList() {
  }
  public static ProductList instance() {
    if (productList == null) {
      return (productList = new ProductList());
    } else {
      return productList;
    }
  }

  public boolean insertProduct(Product product) {
    products.add(product);
    return true;
  }

  public Iterator getProducts(){
     return products.iterator();
  }
  
  public boolean editProductName(String iD, String name) {
	  	String temp;
		for(int i=0; i<products.size(); i++) {
			temp = ((Product) products.get(i)).getId();
			if(temp.equals(iD)) {
				((Product) products.get(i)).setName(name);
				return true;
			}
		}
		return false;
	}
	
  public boolean editProductQuantity(String iD, int quantity) {
	  	String temp;
		for(int i=0; i<products.size(); i++) {
			temp = ((Product) products.get(i)).getId();
			if(temp.equals(iD)) {
				((Product) products.get(i)).setQuantity(quantity);
				return true;
			}
		}
		return false;
	}
	
  public boolean editProductSaleP(String iD, double saleP) {
	  	String temp;
		for(int i=0; i<products.size(); i++) {
			temp = ((Product) products.get(i)).getId();
			if(temp.equals(iD)) {
				((Product) products.get(i)).setSalePrice(saleP);
				return true;
			}
		}
		return false;
	}
	
  public boolean editProductSuppP(String iD, double suppP) {
	  	String temp;
		for(int i=0; i<products.size(); i++) {
			temp = ((Product) products.get(i)).getId();
			if(temp.equals(iD)) {
				((Product) products.get(i)).setSupplyPrice(suppP);
				return true;
			}
		}
		return false;
	}
  
  public Product getProduct(String iD) {
		String temp;
		int count = 0;
		for(int i=0; i<products.size(); i++) {
			temp = ((Product) products.get(i)).getId();
			if(temp.equals(iD)) {
				break;
			}
			count+=1;
		}
		return (Product) products.get(count);
	}
  private void writeObject(java.io.ObjectOutputStream output) {
    try {
      output.defaultWriteObject();
      output.writeObject(productList);
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }
  private void readObject(java.io.ObjectInputStream input) {
    try {
      if (productList != null) {
        return;
      } else {
        input.defaultReadObject();
        if (productList == null) {
          productList = (ProductList) input.readObject();
        } else {
          input.readObject();
        }
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
  public String toString() {
    return products.toString();
  }
}
