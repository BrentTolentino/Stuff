package CAR;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many producers? ");
        int n = sc.nextInt();

        System.out.println("How many consumers? ");
        int m = sc.nextInt();

        List<Thread> threads = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < n; i++){
            threads.add(new Thread(new CarProducer(cars)));
        }

        for(int i = 0; i < m; i++){
            threads.add(new Thread(new CarConsumer(cars)));
        }

        for(Thread t : threads){
            t.start();
        }
    }
}
