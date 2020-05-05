package StaffMember;

public class Volunteer extends StaffMember{
    public Volunteer(int id,String name,String address){
        super(id,name,address);
    }

    public double pay(){
        return 0;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nThank!\n---------------------------------------------------";
    }
}
