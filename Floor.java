import java.util.ArrayList;
import java.util.List;

public class Floor
{
    
    private static int max_Small_lot,max_medium_lot,max_large_lot; //manager setting

    public void setMax_Small_lot(int max_Small_lot) {
        if(max_Small_lot<Floor.max_Small_lot){
            int diff = Floor.max_Small_lot-max_Small_lot;
            for(int i=0;i<diff;i++){
                small_lots.remove(Floor.max_Small_lot-i-1);
            }
            Floor.max_Small_lot = max_Small_lot;
        }
        else if(max_Small_lot>Floor.max_Small_lot){
            int diff = max_Small_lot-Floor.max_Small_lot;
            for(int i=0;i<diff;i++){
                Lot lot = new Lot();
                small_lots.add(lot);
            }
            Floor.max_Small_lot = max_Small_lot;
        }
        else
            return;

    }
    public void setMax_medium_lot(int max_medium_lot) {
        if(max_medium_lot<Floor.max_medium_lot){
            int diff = Floor.max_medium_lot-max_medium_lot;
            for(int i=0;i<diff;i++){
                medium_lots.remove(Floor.max_medium_lot-i-1);
            }
            Floor.max_medium_lot = max_medium_lot;
        }
        else if(max_medium_lot>Floor.max_medium_lot){
            int diff = max_medium_lot-Floor.max_medium_lot;
            for(int i=0;i<diff;i++){
                Lot lot = new Lot();
                medium_lots.add(lot);
            }
            Floor.max_medium_lot = max_medium_lot;
        }
        else
            return;
    }

    public void setMax_large_lot(int max_large_lot) {
        if(max_large_lot<Floor.max_large_lot){
            int diff = Floor.max_large_lot-max_large_lot;
            for(int i=0;i<diff;i++){
                large_lots.remove(Floor.max_large_lot-i-1);
            }
            Floor.max_large_lot = max_large_lot;
        }
        else if(max_large_lot>Floor.max_large_lot){
            int diff = max_large_lot-Floor.max_large_lot;
            for(int i=0;i<diff;i++){
                Lot lot = new Lot();
                large_lots.add(lot);
            }
            Floor.max_large_lot = max_large_lot;
        }
        else
            return;
    }

    
    public List<Lot> small_lots= new ArrayList<Lot>(max_Small_lot);
    public List<Lot> medium_lots= new ArrayList<Lot>(max_medium_lot);
    public List<Lot> large_lots= new ArrayList<Lot>(max_large_lot);

    public static int getMax_Small_lot() {
        return max_Small_lot;
    }

    public static int getMax_medium_lot() {
        return max_medium_lot;
    }

    public static int getMax_large_lot() {
        return max_large_lot;
    }

    public Floor()
    {

    }
    public void initialiselots(){
        this.max_Small_lot=max_Small_lot;
        this.max_medium_lot=max_medium_lot;
        this.max_large_lot=max_large_lot;

      
        for(int i=0;i<this.max_Small_lot;i++){
            Lot lot = new Lot();
            small_lots.add(lot);
        }
        for(int i=0;i<this.max_medium_lot;i++){
            Lot lot = new Lot();
            medium_lots.add(lot);
        }
        for(int i=0;i<this.max_large_lot;i++){
            Lot lot = new Lot();
            large_lots.add(lot);
        }

    }

}
