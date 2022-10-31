package Opgave3;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car("NB58842",1998);
        Car car2 = new Car("AB83245",1992);
        Car car3 = new Car("AL57754",1991);
        Car car4 = new Car("KL12684",2017);
        Car car5 = new Car("IK65191",2014);

        Rental rental1 = new Rental(1,"01/01 2022",30);
        Rental rental2 = new Rental(2,"03/05 2022",90);

        rental1.addCar(car1);
        rental1.addCar(car3);
        rental1.addCar(car4);
        rental2.addCar(car2);
        rental2.addCar(car5);
        car1.setPricePerDay(10.0);

        System.out.println("Info for udlejning 1");
        for (Car car : rental1.getCars()) {
            System.out.println("Nummerplade nr: " + car.getLicense());
        }
        System.out.println("Info for udlejning 2");
        for (Car car : rental2.getCars()) {
            System.out.println("Nummerplade nr: " + car.getLicense());
        }

        System.out.println(rental1.getPrice());
        System.out.println(rental2.getPrice());
    }
}
