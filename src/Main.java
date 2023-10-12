import Controller.Controller;
import Model.*;
import View.View;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
    }
}