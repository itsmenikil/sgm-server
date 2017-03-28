package in.mitransoftwares.ecommerce.entity.usermodule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "privilege",uniqueConstraints={@UniqueConstraint(columnNames="privilege_name")})
public class Privilege {

	Privilege() {}
	
	
	private Long privilegeId;
	private String privilegeName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "privilege_id",nullable = false)
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	@Column(name = "privilege_name",length=100)
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

}
