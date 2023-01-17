import java.util.Scanner;

public class Main {
    public static Ticket inputPassenger(){

        Scanner input = new Scanner(System.in);
        System.out.println("Input your Ticket Id");
        int tempTicketID = input.nextInt();

        System.out.println("Input your Id");
        int tempId = input.nextInt();

        System.out.println("Input your Full Name");
        String tempName = input.next();

        System.out.println("Print your Age");
        int tempAge = input.nextInt();

        System.out.println("Are you Disabled?");
        String tempDisable = input.next();
        boolean isDisabled;
        if(tempDisable.toUpperCase().equals("YES")){
            isDisabled = true;
        } else {
            isDisabled = false;
        }

        Passenger inputPassenger = new Passenger(tempId, tempName, tempAge, isDisabled);
        Ticket tempTicket = new Ticket(tempTicketID, inputPassenger);
        return tempTicket;
    }

    public static void printTrain(Train train) {
        System.out.println("Train Id: " + train.getId() + "\nTrains Name: " + train.name + "\n" + "Date: " + train.getDate() + "\nTrain  " + train.getClass() + "\n" + "Wagons amount: " + train.getWagonAmount() + "\n");
    }

    public static void showTrains(Train[] trains, String direction, String date) {
        for (int i = 0; i < trains.length; i++) {
            if(trains[i].getDirection().equals(direction) & trains[i].getDate().equals(date)) {
                printTrain(trains[i]);
            }
        }
        return;
    }

    public static int findTrainId(Train[] trains, int tempId){
        for (int i = 0; i < trains.length; i++) {
            if(trains[i].getId() == tempId) {
                return i;
            }
        }
        return 0;
    }
    public static void passengerOutput(Ticket ticket){
        System.out.println("Id: " + ticket.owner.id
                + "\nName: " + ticket.owner.fullName
                + "\nAge: " + ticket.owner.age
                + "\nDisabled: " + ticket.owner.isDisabled);
    }

    public static void buyTicket(Train[] trains){
        Scanner input = new Scanner(System.in);

        System.out.println("Select direction:\n1)Astana - Almaty\n2)Almaty - Astana");
        int tempDirection = input.nextInt();

        System.out.println("Select date:\n1)16.01.2023\n2)17.01.2023");
        int tempDate = input.nextInt();

        int cases;
        if(tempDirection == 1 & tempDate == 1) {
            cases = 1;
        } else if (tempDirection == 1 & tempDate == 2) {
            cases = 2;
        } else if (tempDirection == 2 & tempDate == 1) {
            cases = 3;
        } else {
            cases = 4;
        }

        switch (cases) {
            case 1:
                showTrains(trains,"Astana - Almaty", "16.01.2023");
                break;

            case 2:
                showTrains(trains,"Almaty - Astana", "17.01.2023");
                break;
            case 3:
                showTrains(trains,"Almaty - Astana", "16.01.2023");
                break;
            case 4:
                showTrains(trains,"Almaty - Astana", "17.01.2023");
                break;
        }
        System.out.println("Select your train Id");
        int addingTrainId = input.nextInt();

        int tempTrainOrder = findTrainId(trains, addingTrainId);
        System.out.println("Your selected train is: ");
        printTrain(trains[tempTrainOrder]);

        System.out.println("Print Yes or No:");
        if(input.next().toUpperCase().equals("NO")) {
            System.out.println("Select your train Id");
            addingTrainId = input.nextInt();

            System.out.println("Your selected train is: ");
            printTrain(trains[tempTrainOrder]);
        } else {
            System.out.println("Select your wagon between 0 and " + trains[tempTrainOrder].getWagonAmount());
            int tempWagonOrder = input.nextInt();

            if(trains[tempTrainOrder].getWagons()[tempWagonOrder].tickets.size() < trains[tempTrainOrder].getWagons()[tempWagonOrder].getSeatAmount()){
                trains[tempTrainOrder].getWagons()[tempWagonOrder].tickets.add(inputPassenger());
                }
        }

    }

    public static void main(String[] args) {

        Train[] trains = new Train[3];
        trains[0] = new HighSpeedTrain(1, "mark1", 6, "Astana - Almaty", "16.01.2023");
        trains[0].getWagons()[0] = new LuxuryWagon();
        trains[0].getWagons()[1] = new LuxuryWagon();
        trains[0].getWagons()[2] = new RestaurantWagon();
        trains[0].getWagons()[3] = new RegularWagon();
        trains[0].getWagons()[4] = new RegularWagon();
        trains[0].getWagons()[5] = new MailWagon();



        trains[1] = new CargoPassengerTrain(2, "mark2", 13, "Almaty - Astana", "17.01.2023");
        trains[1].getWagons()[0] = new RegularWagon();
        trains[1].getWagons()[1] = new RegularWagon();
        trains[1].getWagons()[2] = new RegularWagon();
        trains[1].getWagons()[3] = new RegularWagon();
        trains[1].getWagons()[4] = new RegularWagon();
        trains[1].getWagons()[5] = new RegularWagon();
        trains[1].getWagons()[6] = new RegularWagon();
        trains[1].getWagons()[7] = new FreightWagon();
        trains[1].getWagons()[8] = new FreightWagon();
        trains[1].getWagons()[9] = new FreightWagon();
        trains[1].getWagons()[10] = new FreightWagon();
        trains[1].getWagons()[11] = new FreightWagon();
        trains[1].getWagons()[12] = new MailWagon();

        trains[2] = new LuxuryTrain(3, "mark3", 7, "Almaty - Astana", "16.01.2023");
        trains[2].getWagons()[0] = new LuxuryWagon();
        trains[2].getWagons()[1] = new LuxuryWagon();
        trains[2].getWagons()[2] = new LuxuryWagon();
        trains[2].getWagons()[3] = new LuxuryWagon();
        trains[2].getWagons()[4] = new RestaurantWagon();
        trains[2].getWagons()[5] = new RestaurantWagon();
        trains[2].getWagons()[6] = new MailWagon();

        System.out.println("Please select an action:" + "\n1) Show all trains\n2)Buy Ticket");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                break;

            case 2:
                buyTicket(trains);

        }
        //if(trains[0].getWagons()[0].tickets.size() < trains[0].getWagons()[0].getSeatAmount()){
            //trains[0].getWagons()[0].tickets.add(inputPassenger());
        //}

        //passengerOutput(trains[0].getWagons()[0].tickets.get(0));

        //showDirections(trains, "Astana - Almaty");
        // для ввода пассажира inputPassenger(findEmptySeat(тикетмассив вагона))
        //System.out.println(trains[0].getDirection());
    }
}