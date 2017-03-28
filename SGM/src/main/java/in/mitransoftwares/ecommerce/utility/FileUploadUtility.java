package in.mitransoftwares.ecommerce.utility;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	
 public static String uploadFile(MediaType type,MultipartFile multiPart) {
		String filename ="";
		try {
			if (!multiPart.isEmpty()) {
	               byte[] bytes = multiPart.getBytes();
	                BufferedOutputStream stream = 
	                        new BufferedOutputStream(new FileOutputStream(new File(StoragePath.getLocation(type)+File.separator+filename)));
	                stream.write(bytes);
	                stream.close();
	                filename= multiPart.getOriginalFilename();
	        } 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename; 
	}
	
}


 class StoragePath{
	private StoragePath(){}
	
	@Value("${image.path}")
	private static String imageLocation="C:\\Users\\nikil-jain\\Desktop\\ecommerce\\image";
	@Value("${file.path}")
	private static String fileLocation;
	
	public static String getLocation(MediaType type) {
		
		if(type.equals(MediaType.IMAGE)){
			return imageLocation;
		}else if(type.equals(MediaType.FILE)){
			return fileLocation;
		}
		else{
			return null;
		}
		
	}
	
 }