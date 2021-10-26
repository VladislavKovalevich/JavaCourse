package epam.java.chapter4.task2;


import epam.java.chapter4.task2.action.CarAction;
import epam.java.chapter4.task2.entity.Car;
import epam.java.chapter4.task2.entity.Engine;
import epam.java.chapter4.task2.entity.Wheel;

/**
 *  Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("Mercedes","V12", 800, 10.5, 3000);
        Wheel[] wheels = new Wheel[]{
                new Wheel(20.3, 16.5, "Michelin"),
                new Wheel(20.3, 16.5, "Michelin"),
                new Wheel(20.3, 16.5, "Michelin"),
                new Wheel(20.3, 16.5, "Michelin"),
        };

        Car car = new Car("Benz CLK", engine, wheels, 40.0, 70.0);

        CarAction carAction = new CarAction();

        System.out.println(carAction.getManufacturerAndModel(car));

        carAction.fillTheCar(80, car);

        System.out.println(car.getCurrTankVolume());

        System.out.println(carAction.drive(523.4, car));
        System.out.println(carAction.drive(523.4, car));

        Wheel[] newWheels = new Wheel[]{
                new Wheel(20.9, 15.5, "Bridgestone"),
                new Wheel(20.9, 15.5, "Bridgestone"),
                new Wheel(20.9, 15.5, "Bridgestone"),
                new Wheel(20.9, 15.5, "Bridgestone"),
        };

        carAction.changeWheels(newWheels, car);

    }
}
