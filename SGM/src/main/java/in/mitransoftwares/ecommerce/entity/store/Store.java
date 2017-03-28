package in.mitransoftwares.ecommerce.entity.store;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import in.mitransoftwares.ecommerce.entity.customer.Customer;

@Entity
@Table(name="store",uniqueConstraints={@UniqueConstraint(columnNames="store_name")})
public class Store {

	
	private Long storeId;
	private String storeName;
	private String storeUrl;
	private String storeLogoPath;
	
	private Set<Customer> customers;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id",nullable = false)
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	@Column(name = "store_name",length=100)
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	@Column(name = "store_url",length=100)
	public String getStoreUrl() {
		return storeUrl;
	}
	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}
	@Column(name = "store_logo_path",length=255)
	public String getStoreLogoPath() {
		return storeLogoPath;
	}
	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
}
