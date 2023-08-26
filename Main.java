import Model.Train;
import Model.Passenger;
import Model.Booking;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int currentPassengerCount = 0;
        int currentTrainCount = 0;
        int currentBookingCount = 0;
        Scanner scanner = new Scanner(System.in);
        Passenger[] pass_array;
        pass_array = new Passenger[100];
        Train[] train_array;
        train_array = new Train[20];
        Booking[] booking_array;
        booking_array = new Booking[200];
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH, 11);
        cal1.set(Calendar.DATE, 05);
        cal1.set(Calendar.YEAR, 1996);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a new Passenger");
            System.out.println("2. Display a Passenger");
            System.out.println("3. Add a new Train");
            System.out.println("4. Display a Train");
            System.out.println("5. Add a Booking");
            System.out.println("6. Display all Reservations");
            System.out.println("7. Add Train Objective");
            System.out.println("8. Remove Train Objective");
            System.out.println("9. Add Train Outcome");
            System.out.println("10. Remove Train Outcome");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();// Consume the newline characters

            // Consume the newline character
            switch (choice) {
                case 1:
                    if (currentPassengerCount < pass_array.length) {
                        System.out.print("Enter PassengerName (LastName FirstName MiddleName): ");
                        String name = scanner.nextLine();

                        System.out.print("Enter ID of passenger: ");
                        int pass_id = scanner.nextInt();

                        System.out.print("Enter Mobile No: ");
                        long mobile_no = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Enter Email Id: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter Aadhar number : ");
                        long aadhar_number = scanner.nextLong();
                        // Create the object dynamically

                        System.out.print(
                                "Do you wish for a Passenger Id in sequence or random (Type S for Sequence or Type R for Random): ");
                        String seq_ran = scanner.next();

                        int passengerId = currentPassengerCount + 1;

                        if (seq_ran.equals("S")) {
                            System.out.println("Sequence Chosen");
                            pass_array[currentPassengerCount] = new Passenger(passengerId, name, mobile_no, email,
                                    address, aadhar_number);
                        } else if (seq_ran.equals("R")) {
                            System.out.println("Random Chosen");
                            pass_array[currentPassengerCount] = new Passenger(name, mobile_no, email, address,
                                    aadhar_number);
                        }
                        currentPassengerCount++;
                        System.out.println("Passenger created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more Passengers.");
                    }
                    break;
                case 2:
                    System.out.print("Enter ID of the Passenger to Display: ");
                    int pass_ID_to_display = scanner.nextInt();
                    System.out.println("ID : \t\t" + pass_array[pass_ID_to_display - 1].getPass_id());
                    System.out.println("Name : \t\t" + pass_array[pass_ID_to_display - 1].getFullName());
                    System.out.println("MobileNo : \t\t" + pass_array[pass_ID_to_display - 1].getMobileNo());
                    System.out.println("Email : \t\t" + pass_array[pass_ID_to_display - 1].getEmail());
                    System.out.println("Address : \t\t" + pass_array[pass_ID_to_display - 1].getAddress());
                    System.out.println("Aadhar number : \t" + pass_array[pass_ID_to_display - 1].getAadhar_number());
                    System.out
                            .println("-------------------------------------------------------------------------------");

                    break;
                case 3:
                    if (currentTrainCount < train_array.length) {
                        System.out.print("Enter ID: ");
                        int train_id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Train Name: ");
                        String train_name = scanner.nextLine();
                        System.out.print("Enter Departure: ");
                        String departure = scanner.nextLine();
                        System.out.print("Enter Arrival : ");
                        String arrival = scanner.nextLine();
                        System.out.print("Enter Coach : ");
                        String coach = scanner.nextLine();
                        // Create the object dynamically
                        train_array[currentTrainCount] = new Train();
                        currentTrainCount++;
                        train_array[currentTrainCount - 1].setTrain_id(currentTrainCount);
                        train_array[currentTrainCount - 1].setTrain_id(train_id);
                        train_array[currentTrainCount - 1].setTrain_name(train_name);
                        train_array[currentTrainCount - 1].setDeparture(departure);
                        train_array[currentTrainCount - 1].setArrival(arrival);
                        train_array[currentTrainCount - 1].setCoach(coach);
                        System.out.println("Train information created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot add more Train information.");
                    }

                    break;
                case 4: {
                    System.out.print("Enter Id of the Train to Display: ");
                    int train_id_to_display = scanner.nextInt();
                    System.out.println("TRAIN ID : \t\t" + train_array[train_id_to_display - 1].getTrain_id());
                    System.out.println("TRAIN NAME : \t\t" + train_array[train_id_to_display - 1].getTrain_name());
                    System.out.println("TRAIN DEPARTURE : \t\t" + train_array[train_id_to_display - 1].getDeparture());
                    System.out.println("TRAIN ARRIVAL : \t\t" + train_array[train_id_to_display - 1].getArrival());
                    System.out.println("COACH : \t\t" + train_array[train_id_to_display - 1].getCoach());
                    System.out.println("------------------------------------------------------------------");
                }
                    break;
                case 5:
                    if (currentBookingCount < booking_array.length) {
                        System.out.print("Enter Id of the Passenger for booking: ");
                        int selected_passenger_id = scanner.nextInt();

                        System.out.print("Enter Id of the Train for booking: ");
                        int selected_train_id = scanner.nextInt();

                        System.out.println("Enter the date (year month day) of booking:");
                        int year = scanner.nextInt();
                        int month = scanner.nextInt();
                        int day = scanner.nextInt();
                        // Create a Calendar object and set the input date
                        Calendar booking_date = Calendar.getInstance();
                        booking_date.set(Calendar.YEAR, year);
                        // Calendar months are zero-based (0 - January, 1 - February, ...)
                        booking_date.set(Calendar.MONTH, month - 1);
                        booking_date.set(Calendar.DAY_OF_MONTH, day);

                        booking_array[currentBookingCount] = new Booking();
                        currentBookingCount++;

                        booking_array[currentBookingCount - 1].book_pass_train(pass_array[selected_passenger_id - 1],
                                train_array[selected_train_id - 1], booking_date);

                        System.out.println("BOOKING created and added to the array.");
                    } else {
                        System.out.println("Array is full. Cannot create more BOOKINGS.");
                    }
                    break;
                case 6:
                    for (int i = 0; i <= currentBookingCount - 1; i++) {
                        booking_array[i].display_booked_passenger_train();
                    }
                    break;
                case 7:// add train obj
                    System.out.print("Enter Index of the Train : ");
                    int train_index = Integer.parseInt(String.valueOf(scanner.nextInt()));
                    if (train_index < train_array.length) {
                        System.out.print("Enter Objective for the Train " + train_array[train_index].getTrain_name() + ": ");
                        String objective = scanner.nextLine();
                        train_array[train_index].addTrainObjectives(objective);
                    } else {
                        System.out.println("Enter Proper Index. Index entered does not exist");
                    }
                    break;
                case 8:// remove train obj
                    System.out.print("Enter Index of the Course: ");
                    int train_ind = Integer.parseInt(String.valueOf(scanner.nextInt()));
                    if (train_ind < train_array.length) {
                        System.out.print("Enter index of the Objective to be removed for the Train "+ train_array[train_ind].getTrain_name() + ": ");
                        int objective_no = Integer.parseInt(String.valueOf(scanner.nextInt()));
                        train_array[train_ind].removeTrainObjectives(objective_no);
                    } else {
                        System.out.println("Enter Proper Index. Index entered does not exist");
                    }
                    break;
                case 9:// add train obj
                    System.out.println("Similar to Objectives");
                    break;
                case 10:// add train obj
                    System.out.println("Similar to Objectives");
                    break;
                case 11:
                    System.out.println("THANK YOU VISIT US AGAIN");
                    System.out.println("_________________________________________________________________________");
                    break;
                default:
                    System.out.println("INVALID CHOICE. PLEASE TRY AGAIN.");
                    break;
            }
        } while (choice != 11);
        scanner.close();
    }
}
