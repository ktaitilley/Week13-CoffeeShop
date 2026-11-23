package coffeeshop;

import java.util.ArrayList;

// STEP 4 · Order: one customer's order.
//
// Open UML.md and find "Step 4 · Order". This is the biggest class. Build it one method at a
// time, and run the test after each one.
//   2 constants:      COUPON_CODE, COUPON_PERCENT   (public static final)
//   1 static field:   nextOrderNumber, starts at 1
//   3 private fields: orderNumber, items, discountPercent
//   1 constructor:    Order()
//   10 methods:       getOrderNumber(), addItem(), removeItem(), getItemCount(), isEmpty(),
//                     getSubtotal(), applyCoupon(), getDiscount(), getTotal(), toString()
//
// Then drag check/coffeeshop/OrderTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 4: Order

public class Order {
    public static final String COUPON_CODE = "HORNET10";
    public static final int COUPON_PERCENT =10;
    private static int nextOrderNumber=1;
    private int orderNumber;
    private ArrayList<MenuItem> items;
    private int discountPercent;

    //constructor for the order
    public Order(){
        this.orderNumber = nextOrderNumber;
        nextOrderNumber++;
        this.items = new ArrayList<>();
        this.discountPercent = 0;
    }

    //gets order number
    public int getOrderNumber() {
        return orderNumber;
    }

    //adds a item
    public void addItem(MenuItem item){
        items.add(item);
    }

    //removes a item
    public boolean removeItem(int number){
        if (number < 1 || number > items.size()) {
            return false;
        }
        items.remove(number - 1);
        return true;
    }

    //get the amount of items
    public int getItemCount(){
        return items.size();
    }

    //tells if the order empty
    public boolean isEmpty(){
        if (items.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    //gets the subtotal
    public double getSubtotal(){
        double subtotal = 0.0;
        for (int i=0; i < items.size(); i++){
            subtotal += items.get(i).getPrice();
        }
        return subtotal;
    }

    //applies coupon to order
    public boolean applyCoupon(String code){
        if (code.trim().equalsIgnoreCase(COUPON_CODE)) {
            this.discountPercent = COUPON_PERCENT;
            return true;
        } else {
            return false;
        }
    }

    //gets the discount
    public double getDiscount(){
        double discount = getSubtotal() * discountPercent/100.0;
        return discount;
    }

    //get the total
    public double getTotal(int tipPercent){
        if (tipPercent < 0) {
            tipPercent = 0;
        }
        double tip = (tipPercent/100.0) * (getSubtotal() - getDiscount());
        double total = tip + (getSubtotal() - getDiscount());
        return total;
    }

    //shows order in a string
    public String toString(){
        String orderList = "Order #" + orderNumber + "\n";
        for (int i = 0; i < items.size(); i++) {
            orderList += "\t  " + (i+1) + ". " + items.get(i) + "\n";
        }

        orderList += "\tSubtotal: $" + String.format("%.2f", getSubtotal());

        if (discountPercent > 0) {
            orderList += "\nDiscount: -$" + String.format("%.2f", getDiscount());
        }

        return orderList;
    }
}
