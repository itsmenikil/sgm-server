package in.mitransoftwares.ecommerce.entity.usermodule;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import in.mitransoftwares.ecommerce.entity.security.UserToken;


@Entity
@Table(name = "user",uniqueConstraints={@UniqueConstraint(columnNames="user_name"),@UniqueConstraint(columnNames="email")})
public class User {

	
	public User(){}
	
	
	private Long userId;	
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String status;
	private Date createdDate;
	private Date lastLogin;
	
	private Set<UserRole> userRoles;
	private Set<UserToken> userTokens;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name = "user_name",length=100)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "password",length=255)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "email",length=100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "first_name",length=100)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "last_name",length=100)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "status",length=100)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login")
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_role_mapping",joinColumns = { 
			@JoinColumn(name = "user_id", updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_role_id", 
					 updatable = true) })
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_tokens_mapping",joinColumns = { 
			@JoinColumn(name = "user_id", updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_token_id", 
					 updatable = true) })
	public Set<UserToken> getUserTokens() {
		return userTokens;
	}
	public void setUserTokens(Set<UserToken> userTokens) {
		this.userTokens = userTokens;
	}
	
	
}
