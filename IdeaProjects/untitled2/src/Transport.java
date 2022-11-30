public class Transport
{
    private float speed;
    private int weight;
    private String color;
    private byte[] coordinate;

    public Transport(float speed, int weight, String color, byte[] coordinate)
    {
        System.out.println("Object created!\n");
        setValues(speed, weight, color, coordinate);
        System.out.println(getValues());
    }

    public void setValues(float speed, int weight, String color, byte[] coordinate)
    {
        this.speed = speed;
        this.weight = weight;
        this.color = color;
        this.coordinate = coordinate;
    }

    public String getValues()
    {
        String info = "Object speed: " + speed + "\nWeight: " + weight + "\nColor: " + color + "\n";
        String infoCoordinates = "Coordinates: ";
//        for(int i = 0; i < coordinate.length; i++) {
//            System.out.println(i);
//            infoCoordinates += coordinate[0] + " ";
//        }

        for(int i: coordinate) {
            System.out.println(i);
            infoCoordinates += i + " ";
            // System.out.println(i);
        }
        return info + infoCoordinates + "\n";
    }
}