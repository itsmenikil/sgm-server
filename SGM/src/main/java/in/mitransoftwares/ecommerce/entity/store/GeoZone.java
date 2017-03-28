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
@Table(name="geo_zone",uniqueConstraints={@UniqueConstraint(columnNames="name")})
public class GeoZone {

	GeoZone() {}
	
	private Long geoZoneId;
	private String name;
	private String description;
	private Date dateModified;
	private Date dateCreated;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geo_zone_id",nullable = false)
	public Long getGeoZoneId() {
		return geoZoneId;
	}
	public void setGeoZoneId(Long geoZoneId) {
		this.geoZoneId = geoZoneId;
	}
	@Column(name = "name",nullable = false,length=32)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "description",nullable = false,length=255)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified",columnDefinition="timestamp")
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
