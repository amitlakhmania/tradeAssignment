package com.trades.application.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Range;

@Entity
public class Trade{
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name ="version")
    @Range(min = 1 )
    private int version;
    @Column(name ="counter_party_id")
    private String counterPartyId;
    @Column(name ="book_id")
    private String bookId;
    @Column(name ="MATURITY_DATE")
    @FutureOrPresent
    @NotNull(message = "Maturity Date is mandatory in format YYYY-MM-DD")
    private Date maturityDate;
    @CreationTimestamp
    @Column(name="CREATED_DATE")
    private Date createdDate;
    @Column(name="expired")
    @NotEmpty(message = "Expired is Mandatory")
    private String expired;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Trade(long id, int version, String counterPartyId, String bookId, Date maturityDate, Date createdDate,
			String expired) {
		super();
		this.id = id;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}
	
	public Trade() {
		
	}
    

}