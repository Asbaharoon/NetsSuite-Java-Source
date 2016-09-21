/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author drago
 */
public interface store {

 /*
* Add item with given unique name (ID) and quantity into
* cart. Name is case-sensitive.
     */
    void addItemToCart(String name, int quantity);

    /*
* Add item with given unique name (ID) and price into store
* inventory. Name is case-sensitive.
     */
    void addItemToStore(String name, double price);

    /*
* Get items in cart, consolidating all duplicate items,
* ordered by item name (ascending).
     */
    LineItem[] getCartItems();

    /*
* Get total cost of items currently in cart.
     */
    double getCartTotal();

}
