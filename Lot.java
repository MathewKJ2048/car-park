
public class Lot
{
    private boolean is_full;
    Vehicle vehicle_in_lot;
    Electric_Panel e;
    public void assign_vehicle(Vehicle v){
        this.vehicle_in_lot=v;
        if(vehicle_in_lot.getSlot_id().charAt(3)=='E')
            e = new Electric_Panel();
    }
    Lot(){
        is_full=false;

    }

    public void setIs_full(){
        if(is_full==false)
            is_full=true;
    }

    public boolean isIs_full() {
        return is_full;
    }
}
