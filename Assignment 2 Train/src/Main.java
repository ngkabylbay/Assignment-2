import java.util.Scanner;

public class Main {
    public static Ticket ticketIdFinder(Train[] trains, int id){ //поиск билета по айди
        for (int i = 0; i < trains.length; i++) {
            for (int j = 0; j < trains[i].getWagons().length; j++) {
                for (int k = 0; k < trains[i].getWagons()[j].getTickets().size(); k++) {
                    if(trains[i].getWagons()[j].getTickets().get(k).getId() == id){
                        return trains[i].getWagons()[j].getTickets().get(k);
                    }
                }
            }
        }
        return trains[0].getWagons()[0].getTickets().get(0); // нулевой поезд обозначает ошибку
    }

    public static Train trainFinder(Train[] trains, int id){ // находит вагон по айди билета
        for (int i = 0; i < trains.length; i++) {
            for (int j = 0; j < trains[i].getWagons().length; j++) {
                for (int k = 0; k < trains[i].getWagons()[j].getTickets().size(); k++) {
                    if(trains[i].getWagons()[j].getTickets().get(k).getId() == id){
                        return trains[i];
                    }
                }
            }
        }
        return trains[0];
    }

    public static Wagon wagonFinder(Train[] trains, int id){ // находит вагон по айди билета
        for (int i = 0; i < trains.length; i++) {
            for (int j = 0; j < trains[i].getWagons().length; j++) {
                for (int k = 0; k < trains[i].getWagons()[j].getTickets().size(); k++) {
                    if(trains[i].getWagons()[j].getTickets().get(k).getId() == id){
                        return trains[i].getWagons()[j];
                    }
                }
            }
        }
        return trains[0].getWagons()[0];// нулевой поезд обозначает ошибку
    }
    public class passengerSetId {
        public static int id = 6;
    }

    public static Ticket inputPassenger(){

        Scanner input = new Scanner(System.in);

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
        int tempId = passengerSetId.id++;
        Passenger inputPassenger = new Passenger(tempId, tempName, tempAge, isDisabled);
        Ticket tempTicket = new Ticket(tempId, inputPassenger);
        System.out.println("Your ticket id is: " + tempId);
        return tempTicket;
    }

    public static void printTrain(Train train) { // выводит все данные поезда
        System.out.println("Train Id: " + train.getTrainId()
                + "\nTrains Name: " + train.name
                + "\n" + "Date: " + train.getDate()
                + "\nTrain " + train.getClass()
                + "\n" + "Wagons amount: " + train.getWagonAmount()
                + "\nDirection: " + train.direction
                + "\n");
    }

    public static void showTrains(Train[] trains, String direction, String date) { // функция показывающяя все поезда с правильной датой и направлением
        for (int i = 0; i < trains.length; i++) {
            if(trains[i].getDirection().equals(direction) & trains[i].getDate().equals(date)) {
                printTrain(trains[i]);
            }
        }
        return;
    }

    public static void printTicket(Train[] trains, Ticket ticket) { //выводит тикет
        if(trainFinder(trains, ticket.getId()).getTrainName().equals("error")){
            return;
        }
        System.out.println("Train Id: " + trainFinder(trains, ticket.getId()).getTrainId() + // находит поезд по айди билета
                "\nTrain name: " + trainFinder(trains, ticket.getId()).getTrainName() +
                "\nTrain direction: " + trainFinder(trains, ticket.getId()).getDirection() +
                "\nWagon: " + wagonFinder(trains, ticket.getId()).getOrderNumb() +
                "\n"); // находит вагон по айди билета
    }

    public static int findTrainId(Train[] trains, int tempId){
        for (int i = 0; i < trains.length; i++) {
            if(trains[i].getTrainId() == tempId) {
                return i;
            }
        }
        return 0;
    }

    public static void passengerOutput(Ticket ticket){
        if(ticket.owner.getId() == 0) {
            System.out.println("Ticket not Found\n");
            return;
        }
        System.out.println("Id: " + ticket.owner.getId()
                + "\nName: " + ticket.owner.getFullName()
                + "\nAge: " + ticket.owner.getAge()
                + "\nDisabled: " + ticket.owner.isDisabled()
                + "\n");
    }

