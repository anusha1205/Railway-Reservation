package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class managePassenger extends fileHandlingPassenger implements Displayable {
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public managePassenger(){
        readJsonFile("src/Model/passengers.json");
    }

    public ArrayList<Passenger> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File("src/Model/passengers.json"));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String name = node.get("name").asText();
                    String email = node.get("email").asText();
                    String address = node.get("address").asText();
                    long aadhar_number = node.get("aadhar_number").asInt();
                    Passenger pass = new Passenger(id,name, email, address, aadhar_number);
                    passengers.add(pass);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return passengers;
    }

    @Override
    public void writeJsonFile(ArrayList<Passenger> passengers) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < passengers.size(); i++)
            {
                // Converting the Java object into a JSON string
                String pass_str = Obj.writeValueAsString(passengers.get(i));
                // Displaying Java object into a JSON string
                System.out.println(pass_str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Email");
        headers.add("Address");
        headers.add("Aadhar Number");

        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the passengers list and then extracts the various attributes of the student such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> passenger_details = new ArrayList<String>();

        passenger_details.add(String.valueOf(passengers.get(line).getId()));
        passenger_details.add(passengers.get(line).getName());
        passenger_details.add(passengers.get(line).getEmail());
        passenger_details.add(passengers.get(line).getAddress());
        passenger_details.add(String.valueOf(passengers.get(line).getAadhar_number()));

        return passenger_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> passengers_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            passengers_subset.add(getLine(i));
        }
        return passengers_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    public ArrayList getTable() {
        return passengers;
    }
}
