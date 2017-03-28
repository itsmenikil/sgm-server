package in.mitransoftwares.ecommerce.controller.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.mitransoftwares.ecommerce.entity.store.Store;
import in.mitransoftwares.ecommerce.service.store.StoreService;
import in.mitransoftwares.ecommerce.utility.FileUploadUtility;
import in.mitransoftwares.ecommerce.utility.MediaType;

@RestController
public class StoreController {	
	
	@Autowired StoreService storeService;
	
	@RequestMapping(value="store",method=RequestMethod.POST)
	public ResponseEntity<Store> createStore(@RequestBody Store store,@RequestParam("storeLogo") MultipartFile file){
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
	}

}
