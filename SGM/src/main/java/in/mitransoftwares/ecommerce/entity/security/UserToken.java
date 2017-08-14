package in.mitransoftwares.ecommerce.entity.security;

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

import in.mitransoftwares.ecommerce.entity.usermodule.User;

@Entity
@Table(name="user_token")
public class UserToken {

	private Long userTokenId;
	private String accessToken;
	private String ipAddress;
	private Long status;
	private Date createdDate;
	private User user;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_token_id",nullable = false)
	public Long getUserTokenId() {
		return userTokenId;
	}
	public void setUserTokenId(Long userTokenId) {
		this.userTokenId = userTokenId;
	}
	@Column(name = "access_token",nullable = false)
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	@Column(name = "ip_address",nullable = false)
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	@Column(name = "status",nullable = false)
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
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
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable =false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
