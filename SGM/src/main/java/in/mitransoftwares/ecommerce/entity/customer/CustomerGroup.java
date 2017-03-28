package in.mitransoftwares.ecommerce.entity.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="customer_group",uniqueConstraints={@UniqueConstraint(columnNames="customer_group_name")})
public class CustomerGroup {

	private Long customerGroupId;
	private String customerGroupName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_group_id",nullable = false)
	public Long getCustomerGroupId() {
		return customerGroupId;
	}
	public void setCustomerGroupId(Long customerGroupId) {
		this.customerGroupId = customerGroupId;
	}
	@Column(name = "customer_group_name",length=100)
	public String getCustomerGroupName() {
		return customerGroupName;
	}
	public void setCustomerGroupName(String customerGroupName) {
		this.customerGroupName = customerGroupName;
	}
	
}
