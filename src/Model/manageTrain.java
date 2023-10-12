package Model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class manageTrain {
    ArrayList<Train> trains = new ArrayList<Train>();
    private Object String;

    public ArrayList<Train> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }
    public ArrayList<Train> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File("src/Model/train.json"));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int trainId = node.get("trainId").asInt();
                    String trainName = node.get("trainName").asText();
                    String trainDepart = node.get("trainDepart").asText();
                    String trainArrival = node.get("trainArrival").asText();
                    String trainCoach = node.get("trainCoach").asText();
                    Train temp_train = new Train(trainId,trainName,trainDepart,trainArrival,trainCoach);
                    temp_train.setTrainId(trainId);
                    temp_train.setTrainName(trainName);
                    temp_train.setTrainDepart(trainDepart);
                    temp_train.setTrainArrial(trainArrival);
                    temp_train.setTrainCoach(trainCoach);
                    trains.add(temp_train);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trains;
    }
}
