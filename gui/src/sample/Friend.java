package sample;

public class Friend {
    public String name;
    public String gender;
    private int age;

    //Getter
    public int getAge() {
        return age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    private long phoneNumber;

    //Requires: Parameters meet req
    //Modifies: this
    //Effects: Builds friend object with given parameters
    Friend(String n, String gender, int age, long phone){
        name = n;
        this.gender = gender;
        this.age = age;
        phoneNumber = phone;
    }

    //Requires: nothing
    //Modifies: this
    //Effects: Prints name when object is printed
    public String toString(){
        return name;
    }

}
