
import java.util.*;


public class Product {

    private String item;
   private double price;
    private double quantity;
    
    

    public Product(String item, double price, double quantity) {
        this.item=item;
        this.price=price;
        this.quantity=quantity;

    }
    
    public String getItem(){
        return this.item;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public double getQuantity(){
        return this.quantity;
    }
    

}
