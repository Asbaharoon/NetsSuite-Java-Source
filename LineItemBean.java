

public class LineItemBean  implements LineItem, Comparable<LineItemBean> {
    private String name;
    private double price;
    private int quantity;
    
    public LineItemBean(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public int getQuantity() {
       return (quantity);
    };
  
    @Override
    public String getName() {
        return(name);
    }
    
    public double getPrice() {
        return (price);
    }
    
    void setPrice( double price ) {
        this.price = price;
    }
    void setQuantity (int quantity) {
        this.quantity = quantity;
    }
    
    // make a copy of this item (name and price)
    // does not copy quantity
    // this will protect items in multiple carts from modifying each other's quantity.
    LineItemBean copy() {
        return new LineItemBean(this.name, this.price);
    }
    
    @Override
    public int compareTo( final LineItemBean o) {
        return this.name.compareTo(o.name);
    }    
    
}
