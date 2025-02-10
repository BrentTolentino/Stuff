package CAR;

public class Car {
    int id;
    static int ID;
    Car(){
        id = ++ID;
    }

    @Override
    public String toString() {
        return id + "";
    }
}