    public static void buyTicket(Train[] trains){ //продолжение консольного меню для добавления пассажира
        Scanner input = new Scanner(System.in);

        System.out.println("Select direction:\n1 -  Astana -> Almaty\n2 -  Almaty -> Astana"); // выбор направления
        int tempDirection = input.nextInt();

        System.out.println("Select date:\n1)16.01.2023\n2)17.01.2023"); // выбор даты
        int tempDate = input.nextInt();

        int cases; //перебор всех возможных вариянтов
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
                showTrains(trains,"Astana - Almaty", "16.01.2023"); //функция ищущая поезда с подходящим направлением и датой
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

        System.out.println("Select your train Id"); // выбор поезда по айди
        int addingTrainId = input.nextInt();

        int tempTrainOrder = findTrainId(trains, addingTrainId); // поиск поезда по айди
        System.out.println("Your selected train is: ");
        printTrain(trains[tempTrainOrder]);

        System.out.println("Print Yes or No:");
        if(input.next().toUpperCase().equals("NO")) { //повтор если пользыватель ошибся
            System.out.println("Select your train Id");
            addingTrainId = input.nextInt();

            System.out.println("Your selected train is: ");
            printTrain(trains[tempTrainOrder]);
        } else {
            System.out.println("Select your wagon between 0 and " + trains[tempTrainOrder].getWagonAmount()); // выбор между вагонами
            int tempWagonOrder = input.nextInt();

            if(trains[tempTrainOrder].getWagons()[tempWagonOrder].tickets.size() < trains[tempTrainOrder].getWagons()[tempWagonOrder].getSeatAmount()){
                trains[tempTrainOrder].getWagons()[tempWagonOrder].tickets.add(inputPassenger());
                }
        }
    }

    public static void findTicket(Train[] trains){ // выводит данные из билета
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your ticket id:");
        int tempId = input.nextInt();
        printTicket(trains, ticketIdFinder(trains, tempId)); // поиск билета по айди
        passengerOutput(ticketIdFinder(trains, tempId));
    }


