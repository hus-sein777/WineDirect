
/**
 * Write a description of class WineCase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WineCase {
    // --- Fields ---
    private String refNo;
    private String description;
    private int noOfBottles;
    private double price;

    // --- Constructor ---
    public WineCase(String refNo, String description, int noOfBottles, double price) {
        this.refNo = refNo;
        this.description = description;
        this.noOfBottles = noOfBottles;
        this.price = price;
        // initialise fields
    }

    // --- Accessors ---
    public String getRefNo() {
        
        return refNo;
        // returns the refrence numnber
    }
    public String getDescription() { 
        
        return description; 
        // returns the description
    }
    public int getNoOfBottles() { 
        
        return noOfBottles; 
        // returns number of bottles
    }
    public double getPrice() {
        
        return price;
        // returns price
    }
    
    public String toString() {
    return String.format("%s £%.2f", description, price);
    }


}
