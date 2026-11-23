package coffeeshop;

import java.util.ArrayList;

// STEP 5 · CoffeeShop: the shop, its menu, and every order it finished today.
//
// Open UML.md and find "Step 5 · CoffeeShop".
//   4 private fields: name, menu, completedOrders, totalSales
//   1 constructor:    CoffeeShop(String name)
//   7 methods:        getName(), getMenu(), checkout(), getOrdersCompleted(),
//                     getTotalSales(), getItemsSold(), salesReport()
//
// Then drag check/coffeeshop/CoffeeShopTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 5: CoffeeShop

public class CoffeeShop {
    private String name;
    private Menu menu;
    private ArrayList<Order> completedOrders;
    private double totalSales;

    // constructor for coffeeshop
    public CoffeeShop(String name) {
        this.name = name;
        this.menu = new Menu();
        this .completedOrders = new ArrayList<>();
        this.totalSales = 0;
    }

    //gets the name
    public String getName() {
        return name;
    }

    //gets the menu
    public Menu getMenu() {
        return menu;
    }

    //calculates the total of the order
    public double checkout(Order order, int tipPercent) {
        if (order.isEmpty()) {
            return 0.0;
        } else{
            order.getTotal(tipPercent);
            completedOrders.add(order);
            totalSales += order.getTotal(tipPercent);
            return order.getTotal(tipPercent);
        }
    }

    //gets how many orders were completed
    public int getOrdersCompleted() {
        return completedOrders.size();
    }

    //gets the total sales
    public double getTotalSales() {
        return totalSales;
    }

    //gets the items sold
    public int getItemsSold(){
        int sold = 0;
        for (Order order : completedOrders) {
            sold+= order.getItemCount();
        }
        return sold;
    }

    //shows the sales report
    public String salesReport(){
        String salesReport =
                "" + name + " - today's sales\n"+
                "\tOrders: "+completedOrders.size()+
                "\n\tItems sold: "+getItemsSold()+
                "\n\tTotal: $" + String.format("%.2f", getTotalSales());
        return  salesReport;
    }

}
