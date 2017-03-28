package in.mitransoftwares.ecommerce.service.store;

import javax.transaction.Transactional;

import in.mitransoftwares.ecommerce.entity.store.Store;

@Transactional
public interface StoreService {

	public Store createStore(Store store);
}
