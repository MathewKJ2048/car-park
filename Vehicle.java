
public class Vehicle
{
    private final String owner;
    private final String registration_number;
    private final int[] dimensions;//
    private int weight;
    public Vehicle(String owner, String number, int weight, int dimensions[])
    {
        this.owner = owner;
        this.registration_number = number;
        this.weight = weight;
        this.dimensions = dimensions;
    }
}
