package in.mitransoftwares.ecommerce.entity.customer;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import in.mitransoftwares.ecommerce.entity.store.Store;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames="email"),@UniqueConstraint(columnNames="user_name")})
public class Customer {

	public Customer() {}
	
	private Long customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String telephone;
	private String password;
	private boolean newsletter;
	private boolean status;
	private boolean approved;
	private Date customerAdded;
	
	private Set<CustomerAddress> addresses;
	private Store store;
	private CustomerGroup customerGroup;
	private Set<Cart> cartItems;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",nullable = false)
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	@Column(name="first_name",length=100,nullable=false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="last_name",length=100)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="email",length=100,nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="user_name",length=100,nullable=false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="telephone",length=50,nullable=false)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(name="password",length=255,nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="news_letter",nullable=false)
	public boolean isNewsletter() {
		return newsletter;
	}
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
	
	@ManyToOne
	@JoinColumn(name = "store_id", nullable =false)
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	@ManyToOne
	@JoinColumn(name = "customer_group_id", nullable =false)
	public CustomerGroup getCustomerGroup() {
		return customerGroup;
	}
	public void setCustomerGroup(CustomerGroup customerGroup) {
		this.customerGroup = customerGroup;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CustomerAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<CustomerAddress> addresses) {
		this.addresses = addresses;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Cart> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<Cart> cartItems) {
		this.cartItems = cartItems;
	}
	@Column(name="status",nullable=false)
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Column(name="approved",nullable=false)
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "customer_added")
	public Date getCustomerAdded() {
		return customerAdded;
	}
	public void setCustomerAdded(Date customerAdded) {
		this.customerAdded = customerAdded;
	}
	
	
	
	
}
