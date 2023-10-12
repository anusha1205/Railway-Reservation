package Model;

import java.util.ArrayList;

abstract class fileHandlingPassenger {

    //String student_parent_email;
    abstract public ArrayList<Passenger> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Passenger> passengers);
    //public void readCSVFile(String file_path);
    //public void readXMLFile(String file_path);

}
