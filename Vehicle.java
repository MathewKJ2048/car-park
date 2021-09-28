
public class Vehicle
{
    private final String name;
    private final String registration_number;
    private final int[] dimensions;//
    private int weight;
    public Vehicle(String owner, String number, int weight, int dimensions[])
    {
        this.name = owner;
        this.registration_number = number;
        this.weight = weight;
        this.dimensions = dimensions;
    }
    public String get_registration_number(){return this.registration_number;}
    public String get_name(){return this.name;}
}
