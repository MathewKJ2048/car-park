import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean IsRunning = true;
        boolean manager_function =true;
       Parking_Lot plot=new Parking_Lot();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();
        while(manager_function){
            System.out.println("Set the number of floor in the parking building.");
            int no_of_floors= scanner.nextInt();
            plot.initialise(no_of_floors);
            plot.setNo_of_floors(no_of_floors);
            System.out.println("Enter the number of lots in each floor for small sized vehicles");
            int smallspots= scanner.nextInt();
            System.out.println("Enter the number of lots in each floor for medium sized vehicles");
            int medspots = scanner.nextInt();
            System.out.println("Enter the number of lots in each floor for large sized vehicles");
            int larspots = scanner.nextInt();
            plot.f.get(0).setMax_Small_lot(smallspots);
            plot.f.get(0).setMax_medium_lot(medspots);
            plot.f.get(0).setMax_large_lot(larspots);
            for(int qwe=0;qwe<no_of_floors;qwe++){
                plot.f.get(qwe).initialiselots();
            }
            manager_function=false;
        }
        ArrayList<Integer> EmptySmallSpots = new ArrayList<Integer>(plot.getNo_of_floors());
        ArrayList<Integer> EmptyMediumSpots = new ArrayList<Integer>(plot.getNo_of_floors());
        ArrayList<Integer> EmptyLargeSpots = new ArrayList<Integer>(plot.getNo_of_floors());
        ArrayList<Integer> SmallSlotsOccupied = new ArrayList<Integer>(plot.getNo_of_floors());
        ArrayList<Integer> MediumSlotsOccupied = new ArrayList<Integer>(plot.getNo_of_floors());
        ArrayList<Integer> LargeSlotsOccupied = new ArrayList<Integer>(plot.getNo_of_floors());
        for(int i=0;i< plot.getNo_of_floors();i++){
            SmallSlotsOccupied.add(0);
            EmptySmallSpots.add(0);
        }
        for(int i=0;i< plot.getNo_of_floors();i++){
            MediumSlotsOccupied.add(0);
            EmptyMediumSpots.add(0);
        }
        for(int i=0;i< plot.getNo_of_floors();i++){
            LargeSlotsOccupied.add(0);
            EmptyLargeSpots.add(0);
        }


        //int EmptySmallSpots,EmptyMediumSpots,EmptyLargeSpots,SmallSlotsOccupied=0,MediumSlotsOccupied=0,LargeSlotsOccupied=0;
        while(IsRunning){
            System.out.println("Menu:");
            System.out.println("1.Add vehicles");
            System.out.println("2.Remove vehicles");
            System.out.println("3.Manager settings");
            System.out.println("4.Charge your electric vehicle");
            System.out.println("5.View the free parking lot");
            System.out.println("6.Exit");
            int inp= scanner.nextInt();
            scanner.nextLine();
            for(int k=0;k<plot.getNo_of_floors();k++){
                EmptySmallSpots.set(k,(plot.f.get(0).getMax_Small_lot()-SmallSlotsOccupied.get(k)));
            }
            for(int k=0;k<plot.getNo_of_floors();k++){
                EmptyMediumSpots.set(k,(plot.f.get(0).getMax_medium_lot()-MediumSlotsOccupied.get(k)));
            }
            for(int k=0;k<plot.getNo_of_floors();k++){
                EmptyLargeSpots.set(k,(plot.f.get(0).getMax_large_lot()-LargeSlotsOccupied.get(k)));
            }
//            EmptySmallSpots=plot.f.get(0).getMax_Small_lot()-SmallSlotsOccupied;
//            EmptyMediumSpots=plot.f.get(0).getMax_medium_lot()-MediumSlotsOccupied;
//            EmptyLargeSpots=plot.f.get(0).getMax_large_lot()-LargeSlotsOccupied;
            switch(inp){
                case 1:
                    boolean flag=false;
                    slot_size SlotSize = new slot_size();
                    String temp =slot_size.get_info(scanner);
                    if((temp.charAt(0)=='S' || temp.charAt(0)=='s'))
                    {
                        boolean temp_flag=false;
                        for (int i = 0; i < plot.getNo_of_floors(); i++)
                        {
                            if(EmptySmallSpots.get(i)!=0)
                            {
                                temp_flag=true;

                            for (int j = 0; j < (plot.f.get(i).getMax_Small_lot()); j++)
                            {
                                if (plot.f.get(i).small_lots.get(j).isIs_full())
                                {
                                    continue;
                                }
                                else
                                {
                                    flag = true;
                                    temp = "F" + String.valueOf(i) + temp+String.valueOf(j);
                                    System.out.println("Enter your entry point");
                                    int entpt = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter your name:");
                                    String name = scanner.nextLine();
                                    System.out.println("Enter your vehicle's registration number:");
                                    String regno = scanner.nextLine();
                                    System.out.println("Enter the weight of your vehicle.");
                                    int weight = scanner.nextInt();
                                    Vehicle v = new Vehicle(name, regno, weight, temp);
                                    vehicles.add(v);
                                    Ticket T = new Ticket(name, regno, entpt, v);
                                    tickets.add(T);
                                    System.out.println("vehicle successfully parked.\n Here is your parking lot ID " + temp);
                                    plot.f.get(i).small_lots.get(j).setIs_full();
                                    plot.f.get(i).small_lots.get(j).assign_vehicle(v);
                                    int temp_99=SmallSlotsOccupied.get(i);
                                    SmallSlotsOccupied.set(i,temp_99+1);
                                    break;
                                }

                            }
                            if (flag == true)
                                break;
                            else
                                continue;

                        }
                    }
                    if(temp_flag=false)
                        System.out.println("Sorry there are no vacant spots available");
                    }
                     else if((temp.charAt(0)=='M' || temp.charAt(0)=='m'))
                     {
                         boolean temp_flag=false;
                         for (int i = 0; i < plot.getNo_of_floors(); i++)
                         {
                              if(EmptyMediumSpots.get(i)!=0)
                              {
                                    temp_flag=true;
                                    for (int j = 0; j < (plot.f.get(i).getMax_medium_lot()); j++)
                                        {
                                            if (plot.f.get(i).medium_lots.get(j).isIs_full())
                                                {
                                                    continue;
                                                }
                                            else
                                                {
                                                    flag = true;
                                                    temp = "F" + String.valueOf(i) + temp+String.valueOf(j);
                                                    System.out.println("Enter your entry point");
                                                    int entpt = scanner.nextInt();
                                                    scanner.nextLine();
                                                    System.out.println("Enter your name:");
                                                    String name = scanner.nextLine();
                                                    System.out.println("Enter your vehicle's registration number:");
                                                    String regno = scanner.nextLine();
                                                    System.out.println("Enter the weight of your vehicle.");
                                                    int weight = scanner.nextInt();
                                                    Vehicle v = new Vehicle(name, regno, weight, temp);
                                                    vehicles.add(v);
                                                    Ticket T = new Ticket(name, regno, entpt, v);
                                                    tickets.add(T);
                                                    System.out.println("vehicle successfully parked.\n Here is your parking lot ID " + temp);
                                                    plot.f.get(i).medium_lots.get(j).setIs_full();
                                                    plot.f.get(i).medium_lots.get(j).assign_vehicle(v);
                                                    int temp_99=MediumSlotsOccupied.get(i);
                                                    MediumSlotsOccupied.set(i,temp_99+1);
                                                    break;
                                                 }

                                        }
                                    if (flag == true)
                                        break;
                                    else
                                        continue;

                              }
                         }

                        if(temp_flag=false)
                        System.out.println("Sorry there are no vacant spots available");
                     }
                    else if((temp.charAt(0)=='L' || temp.charAt(0)=='l'))
                    {   boolean temp_flag=false;

                        for (int i = 0; i < plot.getNo_of_floors(); i++)
                        {
                            if(EmptyLargeSpots.get(i)!=0)
                            {
                                temp_flag=true;
                            for (int j = 0; j < (plot.f.get(i).getMax_large_lot()); j++)
                            {
                                if (plot.f.get(i).large_lots.get(j).isIs_full())
                                {
                                    continue;
                                }
                                else
                                {
                                    flag = true;
                                    temp = "F" + String.valueOf(i) + temp+String.valueOf(j);
                                    System.out.println("Enter your entry point");
                                    int entpt = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter your name:");
                                    String name = scanner.nextLine();
                                    System.out.println("Enter your vehicle's registration number:");
                                    String regno = scanner.nextLine();
                                    System.out.println("Enter the weight of your vehicle.");
                                    int weight = scanner.nextInt();
                                    Vehicle v = new Vehicle(name, regno, weight, temp);
                                    vehicles.add(v);
                                    Ticket T = new Ticket(name, regno, entpt, v);
                                    tickets.add(T);
                                    System.out.println("vehicle successfully parked.\n Here is your parking lot ID " + temp);
                                    plot.f.get(i).large_lots.get(j).setIs_full();
                                    plot.f.get(i).large_lots.get(j).assign_vehicle(v);
                                    int temp_99=LargeSlotsOccupied.get(i);
                                    LargeSlotsOccupied.set(i,temp_99+1);
                                    break;
                                }

                            }
                            if (flag == true)
                                break;
                            else
                                continue;

                        }
                    }
                    if(temp_flag=false)
                        System.out.println("Sorry there are no vacant spots available");}
                    break;
                case 2:
                    System.out.println("Enter your vehicle registration number: ");
                    long time=2;
                    String regs=scanner.nextLine();
                    boolean flag1=false;
                    for(int i=0;i< tickets.size();i++){
                        if((tickets.get(i).getReg_no()).equalsIgnoreCase(regs)){
                            if(tickets.get(i).v.getSlot_id().charAt(3)=='E')
                            {
                                int floornum =Character.getNumericValue(tickets.get(i).v.getSlot_id().charAt(1));
                                int num =Character.getNumericValue(tickets.get(i).v.getSlot_id().charAt(4));
                                if(tickets.get(i).v.getSlot_id().charAt(2)=='S')
                                    time=plot.f.get(floornum).small_lots.get(num).e.time_used(0,System.currentTimeMillis());
                                if(tickets.get(i).v.getSlot_id().charAt(2)=='M')
                                    time=plot.f.get(floornum).medium_lots.get(num).e.time_used(0,System.currentTimeMillis());
                                if(tickets.get(i).v.getSlot_id().charAt(2)=='L')
                                    time=plot.f.get(floornum).large_lots.get(num).e.time_used(0,System.currentTimeMillis());
                            }
                            flag1=true;
                            Bill B = new Bill(tickets.get(i),time);
                            B.DisplayBill();
                            int check_floor = Character.getNumericValue(tickets.get(i).v.getSlot_id().charAt(1));
                            int temp98;
                            if((tickets.get(i).v.getSlot_id()).charAt(2)=='M')
                            { temp98 = MediumSlotsOccupied.get(check_floor);
                                MediumSlotsOccupied.set(check_floor,temp98-1);}
                            if((tickets.get(i).v.getSlot_id()).charAt(2)=='S')
                            { temp98 = SmallSlotsOccupied.get(check_floor);
                                SmallSlotsOccupied.set(check_floor,temp98-1);}
                            if((tickets.get(i).v.getSlot_id()).charAt(2)=='L')
                            { temp98 = LargeSlotsOccupied.get(check_floor);
                                LargeSlotsOccupied.set(check_floor,temp98-1);}
                            tickets.remove(i);
                        }

                    }
                    if(flag1==false){
                        System.out.println("Sorry your vehicle is not found.");
                    }
                    break;
                case 3:
                    System.out.println("Welcome to manager settings ,Choose the option you want to change.");
                    System.out.println("1.Increase/Decrease the number of floors");
                    System.out.println("2.Increase/Decrease the number of small lots in a floor");
                    System.out.println("3.Increase/Decrease the number of medium lots in a floor");
                    System.out.println("4.Increase/Decrease the number of large lots in a floor");
                    System.out.println("5.Increase the cost of the electricity per unit hour");
                    int x= scanner.nextInt();
                    switch(x){
                        case 1:
                            System.out.println("Enter the new number of floors.");
                            int y = scanner.nextInt();
                          for(int i=plot.getNo_of_floors();i< y;i++){
                               SmallSlotsOccupied.add(0);
                                EmptySmallSpots.add(0);
                            }
                            for(int i=plot.getNo_of_floors();i< y;i++){
                                MediumSlotsOccupied.add(0);
                              EmptyMediumSpots.add(0);
                            }
                           for(int i=plot.getNo_of_floors();i< y;i++){
                                LargeSlotsOccupied.add(0);
                                EmptyLargeSpots.add(0);
                           }
                            plot.setNo_of_floors(y);
//                            for(int i=0;i< plot.getNo_of_floors();i++) {
////                                plot.f.get(i).setMax_Small_lot(y);
////                                plot.f.get(i).setMax_medium_lot(y);
////                                plot.f.get(i).setMax_large_lot(y);
//
//                            }
                            break;
                        case 2:
                            System.out.println("Enter the new number of small slots");
                            int z = scanner.nextInt();
                            for(int i=0;i< plot.getNo_of_floors();i++)
                                plot.f.get(i).setMax_Small_lot(z);

                            break;
                        case 3:
                            System.out.println("Enter the new number of medium slots");
                            int y1 = scanner.nextInt();
                            for(int i=0;i< plot.getNo_of_floors();i++)
                                plot.f.get(i).setMax_medium_lot(y1);
                            break;
                        case 4:
                            System.out.println("Enter the new number of large slots");
                            int y2 = scanner.nextInt();
                            for(int i=0;i< plot.getNo_of_floors();i++)
                                plot.f.get(i).setMax_large_lot(y2);
                            break;
                        case 5:
                            System.out.println("Enter the new cost");
                            double d=scanner.nextDouble();
                            Bill b = new Bill();
                            b.changecost_per_hour(d);
                            break;

                    }
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Enter your vehicle's registration number: ");
                    regs= scanner.nextLine();
                    boolean temp1=false,temp2=false;
                    for(int i=0;i< tickets.size();i++){
                        if((tickets.get(i).getReg_no()).equalsIgnoreCase(regs)){
                            temp1=true;
                            if(tickets.get(i).v.getSlot_id().charAt(3)=='E')
                            {
                                System.out.println("Do you want to turn on or off");
                                String OnOrOff=scanner.nextLine();
                                if(OnOrOff.equalsIgnoreCase("on")) {
                                    int floornum = Character.getNumericValue(tickets.get(i).v.getSlot_id().charAt(1));
                                    int num = Character.getNumericValue(tickets.get(i).v.getSlot_id().charAt(4));
                                    if (tickets.get(i).v.getSlot_id().charAt(2) == 'S')
                                        plot.f.get(floornum).small_lots.get(num).e.ON();
                                    if (tickets.get(i).v.getSlot_id().charAt(2) == 'M')
                                        plot.f.get(floornum).medium_lots.get(num).e.ON();
                                    if (tickets.get(i).v.getSlot_id().charAt(2) == 'L')
                                        plot.f.get(floornum).large_lots.get(num).e.ON();
                                    temp2 = true;
                                }
                                else if(OnOrOff.equalsIgnoreCase("off")){
                                    int floornum = Character.getNumericValue(tickets.get(i).v.getSlot_id().charAt(1));
                                    int num = Character.getNumericValue(tickets.get(i).v.getSlot_id().charAt(4));
                                    if (tickets.get(i).v.getSlot_id().charAt(2) == 'S')
                                        plot.f.get(floornum).small_lots.get(num).e.OFF();
                                    if (tickets.get(i).v.getSlot_id().charAt(2) == 'M')
                                        plot.f.get(floornum).medium_lots.get(num).e.OFF();
                                    if (tickets.get(i).v.getSlot_id().charAt(2) == 'L')
                                        plot.f.get(floornum).large_lots.get(num).e.OFF();
                                    temp2 = true;
                                }

                            }



                        }

                    }
                    if(temp1==false)
                        System.out.println("Sorry your vehicle is not found");
                    else if(temp2==false)
                        System.out.println("Sorry your vehicle is not compatible with electric charging");
                    else
                        System.out.println("Switch is flipped!");
                    break;
                case 5:
                    for(int i=0;i<plot.getNo_of_floors();i++){
                        System.out.println("The number of free slots for small sized vehicles in floor "+i+" is "+EmptySmallSpots.get(i));
                        System.out.println("The number of free slots for medium sized vehicles in floor "+i+" is "+EmptyMediumSpots.get(i));
                        System.out.println("The number of free slots for large sized vehicles in floor "+i+" is "+EmptyLargeSpots.get(i));
                    }
                        break;
                case 6:
                    IsRunning=false;
                    break;

            }
        }


    }
}
