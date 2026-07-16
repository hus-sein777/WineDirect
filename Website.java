
/**
 * Write a description of class Website here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.ArrayList;

public class Website {
    // --- Fields ---
    private String name;
    private int hits;
    private double salesTotal;
    private int maxNumberOfWineCases = 10;

    // --- Constructor ---
    public Website(String name) {
        
        this.name = name;
        this.hits = 0;
        this.salesTotal = 0;
        
        // initialise website
    }

    // --- Behaviour methods ---
    public void buyerLogin(Browser browser) {
        
        this.hits = (hits + 1);
        System.out.println( name + " welcomes buyer " + browser.getID() + ",  you are now logged in");
        browser.setWebsite(this);
        // print welcome message and set website reference
    }

    public void becomeBuyer(Browser browser) {
        
        int yearOfBirth = browser.getYearOfBirth();
        int age = 2025 - yearOfBirth;
        
        if (age < 18) {
            
            System.out.println("Sorry you are too young to become a buyer");
            return;
            
        }
           
        Random rng = new Random();
        int randomID = rng.nextInt(1000) + 1;
        browser.setID(randomID);
        System.out.println("new ID has been generated");
        
        browser.setBuyerStatus(true);
        buyerLogin(browser);
        
        
        
        // check age, assign ID, call buyerLogin
    }

    public boolean checkHitDiscount() {
        
        if (hits % 10 == 0){
            return true;
        }
        else {
            return false;
        }
        // return true if buyer qualifies for discount
    }

    public void checkout(Browser browser)
    {
    if (!browser.getBuyerStatus()) {
        System.out.println("Only buyers can checkout.");
        return;
    }

    ArrayList<WineCase> basket = browser.getBasket();

    if (basketOverFull(basket)) {
        System.out.println("Your basket has too many wine cases. Please remove some before checkout.");
        return;
    }

    if (basket.size() == 0) {
        System.out.println("No wine cases selected.");
        return;
    }

    double total = 0;
    for (WineCase wc : basket) {
        total += wc.getPrice();
    }

    if (basket.size() >= 5) {
        total *= 0.9;
        System.out.println("10% discount applied.");
    }

    double wallet = browser.getWallet();

    if (wallet < total) {
        System.out.println("You do not have enough money to complete this purchase.");
        return;
    }

    browser.setWallet(wallet - total);

    System.out.println("Wine Direct: Serving customer " + browser.getID());
    System.out.println("  Your basket contains:");

    for (WineCase wc : basket) {
        System.out.println("    " + wc.toString());
    }

    System.out.println();
    System.out.println("The total cost is £" + total);

    basket.clear();
     // Processes the checkout for the buyer.
     // Checks if the user is a buyer, calculates the total, applies a discount if applicable, 
     // and updates the wallet balance after the purchase.
     //prints out a receipt

    }

   
   public boolean basketOverFull(ArrayList<WineCase> basket)
    {
    return basket.size() > maxNumberOfWineCases;
    }

}
