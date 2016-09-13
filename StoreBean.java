/*
 * ASSUMPTION - single client with the id 0. 
*  Otherwise need to implement a table of IP addresses and client IDs.
 */

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author drago
 */
public class StoreBean implements store {
    private List<LineItem> store = new ArrayList<LineItem>();
    private List<LineItem> cart = new ArrayList<LineItem>();
    
    // to have multiple customers, you need a collection of carts
   
    public void addItemToCart(String name, int quantity) {
        LineItem item = store.get(name);
        
    }

    /*
* Add item with given unique name (ID) and price into store
* inventory. Name is case-sensitive.
     */
    public void addItemToStore(String name, double price) {
        int newid = store.length;
        LineItemBean newthing = new LineItemBean(newid, name, price);
        store[newid] = newthing;
    }

    /*
* Get items in cart, consolidating all duplicate items,
* ordered by item name (ascending).
     */
    public LineItem[] getCartItems(){
        return this.customers[0];
    }

    /*
* Get total cost of items currently in cart.
     */
    public double getCartTotal() {
        double total = 0;
        return total;
    }
    
    private LineItem getItem(String name) {     
        foreach ( LineItem item : store)  {
            if item.name === name) {
                return item;
            }
        }
        return null;
    }
}
