import java.util.Scanner;

public class slot_size{

    static int dim_o[]=new int[2];
    //stores length & breadth of the "other" type of vehicle(if any).

    static int dim[][]={{10,10},{20,20},{30,30}};
    public void change_dimension(String type,String l_or_b,int dimension){
        if(type.equalsIgnoreCase("s")){
            if(l_or_b.equalsIgnoreCase("l")){
                dim[0][0]=dimension;
            }
            else if(l_or_b.equalsIgnoreCase("b")) {
                dim[0][1]=dimension;
            }
        }
        else if(type.equalsIgnoreCase("m")){
            if(l_or_b.equalsIgnoreCase("l")){
                dim[1][0]=dimension;
            }
            else if(l_or_b.equalsIgnoreCase("b")) {
                dim[1][1]=dimension;
            }
        }
        else if(type.equalsIgnoreCase("l")){
            if(l_or_b.equalsIgnoreCase("l")){
                dim[2][0]=dimension;
            }
            else if(l_or_b.equalsIgnoreCase("b")) {
                dim[2][1]=dimension;
            }

        }


    }
           
    //size of slots(len and breadth) of type S,M,L

    static int type;
    //S-->1 , M-->2 , L-->3;
  


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
    public static String get_info(Scanner sc){


        System.out.println("What type of vehicle is it?\n Enter the value(1/2/3/4) under which the vehicle can be classified\n 1) scooter/motor-cycle/bi-cycle/scooty\n 2) car/van/auto-rickshaw\n 3) truck/loader\n 4) others");
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
        sc.nextLine();
        System.out.println("Is it an electric vehicle? y/n");
        String inp=sc.nextLine();
        if(inp.equalsIgnoreCase("y"))
            slot_req+="E";
        else slot_req+="N";
        return slot_req;
    }

}
