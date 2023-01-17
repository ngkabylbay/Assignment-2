public class Train {
    private int id;
    private int wagonAmount;
    protected String name;
    private int maxSpeed;
    protected String direction;
    private String date;
    private Wagon[] wagons;
    public Train(){}

    public Train(int id, String name, int wagonAmount, String direction, String date, int maxSpeed) {
        this.id = id;
        this.name = name;
        this.wagonAmount = wagonAmount;
        this.direction = direction;
        this.date = date;
        this.wagons = new Wagon[wagonAmount];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWagonAmount() {
        return wagonAmount;
    }

    public void setWagonAmount(int wagonAmount) {
        this.wagonAmount = wagonAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Wagon[] getWagons() {
        return wagons;
    }

    public void setWagons(Wagon[] wagons) {
        this.wagons = wagons;
    }
}
