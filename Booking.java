package Model;
import java.util.Calendar;
import java.util.Date;
public class Booking{
    private Calendar booking_date;
    Passenger ObjPassenger;
    Train ObjTrain;
    public void book_pass_train(Passenger tempPassgr, Train tempTrain, Calendar
            temp_book_date){
        ObjPassenger = tempPassgr;

        ObjTrain = tempTrain;
        booking_date = temp_book_date;
    }
    public void display_booked_passenger_train() {
        System.out.println("\n-----------Thank you Passenger !!----------- \n"+this.ObjPassenger.getFullName()+" has successfully confirmed train reservation on "+this.booking_date.getTime());
        System.out.println("--Your personal details--\n");
        System.out.println("Passenger ID : \t\t"+this.ObjPassenger.getPass_id());
        System.out.println("Mobile No. : \t\t"+this.ObjPassenger.getMobileNo());
        System.out.println("Email : \t\t"+this.ObjPassenger.getEmail());
        System.out.println("Address : "+this.ObjPassenger.getAddress());
        System.out.println("Aadhar Number : \t\t"+this.ObjPassenger.getAadhar_number());
        System.out.println("----Your Train details----\n ");//+this.ObjTrain.getTrain_name()+
        System.out.println("Departure station : \t\t"+this.ObjTrain.getDeparture());
        System.out.println("Arrival station : \t\t"+this.ObjTrain.getArrival());
        System.out.println("Train ID : \t\t"+this.ObjTrain.getTrain_id());
        System.out.println("Name of Train Booked : \t\t"+this.ObjTrain.getTrain_name());
        System.out.println("Coach booked : \t\t"+this.ObjTrain.getCoach());
    }
}