import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Bill {
    private long exit_time;
    private Date Exit_Date;
    private SimpleDateFormat Exit_Date_formatted;
    int exit_point;
    Ticket v;
    long charging_time_used;
    static double rateperhour=10d;

    public static void setRateperhour(double rateperhour) {
        Bill.rateperhour = rateperhour;
    }
    Bill(){

    }

    Bill(Ticket v, long charging_time_used){ //the entered time for charging should be in milliseconds
        exit_time = System.currentTimeMillis();
        Exit_Date = new Date();
        Exit_Date_formatted = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
        this.v=v;
        Random rand = new Random();
        this.exit_point=1+rand.nextInt(4);
        this.charging_time_used=charging_time_used;
    }
    private String getExit_time(){
        return Exit_Date_formatted.format(Exit_Date);
    }
    private double CalcCost(){
        long initial_time=v.entry_time;
        long time_used= (exit_time-initial_time);
        double hours= (double)(time_used/3_600_000);
        double cost;
        if(hours<=1)
            cost=hours*20;
        else if(hours>1 && hours<=3)
            cost=20+(hours-1)*10;
        else
            cost=40+(hours-4)*5;

        cost=cost+(rateperhour*(charging_time_used/3_600_000));
        return cost;

    }
    public void changecost_per_hour(double d){
        rateperhour=d;
    }
    public void DisplayBill(){
        Date temp1= new Date();
        SimpleDateFormat temp = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("----------------------------");
        System.out.println("        PARKING RECEIPT        ");
        System.out.print("       DATE: ");
        System.out.println(temp.format(temp1));
        System.out.println("----------------------------");
        System.out.println("NAME: "+v.GetName());
        System.out.println("VEHICLE NO: "+v.getReg_no());
        System.out.println("ENTRY POINT: ENTRY GATE"+v.getEntryPoint());
        System.out.println("SLOT ID: "+v.v.getSlot_id());
        System.out.println("EXIT POINT: EXIT GATE"+exit_point);
        System.out.println("FROM: "+v.Display_Date());
        System.out.println("TO: "+getExit_time());
        System.out.println("Paid: "+CalcCost());
        System.out.println("----------------------------");
        System.out.println("        Thank You!");


    }

}
