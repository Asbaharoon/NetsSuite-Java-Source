/*
 * ASSUMPTION - single client with the id 0. 
*  Otherwise need to implement a table of IP addresses and client IDs.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author drago
 */
public class StoreBean implements store {

    private List<LineItemBean> catalogue = new ArrayList<>();
    private List<LineItemBean> cart = new ArrayList<>();

    // to have multiple customers, you need a collection of carts
    
    @Override
    public void addItemToCart(String name, int quantity) {
        LineItemBean item = getItem(name, cart);

        // if the item is already in the cart, increase the quantity
        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        } else {

            // use a copy, so that quantity is unique in each cart.
            item = getItem(name, catalogue).copy();
            item.setQuantity(quantity);
            cart.add(item);
            Collections.sort(cart);
        }

    }

    /*
* Add item with given unique name (ID) and price into store
* inventory. Name is case-sensitive.
    * NOTE: This method"can"be"called"multiple"times"for"the"same"item;"that"is,"the"
price"of"items"in"the"store"can"change"at"any"time
     */
    @Override
    public void addItemToStore(String name, double price) {
        LineItemBean newthing = getItem(name, catalogue);

        // check to see if item is already in store
        // should the price be updated?  item rejected?  throw an exception?
        if (newthing != null) {
            newthing.setPrice(price);
            return;
        }

        newthing = new LineItemBean(name, price);
        catalogue.add(newthing);
    }

    /*
* Get items in cart, consolidating all duplicate items,
* ordered by item name (ascending).
     */
    @Override
    public LineItem[] getCartItems() {
        LineItem[] cartarray;

        Collections.sort(cart);
        
        // convert from a fluid collection to a static array
        cartarray = new LineItem[this.cart.size()];
        int i = 0;
        for (LineItem item : cart) {
            cartarray[i] = item;
            i++;
        }
        
        return cartarray;
    }

    /*
* Get total cost of items currently in cart.
     */
    @Override
    public double getCartTotal() {

        // a lambda function could reduce this, but this is so much easier to read
        double total = 0;
        for (LineItemBean item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    private LineItemBean getItem(String name, List<LineItemBean> itemlist) {

        for (LineItemBean item : itemlist) {
            String itemname = item.getName();
            if (itemname.equals(name)) {
                return item;
            }
        }
        return null;
    }

}
