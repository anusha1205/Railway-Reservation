package View;
import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
public class CenterPanel extends JPanel {
    ArrayList<JButton> header_buttons = new ArrayList<>();
    ArrayList<JButton> passenger_buttons = new ArrayList<>();
    ArrayList<String> fieldValues = new ArrayList<>();

    public CenterPanel() {
        super(new GridBagLayout()); // Use GridBagLayout to arrange components

        GridBagConstraints gbc = new GridBagConstraints();

        // Create the heading label
        JLabel headingLabel = new JLabel("Welcome To Railway Reservation !!!");
        headingLabel.setFont(new Font("SanSerif", Font.ITALIC, 25));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Span 3 columns
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        add(headingLabel, gbc);

        // Create a panel for the Passenger-related buttons
        final JPanel passengerPanel = new JPanel(new GridLayout(1, 3));
        passengerPanel.setBorder(BorderFactory.createTitledBorder("Passengers"));
        String[] addPassengerTextValues = {"NAME", "EMAIL","ADDRESS" , "AADHAR NUMBER"};
        JComponent addPassengerButtonPanel = createStyledButton("Add a Passenger", addPassengerTextValues);
        String[] deletePassengerTextValues = {"ENTER PASSENGER ID"};
        JComponent deletePassengerButtonPanel = createStyledButton("Delete a Passenger",deletePassengerTextValues);
        String[] editPassengerTextValues = {"ID","NAME", "EMAIL", "ADDRESS", "AADHAAR NUMBER"};
        JComponent editPassengerButtonPanel = createStyledButton("Edit a Passenger",editPassengerTextValues);
        String[] addTrainTextValues = {"TRAIN NAME", "DEPARTURE STATION", "ARRIVAL DESTINATION", "COACH"};
        JComponent addTrainButtonPanel = createStyledButton("Add a Train",addTrainTextValues);
        String[] deleteTrainTextValues = {"ENTER ID OF TRAIN"};
        JComponent deleteTrainButtonPanel = createStyledButton("Delete a Train",deleteTrainTextValues);
//        String[] editTrainTextValues = {"NAME", "DEPARTURE", "ARRIVAL", "COACH"};
//        JComponent editTrainButtonPanel = createStyledButton("Edit a Train",editTrainTextValues);
        String[] addBookingTextValues = {"PASSENGER ID", "TRAIN ID"};
        JComponent addBookingButtonPanel = createStyledButton("Add a Booking",addBookingTextValues);
        String[] displayBookingTextValues = {"PASSENGER ID","TRAIN ID"};
        JComponent displayBookingButtonPanel = createStyledButton("Display a Booking",displayBookingTextValues);
        String[] display = {

        };



        // Create the "Add a Passenger" button panel with text fields
        passengerPanel.add(addPassengerButtonPanel);
        passengerPanel.add(deletePassengerButtonPanel);
        passengerPanel.add(editPassengerButtonPanel);


        gbc.gridy = 1; // Move to the next row
        gbc.gridwidth = 1; // Reset gridwidth
        add(passengerPanel, gbc);

        // Create the middle division with train-related buttons
        JPanel middlePanel = new JPanel(new GridLayout(1, 3));
        middlePanel.setBorder(BorderFactory.createTitledBorder("Trains"));

        middlePanel.add(addTrainButtonPanel);
        middlePanel.add(deleteTrainButtonPanel);
//        middlePanel.add(editTrainButtonPanel);

        gbc.gridy = 2; // Move to the next row
        add(middlePanel, gbc);

        // Create the bottom division with enrollment-related buttons
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("BOOKINGS"));

        JPanel displayPanel = new JPanel(new GridLayout(1,2));
        displayPanel.setBorder(BorderFactory.createTitledBorder("DISPLAY"));

        bottomPanel.add(addBookingButtonPanel);
        bottomPanel.add(displayBookingButtonPanel);

