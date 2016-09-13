

public class LineItemBean  implements LineItem{
    private int id;
    private String name;
    private double price;
    
    public LineItemBean(int id, String name, double price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }
    
    public int getQuantity() {
       return (this.id);
    };
  
    public String getName() {
        return(this.name);
    }
}
