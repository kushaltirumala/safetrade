/**
 * A price comparator for trade orders.
 * @author Weitung Chen
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{
    private boolean ascending;


    public PriceComparator()
    {
        ascending = true;
    }


    public PriceComparator( boolean asc )
    {
        ascending = asc;
    }


    /**
     * Returns:0 if both orders are market orders; -1 if order1 is market and
     * order2 is limit; 1 if order1 is limit and order2 is market; the
     * difference in prices, rounded to the nearest cent, if both order1 and
     * order2 are limit orders. In the latter case, the difference returned is
     * cents1 - cents2 or cents2 - cents1, depending on whether this is an
     * ascending or descending comparator (ascending is true or false).
     */
    public int compare( TradeOrder order1, TradeOrder order2 )
    {
        if ( order1.isMarket() && order2.isMarket() )
        {
            return 0;
        }
        else if ( order1.isMarket() && order2.isLimit() )
        {
            return -1;
        }
        else if ( order1.isLimit() && order2.isMarket() )
        {
            return 1;
        }
        else if ( ascending )
        {
            return (int)( (order1.getPrice() - order2.getPrice())* 100 ) ;
        }
        else
        {
            return (int)( (order2.getPrice() - order1.getPrice())* 100 );
        }
    }
}