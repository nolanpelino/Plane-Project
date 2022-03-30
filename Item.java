import java.sql.Date;
import java.util.ArrayList;

public abstract class Item {
    private double price;

    /**
     * @return Price of an item as a double
     */
    public double getPrice(){
        return this.price;
    }
}