package Model;
import java.util.ArrayList;
public class Train implements TrainDesc{
    /* Train attributes */
    private int train_id;
    private String train_name;
    private String train_depart;
    private String train_arrival;
    private String train_coach;
    ArrayList<String> train_objectives;
    ArrayList<String> train_outcomes;

    public Train(int train_id, String train_name, String train_depart, String train_arrival, String train_coach) {
        setTrain_id(train_id);
        setTrain_name(train_name);
        setTrain_depart(train_depart);
        setTrain_arrival(train_arrival);
        setTrain_coach(train_coach);
    }

    public void setTrain_id(int train_id) { this.train_id = train_id; }
    public void setTrain_name(String train_name)
    {
        this.train_name = train_name;
    }
    public void setTrain_depart(String train_depart)
    {
        this.train_depart = train_depart;
    }
    public void setTrain_arrival(String train_arrival)
    {
        this.train_arrival = train_arrival;
    }
    public void setTrain_coach(String train_coach)
    {
        this.train_coach = train_coach;
    }
    public int getTrain_id()
    {
        return this.train_id;
    }
    public String getTrain_name()
    {
        return this.train_name;
    }
    public String getTrain_depart()
    {
        return this.train_depart;
    }
    public String getTrain_arrival()
    {
        return this.train_arrival;
    }
    public String getTrain_coach()
    {
        return this.train_coach;
    }
    public void display(){
        System.out.println("Train Id: "+this.getTrain_id()+" ,Train Name :"+this.getTrain_name()+" ,Departure :"+this.getTrain_depart()+" ,Arrival :"+this.getTrain_arrival()+" ,Coach :"+this.getTrain_coach());
    }
    @Override
    public void addTrainObjectives(String objective) {
        this.train_objectives.add(objective);
    }
    @Override
    public void removeTrainObjectives(int objective_no) {
        this.train_objectives.remove(objective_no);
    }
    @Override
    public void displayTrainObjectives() {
        for (int i = 0; i < train_objectives.size(); i++) {
            System.out.println("Train Objective "+i+" : "+train_objectives.get(i));
        }
    }
    @Override
    public void addTrainOutcomes(String outcome) {
        this.train_outcomes.add(outcome);
    }
    @Override
    public void removeTrainOutcomes(int outcome_no) {
        this.train_outcomes.remove(outcome_no);
    }
    @Override
    public void displayTrainOutcomes() {
        for (int i = 0; i < train_outcomes.size(); i++) {
            System.out.println("Train Outcomes "+i+" : "+train_outcomes.get(i));
        }
    }
}
