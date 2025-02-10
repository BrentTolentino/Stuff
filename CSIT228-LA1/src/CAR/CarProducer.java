package CAR;

import java.util.List;

public class CarProducer implements Runnable{
    List<Car> carList;
    int id;
    static int ID;

    public CarProducer(List<Car> carList){
        this.carList = carList;
        id = ++ID;
    }

    @Override
    public void run(){
        while(true){
            synchronized (carList){
                carList.add(new Car());
                System.out.println(id + " Created a car - " + carList.size() + " total");
                carList.notifyAll();
            }
            try{
                Thread.sleep(5000);
            } catch(InterruptedException e){}
        }
    }
}
