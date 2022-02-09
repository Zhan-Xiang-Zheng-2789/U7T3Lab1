import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double total = 0;
        for (MenuItem menuItem : check)
        {
            total += menuItem.getPrice();
        }
        return total;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        for (MenuItem menuItem : check)
        {
            if (menuItem.isDailySpecial())
            {
                return false;
            }
        }
        if (totalPrices() < 40)
        {
            return false;
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        int totalCustomer = 0;
        for (MenuItem menuItem : check)
        {
            if (menuItem.isEntree())
            {
                totalCustomer++;
            }
        }

        double total = totalPrices();
        if (totalCustomer >= 6)
        {
            total += totalPrices()*0.2;
        }

        if (couponApplies())
        {
            total -= 0.25*totalPrices();
        }

        return total;
    }
}