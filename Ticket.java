import java.text.SimpleDateFormat;
import java.util.*;


public class Ticket {
    private final String name;
    private final String registration_number;
    private static long count=0;
    public static String form="F";
    public long entry_time;
    public Date CurrentDate;
    private SimpleDateFormat currDate;
    private int entry_point;
    static int n;
    public static String s;
    protected boolean iselectric;
    public Vehicle v;
    //The value of n to be entered by manager and value of s can be obtained from get_info function of slot_size class.

    public Ticket(String name, String registration_number,int entry_point,Vehicle v){
        this.name=name;
        this.registration_number=registration_number;
        count++;
        entry_time=System.currentTimeMillis();
        CurrentDate = new Date();
        currDate = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        this.entry_point=entry_point;
        //this.iselectric=iselectric;
        this.v=v;
    }
    public int getEntryPoint(){
        return this.entry_point;
    }
    public String GetName(){
        return name;
    }

    public String getSlot_id(){
        return form;
    }

    public String getReg_no(){
        return registration_number;
    }
    public String Display_Date(){
        String temp = currDate.format(CurrentDate);
        //System.out.println(currDate.format(CurrentDate));
        return temp;
    }



    public static void update_info(){

        HashMap<String,Integer> hm = new HashMap<>();


        // initial values in the hashmap to be filled up by the manager
        // indices: F1ME thus there will be n*3*2 = 6n keys



        for(int i=1;i<=n;i++)
        {
            form+=Integer.toString(i);
            form+=s;
            // System.out.println(form);
            if(hm.get(form)>0)
            {
                hm.replace("form",hm.get(form)-1);
                break;
            }
        }

    }
}
