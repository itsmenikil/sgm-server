package in.mitransoftwares.ecommerce.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mitransoftwares.ecommerce.entity.store.Store;
import in.mitransoftwares.ecommerce.repository.store.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired StoreRepository storRepository;

	@Override
	public Store createStore(Store store) {
		Store persistedStore=storRepository.save(store);
		return persistedStore;
	}

	
}
