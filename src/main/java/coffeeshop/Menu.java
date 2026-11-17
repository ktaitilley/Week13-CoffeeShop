package coffeeshop;

import java.util.ArrayList;

// STEP 3 · Menu: the 8 things the shop sells.
//
// Open UML.md and find "Step 3 · Menu". The table there lists the 8 items, in order.
//   1 private field: items   (an ArrayList<MenuItem>)
//   1 constructor:   Menu(). It makes the list and adds the 8 items.
//   3 methods:       size(), getItem(int number), toString()
//
// Then drag check/coffeeshop/MenuTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 3: Menu

public class Menu {
    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

    public Menu() {
        items.add(new Drink("Coffee", 2.00, 's'));
        items.add(new Drink("Latte", 3.25, 's'));
        items.add(new Drink("Cappuccino", 3.25, 's'));
        items.add(new Drink("Hot Chocolate", 2.50, 's'));
        items.add(new Drink("Iced Tea", 2.25, 's'));
        items.add(new Food("Bagel", 2.75, false));
        items.add(new Food("Blueberry Muffin", 2.50, false));
        items.add(new Food("Breakfast Sandwich", 4.50, false));


    }

    public int size() {
        return items.size();
    }

    public MenuItem getItem(int number) {
        number = number - 1;
        if (number < 0 || number >= items.size()) {
            return null;
        } else {
            return items.get(number);
        }

    }


    public String toString(){
        String menulist = "";
        for(int i = 0; i < items.size(); i++ ) {
            MenuItem item = items.get(i);
            menulist += (i+1 )+ ". " + item.toString() + "\n";
        }
        return menulist;
    }


}
