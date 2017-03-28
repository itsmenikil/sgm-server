package in.mitransoftwares.ecommerce.entity.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="country",uniqueConstraints={@UniqueConstraint(columnNames="iso_code_2"),
		@UniqueConstraint(columnNames="iso_code_3"),@UniqueConstraint(columnNames="name")})
public class Country {

	Country() {}
	
	private Long countryId;
	private String Name;
	private String isoCodeTwo;
	private String isoCodeThree;
	private String addressFormat;
	private boolean postcodeRequired;
	private boolean status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id",nullable = false)
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	@Column(name="name",nullable=false,length=128)
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Column(name="iso_code_2",nullable=false,length=2)
	public String getIsoCodeTwo() {
		return isoCodeTwo;
	}
	public void setIsoCodeTwo(String isoCodeTwo) {
		this.isoCodeTwo = isoCodeTwo;
	}
	@Column(name="iso_code_3",nullable=false,length=3)
	public String getIsoCodeThree() {
		return isoCodeThree;
	}
	public void setIsoCodeThree(String isoCodeThree) {
		this.isoCodeThree = isoCodeThree;
	}
	@Column(name="address_format",nullable=false,length=255)
	public String getAddressFormat() {
		return addressFormat;
	}
	public void setAddressFormat(String addressFormat) {
		this.addressFormat = addressFormat;
	}
	@Column(name="postcode_required",nullable=false)
	public boolean isPostcodeRequired() {
		return postcodeRequired;
	}
	public void setPostcodeRequired(boolean postcodeRequired) {
		this.postcodeRequired = postcodeRequired;
	}
	@Column(name="status",nullable=false)
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
