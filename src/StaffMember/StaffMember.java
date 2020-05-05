package StaffMember;

import java.util.Comparator;

public abstract class StaffMember {
    protected int id;
    protected String name;
    protected String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StaffMember(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public abstract double pay();


    public static Comparator<StaffMember> idComparator = new Comparator<StaffMember>() {
        @Override
        public int compare(StaffMember jc1, StaffMember jc2) {
            return (jc2.getId() < jc1.getId() ? 1 :
                    (jc2.getId() == jc1.getId() ? 0 : -1));
        }
    };
    public static Comparator<StaffMember> nameComparator = new Comparator<StaffMember>() {
        @Override
        public int compare(StaffMember jc1, StaffMember jc2) {
            return (int) (jc1.getName().compareTo(jc2.getName()));
        }
    };

    @Override
    public String toString() {
        return  "ID : "+id +
                "\nName : " + name +
                "\nAddress : "+ address+";";
    }
}
