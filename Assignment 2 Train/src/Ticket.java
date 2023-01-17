public class Ticket {
    private int id;
    boolean isChild;
    boolean isDisabled;
    Passenger owner;

    Ticket(){}

    Ticket(int ticketId, Passenger owner){
        this.owner = owner;
        this.id = ticketId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public Passenger getOwner() {
        return owner;
    }

    public void setOwner(Passenger owner) {
        this.owner = owner;
    }
}
