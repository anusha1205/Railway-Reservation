package Model;
public class Booking{
    private String booking_date;
    Passenger ObjPass;
    Train ObjTrain;

    public void booking_pass_train(Passenger tempPass, Train tempTrain, String temp_booking_date)
    {
        ObjPass = tempPass;
        ObjTrain = tempTrain;
        booking_date = temp_booking_date;
    }

    public void display_booked_passenger_train()
    {
        System.out.println("Passenger : "+this.ObjPass.getName()+" booked for Train : "+this.ObjTrain.getTrainName()+" on ");
    }
}
