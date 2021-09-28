import java.util.List;
import java.util.ArrayList;


public class Ledger
{
    private List<Payment> l;
    Ledger()
    {
        this.l = new ArrayList<Payment>();
    }
    public void make_payment(String source,String recipient,double number,String currency,String method,String code)
    {
        l.add(new Payment(source,recipient,number,currency,method,code));
    }
    public Payment get_last_payment()
    {
        return this.l.get(this.l.size()-1);
    }
    public List<Payment> get_all_payments()
    {
        return new ArrayList<Payment>(this.l);
    }
}
