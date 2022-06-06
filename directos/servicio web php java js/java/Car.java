package ut5web;

public class Car {

	private int idCar;
	private String model;
	private int horsePower;
	private int maxSpeed;
	private int doors;
	private int price;
	public Car(int idCar, String model, int horsePower, int maxSpeed, int doors, int price) {
	this.idCar = idCar;
	this.model = model;
	this.horsePower = horsePower;
	this.maxSpeed = maxSpeed;
	this.doors = doors;
	this.price = price;
	}
	
	public Car() {
	}
	
	public int getIdCar() {
		return idCar;
	}
	
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getHorsePower() {
		return horsePower;
	}
	
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public int getDoors() {
		return doors;
	}
	
	public void setDoors(int doors) {
		this.doors = doors;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		StringBuffer sCar = new StringBuffer();
		sCar.append("idCar:");
		sCar.append(idCar);
		sCar.append("; modelo:");
		sCar.append(model);
		sCar.append("; potencia:");
		sCar.append(horsePower);
		sCar.append("; velocidad maxima:");
		sCar.append(maxSpeed);
		sCar.append("; numero de puertas:");
		sCar.append(doors);
		sCar.append("; precio:");
		sCar.append(price);
		return sCar.toString();
	}

}
