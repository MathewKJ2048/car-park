import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Ticket 
{
    private final String name;
    private final String registration_number;
        
    private static long count=0;
public static String form="F";
       static int n=10;
       
 	public Ticket(Vehicle v)
 	{
 		this.name=v.get_name();
 		this.registration_number=v.get_registration_number();
 		count++;
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

	// public int issue_time(){
	// 	return time;
	// }

	public static void update_info(){

		HashMap <String,Integer> hm = new HashMap<>();


		// initial values in the hashmap to be filled up by the manager
		// indices: F1ME thus there will be n*3*2 = 6n keys


		String s  =""; //has the type: S, M or L.
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