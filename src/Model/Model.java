package Model;

import java.util.ArrayList;

public class Model
{
    protected managePassenger managePassengerData = new managePassenger();

    public Model()
    {
        managePassengerData.setLinesBeingDisplayed(15);
        managePassengerData.setFirstLineToDisplay(0);
    }

    public managePassenger getManagePassengerData()
    {
        return managePassengerData;
    }
}
