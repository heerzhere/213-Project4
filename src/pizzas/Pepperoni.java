package pizzas;

import java.util.ArrayList;

/**
 * Subclass of pizza that creates an instance of pepperoni pizza.
 * Includes size, toppings, and price variables. 
 * @author Sai Maduri, Heer Patel
 *
 */
public class Pepperoni extends Pizza {

    private String pizzaType = "Pepperoni";

    /**
     * Creates an instance of pepperoni pizza in the order.
     * @param size of pizza
     * @param toppings on pizza
     */
    public Pepperoni(Size size, ArrayList<Topping> toppings) {
        this.size = size;
        this.toppings = toppings;
    }

    /**
     * Generates the price of the pepperoni pizza based on size and toppings.
     */
    @Override
    public double price() {
        double price = Pizza.PEPPERONI_PRICE;
        if (size.name().equals(Pizza.SMALL.toUpperCase())) {
            price += 0;
        } else if (size.name().equals(Pizza.MEDIUM.toUpperCase())) {
            price += Pizza.MEDIUM_PRICE_INCREASE;
        } else if (size.name().equals(Pizza.LARGE.toUpperCase())) {
            price += Pizza.LARGE_PRICE_INCREASE;
        }
        int numToppings = toppings.size();
        if (numToppings > Pizza.PEPPERONI_TOPPINGS_COUNT) {
        	price += Math.min(Pizza.TOPPING_PRICE * (double) Pizza.MAX_TOPPINGS_COUNT, Pizza.TOPPING_PRICE * (double) (numToppings - Pizza.PEPPERONI_TOPPINGS_COUNT));
        }
        return Double.parseDouble(String.format("%,.2f", price));
    }

    /**
     * Converts pizza information into a string printout.
     */
    @Override
    public String toString() {
        return pizzaType.toUpperCase() + ", " + size.name() + ", "
                + toppings.toString().substring(1, toppings.toString().length() - 1) + " , $" + String.valueOf(price());
    }

    /**
     * Set pizza toppings to what the user selected.
     */
    @Override
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    /**
     * Set pizza size to what the user selected.
     */
    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Return the user selected toppings.
     */
    @Override
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Return the user selected size.
     */
    @Override
    public Size getSize() {
        return this.size;
    }

    /**
     * Return the user selected pizza type - Pepperoni.
     */
    @Override
    public String getType() {
        return pizzaType;
    }
}