package service;

import entity.Car;
import entity.CarStatus;
import repository.InMemoryRepository;

import java.util.Map;

public class CarService {

    private Map<String, Car>carMap;
    public CarService(InMemoryRepository inMemoryRepository){
        carMap = inMemoryRepository.getCarMap();
    }
    public void addCar(Car car){
        carMap.put(car.getPlateNumber(), car);
        System.out.println(car.getPlateNumber()+" added successfully");
    }
    public void removeCar(String carPlateNumber){
        if(carMap.containsKey(carPlateNumber)){
            carMap.remove(carPlateNumber);
            System.out.println(carPlateNumber +" has remove successfully!!");
        }else{
            System.out.println(carPlateNumber+" not present!!");
        }
    }
    public void updateCarStatus(String carPlateNumber, CarStatus newStatus){
        if(carMap.containsKey(carPlateNumber)){
            Car car = carMap.get(carPlateNumber);
            car.setCarStatus(newStatus);
            System.out.println(carPlateNumber +" has remove successfully!!");
        }else{
            System.out.println(carPlateNumber+" not present!!");
        }
    }
}
