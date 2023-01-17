public class Passenger {
    int id;
    String fullName;
    int age;
    boolean isDisabled;

    Passenger(){}

    Passenger(int passengerId, String passengerFullName, int age, boolean isDisabled) {
        this.id = passengerId;
        this.fullName = passengerFullName;
        this.age = age;
        this.isDisabled = isDisabled;
    }
}