    public static void main(String[] args) {
        // обьявляем поезда и вагоны
        Train[] trains = new Train[6];
        //нулевой поезд обозначает ошибку
        trains[0] = new Train(0, "error", 1, "error", "error",0);
        trains[0].getWagons()[0] = new Wagon();
        trains[0].getWagons()[0].getTickets().add(0, new Ticket(2, new Passenger(0, "Error: ticket not found")));

        trains[1] = new HighSpeedTrain(1, "Talgo", 6, "Astana - Almaty", "16.01.2023");
        trains[1].getWagons()[0] = new LuxuryWagon(1);
        trains[1].getWagons()[1] = new LuxuryWagon(2);
        trains[1].getWagons()[2] = new RestaurantWagon(3);
        trains[1].getWagons()[3] = new RegularWagon(4);
        trains[1].getWagons()[4] = new RegularWagon(5);
        trains[1].getWagons()[5] = new MailWagon(6);
        trains[1].getWagons()[0].getTickets().add(new Ticket(1, new Passenger(1, "Kazikhanova Laura", 17, false)));

        trains[2] = new CargoPassengerTrain(2, "Bayterek", 13, "Almaty - Astana", "17.01.2023");
        trains[2].getWagons()[0] = new RegularWagon(1);
        trains[2].getWagons()[1] = new RegularWagon(2);
        trains[2].getWagons()[2] = new RegularWagon(3);
        trains[2].getWagons()[3] = new RegularWagon(4);
        trains[2].getWagons()[4] = new RegularWagon(5);
        trains[2].getWagons()[5] = new RegularWagon(6);
        trains[2].getWagons()[6] = new RegularWagon(7);
        trains[2].getWagons()[7] = new FreightWagon(8);
        trains[2].getWagons()[8] = new FreightWagon(9);
        trains[2].getWagons()[9] = new FreightWagon(10);
        trains[2].getWagons()[10] = new FreightWagon(11);
        trains[2].getWagons()[11] = new FreightWagon(12);
        trains[2].getWagons()[12] = new MailWagon(13);
        trains[2].getWagons()[0].getTickets().add(new Ticket(2, new Passenger(2, "Kabylbay Nurkarim", 18, true)));


        trains[3] = new LuxuryTrain(3, "Thomas", 7, "Almaty - Astana", "16.01.2023");
        trains[3].getWagons()[0] = new LuxuryWagon(1);
        trains[3].getWagons()[1] = new LuxuryWagon(2);
        trains[3].getWagons()[2] = new LuxuryWagon(3);
        trains[3].getWagons()[3] = new LuxuryWagon(4);
        trains[3].getWagons()[4] = new RestaurantWagon(5);
        trains[3].getWagons()[5] = new RestaurantWagon(6);
        trains[3].getWagons()[6] = new MailWagon(7);
        trains[3].getWagons()[0].getTickets().add(new Ticket(3, new Passenger(3, "Korshikov Alimzhan", 92, true)));


        trains[4] = new LuxuryTrain(4, "Thomas's Brother", 8, "Astana - Almaty", "17.01.2023");
        trains[4].getWagons()[0] = new LuxuryWagon(1);
        trains[4].getWagons()[1] = new LuxuryWagon(2);
        trains[4].getWagons()[2] = new LuxuryWagon(3);
        trains[4].getWagons()[3] = new LuxuryWagon(4);
        trains[4].getWagons()[4] = new LuxuryWagon(5);
        trains[4].getWagons()[5] = new LuxuryWagon(6);
        trains[4].getWagons()[6] = new LuxuryWagon(7);
        trains[4].getWagons()[7] = new RestaurantWagon(2);
        trains[4].getWagons()[5].getTickets().add(new Ticket(4, new Passenger(5, "Ricardo Milos", 23, false)));


        trains[5] = new CargoPassengerTrain(5, "Iron Man", 11, "Almaty - Astana", "16.01.2023");
        trains[5].getWagons()[0] = new RegularWagon(1);
        trains[5].getWagons()[1] = new RegularWagon(2);
        trains[5].getWagons()[2] = new RegularWagon(3);
        trains[5].getWagons()[3] = new RegularWagon(4);
        trains[5].getWagons()[4] = new RegularWagon(5);
        trains[5].getWagons()[5] = new RegularWagon(6);
        trains[5].getWagons()[6] = new RegularWagon(7);
        trains[5].getWagons()[7] = new FreightWagon(8);
        trains[5].getWagons()[8] = new FreightWagon(9);
        trains[5].getWagons()[9] = new FreightWagon(10);
        trains[5].getWagons()[10] = new FreightWagon(11);
        trains[4].getWagons()[6].getTickets().add(new Ticket(5, new Passenger(6, "Nursultan Nazarbayev", 9000, true)));

        System.out.println("\nWelcome to Train_Tickets.kz - BEST TRAIN TICKET SHOP IN KZ!!!!! PLZ100%");
        boolean isWorking = true;
        //консольное меню
        while(isWorking) {
            System.out.println("\nPlease select an action:"
                    + "\n1 -  Show all trains"
                    + "\n2 -  Buy Ticket"
                    + "\n3 -  Show ticket information"
                    + "\n4 -  Find train by id"
                    + "\n5 -  Exit");
            Scanner input = new Scanner(System.in);
            //даем выбор функции
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 1; i < trains.length; i++) {
                        printTrain(trains[i]); //функция для вывода всех поездов
                    }
                    break;

                case 2:
                    buyTicket(trains); //функция добавления пассажира
                    break;

                case 3:
                    findTicket(trains); // функция для поиска билетов
                    break;

                case 4:
                    System.out.println("Select your train Id"); // выбор поезда по айди
                    int addingTrainId = input.nextInt();

                    int tempTrainOrder = findTrainId(trains, addingTrainId); // поиск поезда по айди
                    System.out.println("Your selected train is: ");
                    printTrain(trains[tempTrainOrder]);
                    break;

                case 5:
                    System.out.println("Thanks for the session, PLZ100%");
                    isWorking = false;
            }
        }
    }
}