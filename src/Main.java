import StaffMember.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        while (true)
        ui.menuOption(
                ui.menuSelect(1,
                        5,
                        "select feature",
                        "Insert Employee",
                        "Display Employee",
                        "Update Employee",
                        "Remove Employee",
                        "Exit")
        );

    }
}
