package in.mitransoftwares.ecommerce.entity.store;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="zone_and_geo_zone",uniqueConstraints={@UniqueConstraint(columnNames={"country_id","zone_id","geo_zone_id"})})
public class ZoneAndGeoZone {
   
	ZoneAndGeoZone() {}
	
	private Long zoneAndGeoZoneId;
	private Country country;
	private Zone zone;
	private GeoZone geoZone;
	private Date dateCreated;
	private Date dateModified;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_and_geo_zone_id",nullable = false)
	public Long getZoneAndGeoZoneId() {
		return zoneAndGeoZoneId;
	}
	public void setZoneAndGeoZoneId(Long zoneAndGeoZoneId) {
		this.zoneAndGeoZoneId = zoneAndGeoZoneId;
	}
	@ManyToOne
	@JoinColumn(name = "country_id", nullable =false)
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@ManyToOne
	@JoinColumn(name = "zone_id", nullable =false)
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	@ManyToOne
	@JoinColumn(name = "geo_zone_id", nullable =false)
	public GeoZone getGeoZone() {
		return geoZone;
	}
	public void setGeoZone(GeoZone geoZone) {
		this.geoZone = geoZone;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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
