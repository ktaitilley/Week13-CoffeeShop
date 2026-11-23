package coffeeshop;

// STEP 2 · Drink: a MenuItem that comes in a size, S, M or L.
//
// Open UML.md and find "Step 2 · Drink extends MenuItem".
// First change the class line below to:   public class Drink extends MenuItem {
// (It does not say "extends" yet, so this file still compiles while you work on Step 1.)
//
//   2 constants:     MEDIUM_UPCHARGE, LARGE_UPCHARGE   (public static final double)
//   1 private field: size
//   1 constructor:   Drink(String name, double price, char size). Its first line is super(name, price);
//   4 methods:       getSize(), and the overrides getPrice(), isDrink(), toString()
//
// Then drag check/coffeeshop/DrinkTest.java into src/test/java/coffeeshop/ and run it.
// Commit message (after Food is green too):  step 2: Drink and Food

public class Drink extends MenuItem {
    public static final double MEDIUM_UPCHARGE = .50;
    public static final double LARGE_UPCHARGE = 1.00;
    private char size;

    //constructor for drink
    public Drink(String name, double price, char size){
        super(name,price);
        size = Character.toUpperCase(size);
        if (size == 'M' || size == 'L') {
            this.size = size;
        } else {
            this.size = 'S';
        }
    }

    //get the size of drink
    public char getSize() {
        return size;
    }

    //gets the price
    @Override
    public double getPrice() {
        if (size == 'L'){
            return super.getPrice() + LARGE_UPCHARGE;
        } else if (size == 'M'){
            return super.getPrice() + MEDIUM_UPCHARGE;
        } else {
            return super.getPrice();
        }
    }

    //checks if its a drink
    public boolean isDrink(){
        return true;
    }

    //shows the drink as a string
    public String toString(){
        return getName() + " ("+getSize()+ ") - $" + String.format("%.2f", getPrice());
    }
}
