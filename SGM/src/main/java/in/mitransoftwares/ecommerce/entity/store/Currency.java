package in.mitransoftwares.ecommerce.entity.store;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="currency",uniqueConstraints={@UniqueConstraint(columnNames="title"),
		@UniqueConstraint(columnNames="code")})
public class Currency {

	Currency() {}
	
	private Long currencyId;
	private String title;
	private String code;
	private String symbolLeft;
	private String symbolRight;
	private String decimalPlace;
	private double value;
	private boolean status;
	private Date dateModified;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id",nullable = false)
	public Long getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}
	@Column(name="title",nullable=false,length=32)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="code",nullable=false,length=3)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="symbol_left",nullable=false,length=12)
	public String getSymbolLeft() {
		return symbolLeft;
	}
	public void setSymbolLeft(String symbolLeft) {
		this.symbolLeft = symbolLeft;
	}
	@Column(name="symbol_right",nullable=false,length=12)
	public String getSymbolRight() {
		return symbolRight;
	}
	public void setSymbolRight(String symbolRight) {
		this.symbolRight = symbolRight;
	}
	@Column(name="decimal_place",nullable=false,length=4)
	public String getDecimalPlace() {
		return decimalPlace;
	}
	public void setDecimalPlace(String decimalPlace) {
		this.decimalPlace = decimalPlace;
	}
	@Column(name="value",nullable=false)
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Column(name="status",nullable=false)
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified",columnDefinition="timestamp")
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
	
}
