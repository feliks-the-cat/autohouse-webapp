package com.autohouse.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="cars")
public class Car_VouchakIM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAR_ID")
	private Integer carId;

	@Column(name="CAR_BRAND")
	private String carBrand;

	@Column(name="CAR_CAPACITY")
	private String carCapacity; 

	@Column(name="CAR_IS_SOLD")
	private String carIsSold;

	@Column(name="CAR_MILEAGE")
	private int carMileage;

	@Column(name="CAR_MODEL")
	private String carModel;

	@Column(name="CAR_PRICE")
	private int carPrice;

	@Column(name="CAR_VIN")
	private String carVin;

	@Column(name="CAR_YEAR")
	private String carYear;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "CAR_BODY_ID")
	@NotFound(action=NotFoundAction.IGNORE)
	private Body_VouchakIM body;

    public Car_VouchakIM() {
    }

	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarBrand() {
		return this.carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarCapacity() {
		return this.carCapacity;
	}

	public void setCarCapacity(String carCapacity) {
		this.carCapacity = carCapacity;
	}

	public int getCarMileage() {
		return this.carMileage;
	}

	public void setCarMileage(int carMileage) {
		this.carMileage = carMileage;
	}

	public String getCarModel() {
		return this.carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarPrice() {
		return this.carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarVin() {
		return this.carVin;
	}

	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}

	public String getCarYear() {
		return this.carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public Body_VouchakIM getBody() {
		return body;
	}

	public void setBody(Body_VouchakIM body) {
		this.body = body;
	}

	public String getCarIsSold() {
		return carIsSold;
	}

	public void setCarIsSold(String carIsSold) {
		this.carIsSold = carIsSold;
	}
}