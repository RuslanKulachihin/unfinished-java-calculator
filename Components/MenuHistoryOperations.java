package Components;

import view.AbstractComponent;
import view.ComponentType;

import java.io.*;
import java.util.Arrays;

import static Components.MenuHistoryOperations.Controller.ReturnEverything;


public class MenuHistoryOperations extends AbstractComponent<Void> {
    private String result;

    public void setResult(String result) {
        this.result = result;
        Controller.CreationRecording(result);
    }

    public MenuHistoryOperations() {
        super(ComponentType.HISTORY, null);
    }

    public void draw() throws IOException {
        ReturnEverything();
        System.out.println("****** MENU ******");
        Arrays.stream(ComponentType.values())
                .map(v -> v.getType() + " " + v.getComment())
                .forEach(System.out::println);
        System.out.println("9 - Exit\n");
    }

    public class Controller {
        public static void CreationRecording(String result) {
            try {
                File file = new File("calculatorOperations.txt");
                if (!file.exists()) {
                    file.createNewFile();
                    System.out.println("File created");
                }
                PrintWriter Calc = new PrintWriter(file);
                Calc.println(result);
                Calc.close();
            } catch (IOException e) {
                System.err.println("Error" + e);
            }

        }

        public static void ReturnEverything() throws IOException {
            BufferedReader everything = new BufferedReader(new FileReader("calculatorOperations.txt"));
            String line;
            while ((line = everything.readLine()) != null) {
                if (line != null && !line.isEmpty()) {
                    System.out.print("Последние вырожение:\t");
                    System.out.println(line +"\n");
                }
            }
            everything.close();
        }

    }
}
