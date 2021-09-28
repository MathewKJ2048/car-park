import java.util.ArrayList;
import java.util.List;
public class Parking_Lot
{
    private static int no_of_floors; //manager settings
    public Ledger l;
    public List<Floor> f=new ArrayList<Floor>(no_of_floors);
    public Parking_Lot()
    {
        l = new Ledger();
    }
    public void initialise(int no_of_floors){
        for(int i=0;i<no_of_floors;i++){
            Floor floor = new Floor();
            f.add(floor);
        }
    }

    public void setNo_of_floors(int NoOfFloors) {
        if(no_of_floors>NoOfFloors) {
            int diff = no_of_floors - NoOfFloors;
            for (int i = 0; i < diff; i++) {
                f.remove(no_of_floors - i-1);
            }
            no_of_floors=NoOfFloors;
        }
        else if(NoOfFloors>no_of_floors){
            int diff = NoOfFloors-no_of_floors;
            for(int i=0;i<diff;i++){
                Floor floor = new Floor();
                floor.initialiselots();
                f.add(floor);
            }
            no_of_floors=NoOfFloors;
        }
        else
            return;

    }

    public int getNo_of_floors() {
        return no_of_floors;
    }
}
