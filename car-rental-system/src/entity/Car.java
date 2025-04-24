package entity;

public class Car {
    private final String plateNumber;
    private final String companyName;
    private final String model;
    private CarStatus carStatus;
    private double rentalPricePerHour;

    public Car(String plateNumber, String companyName, String model, double rentalPricePerHour) {
        this.plateNumber = plateNumber;
        this.companyName = companyName;
        this.model = model;
        this.rentalPricePerHour = rentalPricePerHour;
        this.carStatus = CarStatus.AVAILABLE;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getModel() {
        return model;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public double getRentalPricePerHour() {
        return rentalPricePerHour;
    }

    public void setRentalPricePerHour(double rentalPricePerHour) {
        this.rentalPricePerHour = rentalPricePerHour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                ", model='" + model + '\'' +
                ", carStatus=" + carStatus +
                ", rentalPricePerHour=" + rentalPricePerHour +
                '}';
    }
}
