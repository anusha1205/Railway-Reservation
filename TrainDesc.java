package Model;
public interface TrainDesc {
    void addTrainObjectives(String objective);
    void removeTrainObjectives(int objective_no);
    void displayTrainObjectives();
    void addTrainOutcomes(String outcome);
    void removeTrainOutcomes(int outcome_no);
    void displayTrainOutcomes();
}