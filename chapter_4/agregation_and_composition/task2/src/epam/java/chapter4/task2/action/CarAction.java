package epam.java.chapter4.task2.action;

import epam.java.chapter4.task2.entity.Car;
import epam.java.chapter4.task2.entity.Wheel;

public class CarAction {
    public CarAction(){

    }

    public StringBuilder drive(double distance, Car car){
        StringBuilder stringBuilder = new StringBuilder();

        double tempFuelVolume = distance * (car.getEngine().getFuelConsumption() / 100);

        if (tempFuelVolume > car.getCurrTankVolume()){
            double tempDistance;

            tempDistance = car.getCurrTankVolume() /  (car.getEngine().getFuelConsumption() / 100);

            car.setMileage(car.getMileage() + tempDistance);

            car.setCurrTankVolume(0);

            stringBuilder.append("Машина проехала ").append(tempDistance).append(" из ").append(distance).append(" km.\n");
            stringBuilder.append("Количество оставшегося топлива ").append(car.getCurrTankVolume()).append(" l.");

        }else{
            car.setCurrTankVolume(car.getCurrTankVolume() - tempFuelVolume);
            car.setMileage(car.getMileage() + distance);

            stringBuilder.append("Машина проехала ").append(distance).append(" из ").append(distance).append(" km.\n");
            stringBuilder.append("Количество оставшегося топлива ").append(car.getCurrTankVolume()).append(" l.");

        }

        return stringBuilder;
    }

    public void fillTheCar(double volume, Car car){
        double currVolume;

        currVolume = car.getCurrTankVolume();

        if (currVolume + volume >= car.getMaxTankVolume()){
            car.setCurrTankVolume(car.getMaxTankVolume());
        }else{
            car.setCurrTankVolume(currVolume + volume);
        }
    }

    public void changeWheels(Wheel[] newWheels, Car car){
        car.setWheels(newWheels);
    }

    public StringBuilder getManufacturerAndModel(Car car){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(car.getEngine().getManufacturerBrand()).append(" ");
        stringBuilder.append(car.getModel());

        return stringBuilder;
    }
}
