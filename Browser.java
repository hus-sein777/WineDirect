
/**
 * Write a description of class Browser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class Browser {
    // --- Fields ---
    private int yearOfBirth;
    private String email;
    private int iD;
    private boolean isBuyer;
    private WineCase wineCase;
    private Website website;
    private double wallet;
    private ArrayList<WineCase> basket;
    
    public Browser(int yearOfBirth, String email, int iD) {
        
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.iD = iD;
        
        this.isBuyer = true;
        
        this.website = null;
        this.wineCase = null;
        this.wallet = 0;
        this.basket = new ArrayList<>();

        
        // existing buyer
    }

    public Browser(int yearOfBirth, String email) {
        
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.iD = -1;
        
        this.isBuyer = false;
        
        this.website = null;
        
        this.wineCase = null;
        this.wallet = 0;
        this.basket = new ArrayList<>();

        // new visitor without ID
    }

    // --- Accessors & Mutators ---
    public int getYearOfBirth() { 
        
        return yearOfBirth; 
        // returns year of birth
    }
    public void setYearOfBirth(int yearOfBirth) {
        
        this.yearOfBirth = yearOfBirth;
    // sets a new year of birth
    }

    public String getEmail() { 
        
        return email; 
        // returns email
    }
    public void setEmail(String email) 
    {
        
        this.email = email;
        // sets a new email
    }

    public int getID() { 
        
        return iD; 
        // returnd ID
    }
    public void setID(int iD) {
        
        this.iD = iD;
        // sets new id
    }

    public boolean getBuyerStatus() { 
        
        return isBuyer;
        // returns true or false depending on if they have previously bought
    }
    public void setBuyerStatus(boolean isBuyer) {
    
        this.isBuyer = isBuyer;
        //sets the isBuyer status depending on what the user sets
    }

    public void setWebsite(Website website) {
        
        this.website = website;
        // store website reference
    }
    
    public WineCase getWineCase() {
    
    return wineCase;
    // return the currently selected case (may be null)
    }
    public void setWallet(double wallet)
    {
        
        this.wallet = wallet;
        // changes wallets amount
    }
    
    public double getWallet()
    {
        return wallet;
        //rerturns the value of wallet
    }
    
    public ArrayList<WineCase> getBasket()
    {
        return basket;
        //returns content of basket
    }


    // --- Behaviour methods ---
    public void selectWineCase(WineCase wineCase) {
        
        if (getBuyerStatus()){
            this.wineCase = wineCase;
            basket.add(wineCase);
        }
        else {
            System.out.println("you are not a buyer, please become a buyer before selecting a winecase");
        }

        // choose a wine case if buyer
    }

    public void payForWine() {
        
        if (!getBuyerStatus()) {
        System.out.println("You must be a buyer to make a purchase.");
        return;
        }
        
        if (website == null) {
        System.out.println("You are not logged in to a website.");
        return;
        }
        
        if (wineCase == null) {
        System.out.println("No wine case selected.");
        return;
        }
        
        website.checkout(this);
        // This method connects the buyer's action to the website's checkout function.
    }
    
    public void showBasket() {
    if (basket.isEmpty()) {
        System.out.println("Your basket is empty.");
        return; // Stop execution if the basket is empty
    }
    
    System.out.println("\n=== Your Shopping Basket ===");
    int index = 0;
    while (index < basket.size()) {
        WineCase current = basket.get(index);
        System.out.println((index + 1) + ". " + current.toString()); // Prints the details of each item
        index++;
    }
    System.out.println("===========================\n");
    
    }
    
    public void putWineCaseBack(int position)
    {
    if (position < 0 || position >= basket.size()) {
        System.out.println("Invalid position.");
        return;
    }

    basket.remove(position);
    }
    
    public void putWineCaseBack(String reference)
    {
    int index = 0;

    while (index < basket.size()) {
        WineCase current = basket.get(index);

        if (current.getRefNo().equals(reference)) {
            basket.remove(index);
            return;
        } else {
            index++;
        }
    }

    System.out.println("No wine case with that reference was found.");
    }
    
    public void putExpensiveWineCasesBack(double limit)
    {
    int index = 0;

    while (index < basket.size()) {
        WineCase current = basket.get(index);

        if (current.getPrice() >= limit) {
            basket.remove(index);
            // do NOT increase index here
        } else {
            index++;
        }
    }
    }

    }




