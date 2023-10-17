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
                    int train_id = node.get("train_id").asInt();
                    String train_name = node.get("train_name").asText();
                    String train_depart = node.get("train_depart").asText();
                    String train_arrival = node.get("train_arrival").asText();
                    String train_coach = node.get("train_coach").asText();
                    Train temp_train = new Train(train_id,train_name,train_depart,train_arrival,train_coach);
                    temp_train.setTrain_id(train_id);
                    temp_train.setTrain_name(train_name);
                    temp_train.setTrain_depart(train_depart);
                    temp_train.setTrain_arrival(train_arrival);
                    temp_train.setTrain_coach(train_coach);
                    trains.add(temp_train);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trains;
    }
}

