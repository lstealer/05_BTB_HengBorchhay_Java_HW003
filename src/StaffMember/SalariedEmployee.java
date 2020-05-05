package StaffMember;

public class SalariedEmployee extends StaffMember{
    private double salary;
    private double bonus;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public SalariedEmployee(int id, String name, String address, double salary, double bonus) {
        super(id, name, address);
        this.salary = salary;
        this.bonus = bonus;
    }
    public double pay(){
        return salary+bonus;
    }

    public String toString()
    {
        return
                super.toString()+
                        "\nSalary : "+this.salary+
                        "\nBonus : "+this.bonus+
                        "\nPayment : "+pay()+
                "\n-----------------------------------------------------";
    }
}
