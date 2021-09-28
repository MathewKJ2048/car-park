public class Vehicle
{
    private final String owner;
    private final String registration_number;
    private int weight;
    private String slot_id;
   


    public Vehicle(String owner, String number, int weight,String slot_id)
    {
        this.owner = owner;
        this.registration_number = number;
        this.weight = weight;
        this.slot_id=slot_id;

    }

    public String getSlot_id() {
        return slot_id;
    }

    public String getOwner() {
        return owner;
    }

    public String getRegistration_number() {
        return registration_number;
    }
}
