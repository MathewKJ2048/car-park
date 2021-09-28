
public class Lot
{
    private final int dimensions[] ;
    private boolean is_full;
    private String registration_number;//registration number of vehicle currently parked
    Lot(int dimensions[])
    {
        this.dimensions = dimensions;
        is_full = false;
        this.registration_number = "";
    }
    public boolean park(Ticket t)
    {
        if(this.is_full)return false;
        is_full = true;
        this.registration_number = t.getReg_no();
        return true;
    }
    public boolean leave()
    
    {
        if(!this.is_full)return false;
        this.registration_number = "";
        return true;
    }
}
