package StaffMember;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI {
    //Variable
    Scanner scanner = new Scanner(System.in);
    ArrayList<StaffMember> storer = new ArrayList<StaffMember>();
    Matcher matcher;
    String letterPattern = "([A-Za-z]+[ ][A-Za-z]+|[A-Za-z]+)";
    String numPattern = "[0-9]+";
    String addressPattern = "([A-Za-z0-9]+|[A-Za-z]+[ ][0-9]+|(null))";
    DecimalFormat df=new DecimalFormat("#.##");

    //UI
    public void header(String title) {
        System.out.println("=======================" + title + "========================");
    }

    public int menuSelect(int min, int max, String request, String... text) {
        header("StaffMember Homework3");
        int order = 1;
        for (String t : text) {
            System.out.println(order + ", " + t);
            order++;
        }
        return intValidator(min, max, request);
    }

    public void menuOption(int option) {
        switch (option) {
            case 1:
                insertEmployee();
                break;
            case 2:
                displayEmployee(intValidator(1,
                        2,
                        "Select Display mode\n1,Sort By ID\n2,Sort By Name"));
                holder();
                break;
            case 3:
                updateEmployee();
                break;
            case 4:
                removeEmployee();
                break;
            case 5:
                exit();
        }
    }
    public void holder() {
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertOption(int option) {
        switch (option) {
            case 1:
                insertVolunteer();
                break;
            case 2:
                insertSalaryEmployee();
                break;
            case 3:
                insertHourEmployee();
                break;
            case 4:
                menuOption(
                        menuSelect(1,
                                5,
                                "select feature",
                                "Insert Employee",
                                "Display Employee",
                                "Update Employee",
                                "Remove Employee",
                                "Exit")
                );
                break;
        }
    }
    public void updateOption(int option,int index){
        switch (option){
            case 1:
                updateHourlyEmployee(intValidator(1,
                        5,
                        "\n1,Name\n2,Address\n3,Hours Worked\n4,Rate\n5,Exit"),index); ;
                break;
            case 2:
                updateSalariesEmployee(intValidator(1,
                        5,
                        "\n1,Name\n2,Address\n3,Salary\n4,Bonus\n5,Exit"),index);
                break;
            case 3:
                updateVolunteer(intValidator(1,
                        3,
                        "\n1,Name\n2,Address\n3,Exit"),index);
                break;
        }
    }

    //Core
    public void updateHourlyEmployee(int option,int index){
        switch (option){
            case 1:
                storer.get(index).setName(regexInput(letterPattern,"Please Input new Name:"));
                System.out.println("Successfully update information");
                break;
            case 2:
                storer.get(index).setAddress(addressSetter(
                        "Please Input Your Sangkhat :",
                        "Please Input Your Khan :",
                        "Please Input Street Number :",
                        "Please Input House Number :"
                ));
                System.out.println("Successfully update information");
                break;
            case 3:
                ((HourlyEmployee)storer.get(index)).
                        setHoursWorked(
                                intValidator(
                                "Please input new work hours"
                                ));
                System.out.println("Successfully update information");
                break ;
            case 4:
                ((HourlyEmployee)storer.get(index))
                        .setRate(
                                doubleValidator(
                                        "Please Input New Rate:"
                                ));
                System.out.println("Successfully update information");
                break ;
            case 5:
                menuOption(
                        menuSelect(1,
                                5,
                                "select feature",
                                "Insert Employee",
                                "Display Employee",
                                "Update Employee",
                                "Remove Employee",
                                "Exit")
                );
                break;
        }
    }
    public void updateSalariesEmployee(int option,int index){
        switch (option){
            case 1:
                storer.get(index).setName(regexInput(letterPattern,"Please Input new Name:"));
                System.out.println("Successfully update information");
                break;
            case 2:
                storer.get(index).setAddress(addressSetter(
                        "Please Input Your Sangkhat :",
                        "Please Input Your Khan :",
                        "Please Input Street Number :",
                        "Please Input House Number :"
                ));
                System.out.println("Successfully update information");
                break;
            case 3:
                ((SalariedEmployee)storer.get(index)).
                        setSalary(
                                doubleValidator(
                                        "Please input new Salary:"
                                ));
                System.out.println("Successfully update information");
                break ;
            case 4:
                ((SalariedEmployee)storer.get(index))
                        .setBonus(
                                doubleValidator(
                                        "Please Input New Bonus:"
                                ));
                System.out.println("Successfully update information");
                break ;
            case 5:
                menuOption(
                        menuSelect(1,
                                5,
                                "select feature",
                                "Insert Employee",
                                "Display Employee",
                                "Update Employee",
                                "Remove Employee",
                                "Exit")
                );
                break;
        }
    }
    public void updateVolunteer(int option,int index){
        switch (option){
            case 1:
                storer.get(index).setName(regexInput(letterPattern,"Please Input new Name:"));
                System.out.println("Successfully update information");
                break;
            case 2:
                storer.get(index).setAddress(addressSetter(
                        "Please Input Your Sangkhat :",
                        "Please Input Your Khan :",
                        "Please Input Street Number :",
                        "Please Input House Number :"
                ));
                System.out.println("Successfully update information");
                break;
            case 3:
                menuOption(
                        menuSelect(1,
                                5,
                                "select feature",
                                "Insert Employee",
                                "Display Employee",
                                "Update Employee",
                                "Remove Employee",
                                "Exit")
                );
                break;
        }
    }
    public int getSize() {
        return storer.size() + 1;
    }

    public String regexInput(String regex, String request) {
        System.out.println("=>" + request);
        Pattern pattern = Pattern.compile(regex);
        String letter;
        do {
            letter = scanner.nextLine();
            matcher = pattern.matcher(letter);
        } while (!matcher.matches());
        return letter.substring(0,1).toUpperCase()+letter.substring(1);
    }

    public int intValidator(int min, int max, String request) {
        System.out.println("=> " + request + " Between " + min + " and " + max + ":");
        while (!scanner.hasNextInt()) scanner.next();
        int input = scanner.nextInt();
        return input < min ?
                intValidator(min, max, request) : input > max ?
                intValidator(min, max, request) : input;
    }

    public double doubleValidator(String request) {
        System.out.println("=>" + request);
        while (!scanner.hasNextDouble()) scanner.next();
        double input = scanner.nextDouble();
        return input;
    }

    public int intValidator(String request) {
        System.out.println("=>" + request);
        while (!scanner.hasNextInt()) scanner.next();
        int input = scanner.nextInt();
        return input;
    }

    //option process
    public void insertEmployee() {
        insertOption(
                menuSelect(
                        1,
                        3,
                        "Select type of Employee ",
                        "Volunteer",
                        "Salary Employee",
                        "Hourly Employee"
                )
        );

    }

    public boolean confirmation(String request) {
        System.out.println(request);
        int input = intValidator(1, 2, "1,Yes\n2,No");
        if (input == 1)
            return true;
        else return false;
    }

    public void displayEmployee(int option) {
        if(option==2)Collections.sort(storer,StaffMember.nameComparator);
        for (StaffMember show : storer) System.out.println(show.toString());
        Collections.sort(storer,StaffMember.idComparator);
    }

    public void updateEmployee() {
        if(getSize()==1){
            System.out.println("Have no record yet!!!");
            return;
        }
        int index=intValidator(1, storer.size(), "Input ID to Update :")-1;
        updateOption(checkClass(storer.get(index).getClass().getName()),index);
    }

    public int checkClass(String className){
        if(className.equals("StaffMember.HourlyEmployee"))
        return 1;
        else if(className.equals("StaffMember.SalariedEmployee"))
            return 2;
        else return 3;
    }

    public void removeEmployee() {
        if(getSize()==1){
            System.out.println("Have no record yet!!!");
            return;
        }
        int index = intValidator(1, storer.size(), "Input ID to Remove :");
        if (confirmation("Are You Sure to Delete the Record?")) {
            storer.remove(index-1);
            System.out.println("The Record is Successfully removed");
        }
    }

    public void exit() {
        System.exit(0);
    }

    public String addressSetter(String... request) {
        String address = "";
        for (String text : request) address += regexInput(addressPattern, text);
        return address;
    }

    public void insertVolunteer() {
        String name = regexInput(letterPattern, "Please input your name with pure letter:");
        String address = addressSetter(
                "Please Input Your Sangkhat :",
                "Please Input Your Khan :",
                "Please Input Street Number :",
                "Please Input House Number :"
        );
        storer.add(new Volunteer(getSize(), name, address));
    }

    public void insertSalaryEmployee() {
        String name = regexInput(letterPattern, "Please input your name with pure letter:");
        String address = addressSetter(
                "Please Input Your Sangkhat :",
                "Please Input Your Khan :",
                "Please Input Street Number :",
                "Please Input House Number :"
        );
        double salary = doubleValidator("Input Salary :");
        double bonus = doubleValidator("Input Bonus :");
        storer.add(new SalariedEmployee(getSize(), name, address, salary, bonus));
    }

    public void insertHourEmployee() {
        String name = regexInput(letterPattern, "Please input your name with pure letter:");
        String address = addressSetter(
                "Please Input Your Sangkhat :",
                "Please Input Your Khan :",
                "Please Input Street Number :",
                "Please Input House Number :"
        );
        int hour = intValidator("Input Worked Hours :");
        double rate = doubleValidator("Input Rate :");
        storer.add(new HourlyEmployee(getSize(), name, address, hour, rate));
    }

}
