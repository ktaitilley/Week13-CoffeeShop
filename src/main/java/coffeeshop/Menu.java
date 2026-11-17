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
    private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();

    public Menu() {
        menu.add(new Drink("Coffee", 2.00, 's'));
        menu.add(new Drink("Latte", 3.25, 's'));
        menu.add(new Drink("Cappuccino", 3.25, 's'));
        menu.add(new Drink("Hot Chocolate", 2.50, 's'));
        menu.add(new Drink("Iced Tea", 2.25, 's'));
        menu.add(new Food("Bagel", 2.75, false));
        menu.add(new Food("Blueberry Muffin", 2.50, false));
        menu.add(new Food("Breakfast Sandwich", 4.50, false));


    }

    public int size() {
        return menu.size();
    }

    public MenuItem getItem(int number) {
        number = number - 1;
        if (number < 0 || number >= menu.size()) {
            return null;
        } else {
            return menu.get(number);
        }

    }


    public String toString(){
        String menulist = "";
        for( int i = 0; i < menu.size(); i++ ) {
            MenuItem item = menu.get(i);
            menulist += (i+1 )+ ". " + item.toString() + "\n";
        }
        return menulist;
    }


}
