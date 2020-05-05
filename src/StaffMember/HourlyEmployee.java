package StaffMember;

public class HourlyEmployee extends StaffMember {
    private int hoursWorked;
    private double rate;
    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public HourlyEmployee(int id, String name, String address, int hoursWorked, double rate) {
        super(id, name, address);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    @Override
    public double pay() {
        return rate*hoursWorked;
    }
    public String toString(){
        return super.toString()+
                "\nHours Worked : "+this.hoursWorked+
                "\nRate : "+this.rate+
                "\nPayments : "+pay()+
                "\n----------------------------------------------------";
    }
}
