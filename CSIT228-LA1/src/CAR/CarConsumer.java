package CAR;

import java.util.List;

public class CarConsumer implements Runnable{
    final List<Car> carList;
    int id;
    static int ID;
    public CarConsumer(List<Car> carList) {
        this.carList = carList;
        id = ++ID;
    }

    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(6000);
            } catch(InterruptedException e){}
            synchronized (carList){
                while(carList.isEmpty()){
                    try{
                        carList.wait();
                    } catch(InterruptedException e){
                    }
                }
                Car car = carList.get(0);
                carList.remove(car);
                System.out.println(id + " Claimed car " + car + " - " + carList.size() + " left");
            }
        }
    }
}
