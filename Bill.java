import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Bill {
    private long exit_time;
    private Date Exit_Date;
    private SimpleDateFormat Exit_Date_formatted;
    int exit_point;
    long charging_time;
    static double cost_of_electricity_per_hour=10d;
    Ticket v;
    Bill(Ticket v,long charging_time){ //enter the charging time in milli-seconds
        exit_time = System.currentTimeMillis();
        Exit_Date = new Date();
        Exit_Date_formatted = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
        this.v=v;
        Random rand = new Random();
        this.exit_point=1+rand.nextInt(4);
        this.charging_time=charging_time;
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
            cost=40+(hours-3)*5;
        
        cost=cost+(cost_of_electricity_per_hour*((double)(charging_time/3_600_000)));
        return cost;

    }
    public void ChangeCostPerHour(double d){
        cost_of_electricity_per_hour=d;
    }
    public void DisplayBill(){
        Date temp1= new Date();
        SimpleDateFormat temp = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("----------------------------");
        System.out.println("        PARKING RECEIPT        ");
        System.out.println("DATE: ");
        System.out.print(temp.format(temp1));
        System.out.println("----------------------------");
        System.out.println("NAME: "+v.GetName());
        System.out.println("VEHICLE NO: "+v.getReg_no());
        System.out.println("ENTRY POINT: ENTRY"+v.getEntryPoint());
        System.out.println("SLOT ID: "+v.getSlot_id());
        System.out.println("EXIT POINT: EXIT"+exit_point);
        System.out.println("FROM: "+v.Display_Date());
        System.out.println("TO: "+getExit_time());
        System.out.println("Paid: "+CalcCost());
        System.out.println("----------------------------");
        System.out.println("        Thank You!");




    }

}
