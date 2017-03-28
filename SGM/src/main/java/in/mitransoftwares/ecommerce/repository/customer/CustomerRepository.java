package in.mitransoftwares.ecommerce.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mitransoftwares.ecommerce.entity.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
