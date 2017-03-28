package in.mitransoftwares.ecommerce.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.mitransoftwares.ecommerce.entity.store.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	
}
