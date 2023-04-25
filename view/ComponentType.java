package view;


import java.util.Arrays;

public enum ComponentType {
    MENU(0, " - menu"),
    HISTORY(1, " - Information about using the program"),
    CALCULATE(2, " - Calculate the new value!"),
    RECENTCALCULATIONS(3, " - Output the previous value"),
    ALLCALCULATIONS(4, " - Output the entire list of values"),
    DELETEHISTORY(5,"- Delete Calculator History");
   /* SINGLE_EMPLOY(6,"- Exit the program");*/



    private final int type;
    private final String comment;

    ComponentType(int type, String comment) {
        this.type = type;
        this.comment = comment;
    }

    public int getType() {
        return type;
    }

    public String getComment() {
        return comment;
    }

    public static ComponentType fromType(int type) {
        return Arrays.stream(values())
                .filter(v -> v.type == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No component with type: " + type));
    }
}
