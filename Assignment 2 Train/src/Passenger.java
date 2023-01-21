public class Passenger {
    private int id;
    private String fullName;
    private int age;
    private boolean isDisabled;

    Passenger(){}

    Passenger(int passengerId, String passengerFullName) {
        this.id = passengerId;
        this.fullName = passengerFullName;
    }

    Passenger(int passengerId, String passengerFullName, int age, boolean isDisabled) {
        this.id = passengerId;
        this.fullName = passengerFullName;
        this.age = age;
        this.isDisabled = isDisabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }
}
