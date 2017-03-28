package in.mitransoftwares.ecommerce.repository.usermodule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.mitransoftwares.ecommerce.entity.usermodule.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmail(String email);
	User findUserByUserName(String userName);
	
}
