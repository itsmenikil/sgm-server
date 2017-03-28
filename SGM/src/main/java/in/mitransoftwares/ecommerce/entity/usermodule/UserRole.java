package in.mitransoftwares.ecommerce.entity.usermodule;

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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_role",uniqueConstraints={@UniqueConstraint(columnNames="user_role_name")})
public class UserRole {
	
	UserRole() {}
	
	public UserRole(Long userRoleId, String userRoleName, Set<Privilege> privileges) {
		this.userRoleName = userRoleName;
		this.privileges = privileges;
	}
	private Long userRoleId;
	private String userRoleName;
	
	private Set<Privilege> privileges;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id",nullable = false)
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	@Column(name = "user_role_name",length=100)
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_privilege_mapping",joinColumns = { 
			@JoinColumn(name = "user_role_id", updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "privilege_id", 
					 updatable = true) })
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}