        gbc.gridy = 3; // Move to the next row
        add(bottomPanel, gbc);
        gbc.gridy = 4;
        add(displayPanel,gbc);
    }

    private JComponent createStyledButton(String text, String[] textValues) {
        JPanel panel = new JPanel(new GridBagLayout());

        JButton button = new JButton(text);
        button.setFont(new Font("SanSerif", Font.BOLD, 16));
        button.setForeground(Color.BLACK); // Orange text color
        button.setFocusPainted(false); // Remove focus border

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        buttonConstraints.anchor = GridBagConstraints.CENTER;
        buttonConstraints.insets = new Insets(5, 5, 5, 5); // Padding
        panel.add(button, buttonConstraints);

        // Create a vertical layout for text fields
        JPanel textFieldsPanel = new JPanel(new GridLayout(textValues.length, 1));

        // Add editable text fields with default text values
        ArrayList<JTextField> textFields = new ArrayList<>(); // Create a list to store the text fields
        ArrayList<JLabel> labelFields = new ArrayList<>();
        for (int i = 0; i < textValues.length; i++) {

            JTextField textField = new JTextField(textValues[i]);
            textFields.add(textField); // Add the text field to the list
            textFieldsPanel.add(textField);

        }

        GridBagConstraints textFieldsConstraints = new GridBagConstraints();
        textFieldsConstraints.gridx = 0;
        textFieldsConstraints.gridy = 1;
        textFieldsConstraints.anchor = GridBagConstraints.CENTER;
        textFieldsConstraints.insets = new Insets(5, 5, 5, 5); // Padding
        panel.add(textFieldsPanel, textFieldsConstraints);

        if (text.equals("Add a Passenger")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
                    managePassenger mm1 = new managePassenger();
                    passengers = mm1.readJsonFile("src/Model/passengers.json");
                    ObjectMapper mapper = new ObjectMapper();

                    int id = passengers.size() + 1;
                    JTextField nameTextField = textFields.get(0); String name = nameTextField.getText();
                    JTextField emailTextField = textFields.get(1); String email = emailTextField.getText();
                    JTextField addressTextField = textFields.get(2); String address = addressTextField.getText();
                    JTextField aadhar_numberTextField = textFields.get(3); long aadhar_number = Long.parseLong(aadhar_numberTextField.getText());
                    id+=1;
                    Passenger pass = new Passenger(id,name,email,address,aadhar_number);
                    passengers.add(pass);
                    JOptionPane.showMessageDialog(panel, "Passenger Registered Successfully !", "DONE", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        mapper.writeValue(Paths.get("src/Model/passengers.json").toFile(), passengers);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
        else if (text.equals("Edit a Passenger")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
                    managePassenger mm1 = new managePassenger();
                    passengers = mm1.readJsonFile("src/Model/passengers.json");
                    ObjectMapper mapper = new ObjectMapper();

                    JTextField idTextField = textFields.get(0); int id = Integer.parseInt(idTextField.getText());
                    JTextField nameTextField = textFields.get(1); String name = nameTextField.getText(); passengers.get(id-1).setName(name);
                    JTextField emailTextField = textFields.get(2); String email = emailTextField.getText();passengers.get(id-1).setEmail(email);
                    JTextField addressTextField = textFields.get(3); String address = addressTextField.getText(); passengers.get(id-1).setAddress(address);
                    JTextField aadhar_numberTextField = textFields.get(4); long aadhar_number = Integer.parseInt(aadhar_numberTextField.getText());passengers.get(id-1).setAadhar_number(aadhar_number);
                    Passenger pass = new Passenger(id,name,email,address,aadhar_number);
                    passengers.add(pass);
                    JOptionPane.showMessageDialog(panel, "Passenger Updated", "DONE", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        mapper.writeValue(Paths.get("src/Model/passengers.json").toFile(), passengers);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
        else if (text.equals("Delete a Passenger")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
                    managePassenger mm1 = new managePassenger();
                    passengers = mm1.readJsonFile("src/Model/passengers.json");
                    ObjectMapper mapper = new ObjectMapper();
                    JTextField idTextField = textFields.get(0); int id = Integer.parseInt(idTextField.getText());
                    passengers.remove(id-1);
                    JOptionPane.showMessageDialog(panel, "Passenger Deleted Successfully !", "DONE", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        mapper.writeValue(Paths.get("src/Model/passengers.json").toFile(), passengers);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
        else if (text.equals("Add a Train")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Train> trains = new ArrayList<Train>();
                    manageTrain mb1 = new manageTrain();
                    trains = mb1.readJsonFile("src/Model/train.json");
                    ObjectMapper mapper = new ObjectMapper();
                    int trainId = trains.size() + 1;

                    JTextField train_nameTextField = textFields.get(0);
                    String train_name = train_nameTextField.getText();
                    JTextField train_departTextField = textFields.get(1);
                    String train_depart = train_departTextField.getText();
                    JTextField train_arrivalTextField = textFields.get(2);
                    String train_arrival = train_arrivalTextField.getText();
                    JTextField train_coachTextField = textFields.get(3);
                    String train_coach = train_coachTextField.getText();
                    Train bd = new Train(trainId, train_name, train_depart, train_arrival, train_coach);
                    trains.add(bd);
                    JOptionPane.showMessageDialog(panel, "Train Created", "DONE", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        mapper.writeValue(Paths.get("src/Model/train.json").toFile(), trains);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
//        else if (text.equals("Edit a Train")) {
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    ArrayList<Train> trains = new ArrayList<Train>();
//                    manageTrain mb1 = new manageTrain();
//                    trains = mb1.readJsonFile("src/Model/train.json");
//                    ObjectMapper mapper = new ObjectMapper();
//
//                    JTextField train_idTextField = textFields.get(0);
//                    int train_id = Integer.parseInt(train_idTextField.getText());
//                    JTextField trainNameTextField = textFields.get(1);
//                    String train_name = trainNameTextField.getText();
//                    trains.get(train_id-1).setTrainName(train_name);
//                    JTextField trainDepartTextField = textFields.get(2);
//                    String train_depart = trainDepartTextField.getText();
//                    trains.get(train_id-1).setTrainDepart(train_depart);
//                    JTextField trainArrivalTextField = textFields.get(3);
//                    String train_arrival = trainArrivalTextField.getText();
//                    trains.get(train_id-1).setTrainArrial(train_arrival);
//                    JTextField trainCoachTextField = textFields.get(3);
//                    String train_coach = trainCoachTextField.getText();
//                    trains.get(train_id-1).setTrainCoach(train_coach);
//
//                    Train bd = new Train(train_id,train_name,train_depart,train_arrival,train_coach);
//                    trains.add(bd);
//                    JOptionPane.showMessageDialog(panel, "Train Updated", "DONE", JOptionPane.INFORMATION_MESSAGE);
//                    try {
//                        mapper.writeValue(Paths.get("src/Model/train.json").toFile(),trains);
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//            });
//        }
        else if (text.equals("Delete a Train")){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Train> trains = new ArrayList<Train>();
                    manageTrain mb1 = new manageTrain();
                    trains = mb1.readJsonFile("src/Model/train.json");
                    ObjectMapper mapper = new ObjectMapper();

                    JTextField trainIdTextField = textFields.get(0);
                    int trainId = Integer.parseInt(trainIdTextField.getText());
                    trains.remove(trainId-1);
                    JOptionPane.showMessageDialog(panel, "Train Deleted Successfully !", "DONE", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        mapper.writeValue(Paths.get("src/Model/train.json").toFile(),trains);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
        else if(text.equals("Add a Booking")){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int count = 0;
                    Booking[] book_array;
                    book_array = new Booking[200];
                    Train[] train_array;
                    train_array = new Train[1000];
                    Passenger[] pass_array;
                    pass_array = new Passenger[1000];

                    JTextField midTextField = textFields.get(0);
                    int mid = Integer.parseInt(midTextField.getText());

                    JTextField bidTextField = textFields.get(0);
                    int bid = Integer.parseInt(bidTextField.getText());

//                    JTextField dojTextField = textFields.get(0);
//                    String doj = dojTextField.getText();

                    book_array[count] = new Booking();
                    count++;
//                    book_array[count-1].display_booked_passenger_train();
                    book_array[count-1].booking_pass_train(pass_array[mid-1],train_array[bid-1]);

                    JOptionPane.showMessageDialog(panel, "Booking Added !", "DONE", JOptionPane.INFORMATION_MESSAGE);

                }
            });
        }
        else if (text.equals("Display a Booking")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
                    managePassenger mm1 = new managePassenger();
                    passengers = mm1.readJsonFile("src/Model/passengers.json");
                    mm1.writeJsonFile(passengers);
                    ArrayList<String> passengerss = mm1.getHeaders();
                    //  customers = mm1.getLine();
                    ArrayList<ArrayList<String>> passengersss = mm1.getLines(1,15);
                    passengerss = mm1.getTable();

                    JOptionPane.showMessageDialog(panel, "PASSENGER BOOKED SUCCESSFULLY", "DONE", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
        return panel;
    }

    public void createDisplay ( int rows, int cols)
    {
        this.setLayout(new GridLayout(rows + 1, cols));
        for (int i = 1; i <= cols; i++) {
            JButton b = new JButton();
            b.setBackground(Color.cyan);
            b.setPreferredSize(new Dimension(80, 25));
            header_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
        for (int i = 1; i <= rows * cols; i++) {
            JButton b = new JButton();
            b.setBackground(Color.cyan);
            b.setPreferredSize(new Dimension(120, 25));
            passenger_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }

    }

    public void updateDisplay (ArrayList < ArrayList < String >> lines, ArrayList < String > headers){
        for (int i = 0; i < headers.size(); i++) {
            setHeaderButtonText(i, headers.get(i));
        }

        for (int player_no = 0; player_no < lines.size(); player_no++) {
            for (int player_col_no = 0; player_col_no < headers.size(); player_col_no++) {
                int button_no = player_no * headers.size() + player_col_no;
                String button_txt = lines.get(player_no).get(player_col_no);
                setPlayerButtonText(button_no, button_txt);
            }
        }
    }

    public void setHeaderButtonText ( int button_no, String button_text){
        header_buttons.get(button_no).setText(button_text);
    }
    public void setPlayerButtonText ( int button_no, String button_text){
        passenger_buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getHeaderButtons ()
    {
        return header_buttons;
    }
    public ArrayList<JButton> getPlayerButtons ()
    {
        return passenger_buttons;
    }
    public ArrayList<String> returnValue () {
        return fieldValues;
    }
    public void verify(){
    }
}
