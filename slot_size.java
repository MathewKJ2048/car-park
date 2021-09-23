import java.io.*;
import java.util.*;

public class slot_size{

static int dim_o[]=new int[2];
 //stores length & breadth of the "other" type of vehicle(if any).

static int dim[][]=new int[3][2];
 //size of slots(len and breadth) of type S,M,L

static int type;
//S-->1 , M-->2 , L-->3;
public slot_size(int dimensions[]){

	// the values in this constructor need to be given by the manager
	dim=dimensions;
}


// this method is for assigning a slot to the "other" type of vehicle
	public static int other(Scanner sc){
		System.out.println("Doesn't belong to any of the above categories? \nDon't worry, just enter the dimensions of your vehicle i.e. length and breadth: ");
    		dim_o[0]=sc.nextInt();
    		dim_o[1]=sc.nextInt();


    		for(int i=0;i<3;i++)
    		{
    			if(dim_o[0]<=dim[i][0]&&dim_o[1]<=dim[i][1])
    				{
    					type=i+1;
    					break;
    				}
    		}
    		return type;
    	}


//this method is for getting the slot_size; S,M or L
	public static void get_info(Scanner sc){


		System.out.println("What type of vehicle is it?\n Enter the value(1/2/3/4) under which the vehcile can be clasified\n 1) scooter/motor-cycle/bi-cycle/scooty\n 2) car/van/auto-rickshaw\n 3) truck/loader\n 4) others");
		// you can add more vehicle types under 1/2/3 
		type= sc.nextInt();


		if(type==4)
			type=other(sc);

		String slot_req="";

		switch (type) { 

    		case 1:
    		slot_req="S";
    		break;

    		case 2:
			slot_req="M";
    		break;

    		case 3:
    		slot_req="L";
    		break;
    	}
    	System.out.println("Slot type: "+slot_req);
	}




	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		slot_size ob=new slot_size();
		
		get_info(sc);
	}

}