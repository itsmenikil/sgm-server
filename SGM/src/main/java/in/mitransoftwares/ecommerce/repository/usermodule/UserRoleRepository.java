package in.mitransoftwares.ecommerce.repository.usermodule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.mitransoftwares.ecommerce.entity.usermodule.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
