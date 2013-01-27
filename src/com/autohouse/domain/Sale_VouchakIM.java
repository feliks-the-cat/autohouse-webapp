package com.autohouse.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="sales")
public class Sale_VouchakIM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SALE_ID")
	private int saleId;

	@Column(name="SALE_DATE")
	private String saleDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="SALE_CAR_ID")
	private Car_VouchakIM car;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="SALE_CUSTOMER_ID")
	private Customer_VouchakIM customer;
    
    @Column(name="SALE_PLACE")
    private String salePlace;

    public Sale_VouchakIM() {
    }

	public int getSaleId() {
		return this.saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public Car_VouchakIM getCar() {
		return this.car;
	}

	public void setCar(Car_VouchakIM car) {
		this.car = car;
	}
	
	public Customer_VouchakIM getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer_VouchakIM customer) {
		this.customer = customer;
	}

	public String getSalePlace() {
		return salePlace;
	}

	public void setSalePlace(String salePlace) {
		this.salePlace = salePlace;
	}
}