package in.mitransoftwares.ecommerce.controller.store;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.mitransoftwares.ecommerce.entity.store.Store;	

@RestController
public class StoreController {	
	
	
	ArrayList<Store> storeDb=new ArrayList<>();
	
	
	@RequestMapping(value="/store",method=RequestMethod.POST)
	public ArrayList<Store> addStore(@RequestBody Store store){
		storeDb.add(store);
		return stores();
	}
	
	@RequestMapping(value="/store/{storeId}",method=RequestMethod.DELETE)
	public ResponseEntity<ArrayList<Store>> deleteStore(@PathVariable("storeId") Long storeId){
		ArrayList<Store> storlist=stores();
		
		Iterator<Store> store=storlist.iterator();
		while (store.hasNext()) {
			Store store2 = (Store) store.next();
			if(store2.getStoreId()==storeId){
				store.remove();
    			return new ResponseEntity<ArrayList<Store>>(storlist,HttpStatus.OK);
    		}
		}
		return new ResponseEntity<ArrayList<Store>>(storlist,HttpStatus.OK);
	}
	
	
	
    @RequestMapping(value="/store/{storeId}",method=RequestMethod.PUT)
	public ResponseEntity<ArrayList<Store>> updateStore(@PathVariable("storeId") Long storeId,@RequestBody Store store){
    	
    	ArrayList<Store> storlist=stores();
    	
    	Iterator<Store> storeI=storlist.iterator();
		while (storeI.hasNext()) {
			Store store2 = (Store) storeI.next();
			if(store2.getStoreId()==storeId){
				store2.setStoreName(store.getStoreName());
				store2.setStoreLogoPath(store.getStoreLogoPath());
				store2.setStoreUrl(store.getStoreUrl());
    			break;
    		}
		}
    	
			return new ResponseEntity<ArrayList<Store>>(storlist,HttpStatus.OK);
	}
	
    @RequestMapping(value="/store/{storeId}",method=RequestMethod.GET)
	public ResponseEntity<Store> getStore(@PathVariable("storeId") Long storeId){
    	ArrayList<Store> storlist=stores();
    	
    	for (Store store : storlist) {
    		if(store.getStoreId()==storeId){
    			return new ResponseEntity<Store>(store, HttpStatus.OK);
    		}
    	}
    	
    	return new ResponseEntity<Store>(HttpStatus.BAD_REQUEST);
	}
    
	
    @RequestMapping(value="/store",method=RequestMethod.GET)
    @PreAuthorize("hasAuthority('P5')")
	public ArrayList<Store> getStorList(){
		return stores();
	}
	
    
    
    
    public ArrayList<Store> stores(){
    	if(storeDb.isEmpty()){
    		storeDb.add(new Store(1L,"store1", "www.store1.com","logo/store1.jpg"));
    		storeDb.add(new Store(2L,"store2", "www.store2.com","logo/store2.jpg"));
    		storeDb.add(new Store(3L,"store3", "www.store3.com","logo/store3.jpg"));
    		storeDb.add(new Store(4L,"store4", "www.store4.com","logo/store4.jpg"));
    	}
    	
    	return storeDb;
    }
    
    
    
    
    
    
    
    
	
	/*@Autowired StoreService storeService;
	
	@CrossOrigin
	@RequestMapping(value="/store",method=RequestMethod.POST)
	public ResponseEntity<Store> createStore(@RequestParam("storeLogo" ) MultipartFile file, @RequestParam("store") Store store){
		try {
			String fileName="";
		    Store persistedStored=null;
			fileName = FileUploadUtility.uploadFile(MediaType.IMAGE,file);
			   if(!fileName.equals("")){
					store.setStoreLogoPath(fileName);
				    persistedStored=getStoreService().createStore(store);
				    return new ResponseEntity<Store>(persistedStored,HttpStatus.OK);
				}
				else{
					return new ResponseEntity<Store>(HttpStatus.BAD_REQUEST);
				}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Store>(HttpStatus.BAD_REQUEST);
			
		}
	    
	}
	
	@CrossOrigin
	@RequestMapping(value="store",method=RequestMethod.GET)
	public Store storeById(){
		Store obj=new Store();
		obj.setStoreId(1L);
		obj.setStoreLogoPath("/njhj/hjghjg");
		obj.setStoreName("shanthiguru");
		obj.setStoreUrl("www.tyu.com");
		return obj;
		
	}

	public StoreService getStoreService() {
		return storeService;
	}*/

	
	
}
