package in.mitransoftwares.ecommerce.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	Product() {}
	
	private Long productId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id",nullable = false)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
