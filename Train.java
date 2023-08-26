package Model;

import java.util.ArrayList;
import java.util.Date;

public class Train implements TrainDesc {
    /* Train attributes */
    private int train_id;
    private String train_name;
    private String departure;
    private String arrival;
    private String coach;

    ArrayList<String> train_objectives;
    ArrayList<String> train_outcomes;

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getTrain_id() {
        return this.train_id;
    }

    public String getTrain_name() {
        return this.train_name;
    }

    public String getDeparture() {
        return this.departure;
    }

    public String getArrival() {
        return this.arrival;
    }

    public String getCoach() {
        return this.coach;
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
            System.out.println("Train Objective " + i + " : " + train_objectives.get(i));
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
            System.out.println("Train Outcomes " + i + " : " + train_outcomes.get(i));
        }
    }
}
