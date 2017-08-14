package in.mitransoftwares.ecommerce.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.mitransoftwares.ecommerce.entity.security.UserToken;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {

}
