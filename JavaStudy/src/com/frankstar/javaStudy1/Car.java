/**
 * 
 */
package com.frankstar.javaStudy1;

/**
 * @author frankstar
 *
 */
public class Car {
	private String brand;
	private String color;
	private int maxSpeed;
	
	public Car() {}
	
	public Car(String brand, String color, int maxSpeed) {
		this.setBrand(brand);
		this.setColor(color);
		this.setMaxSpeed(maxSpeed);
	}
	
	public void introduce() {
		System.out.println("brand:" + getBrand() + ";color:" + getColor() + ";maxSpeed:" + getMaxSpeed());
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.setBrand("兰博基尼");
		System.out.println(car.getBrand());
		
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
