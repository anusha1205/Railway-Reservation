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
    }

//    public Train(int train_id, String train_name, String train_depart, String train_arrival, String train_coach) {
//    }

    public void setTrainId(int Train_id) { this.train_id = Train_id; }
    public void setTrainName(String train_name)
    {
        this.train_name = train_name;
    }

    public void setTrainDepart(String train_depart)
    {
        this.train_depart = train_depart;
    }

    public void setTrainArrial(String train_arrival)
    {
        this.train_arrival = train_arrival;
    }
    public void setTrainCoach(String train_coach)
    {
        this.train_coach = train_coach;
    }
    public int getTrainId()
    {
        return this.train_id;
    }

    public String getTrainName()
    {
        return this.train_name;
    }

    public String getTrainDepart()
    {
        return this.train_depart;
    }

    public String getTrainArrival()
    {
        return this.train_arrival;
    }
    public String getTrainCoach()
    {
        return this.train_coach;
    }

    public void display()
    {
        System.out.println("Train Id: "+this.getTrainId()+" ,Train Name :"+this.getTrainName()+" ,Departure :"+this.getTrainDepart()+" ,Arrival :"+this.getTrainArrival()+" ,Coach :"+this.getTrainCoach());
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
