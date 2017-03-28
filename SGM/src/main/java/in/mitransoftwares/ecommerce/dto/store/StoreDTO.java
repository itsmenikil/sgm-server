package in.mitransoftwares.ecommerce.dto.store;

import in.mitransoftwares.ecommerce.helper.beans.File;

public class StoreDTO {

	private String storeId;
	private String storeName;
	private String storeUrl;
	private String storeLogoPath;
	private File file;

	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreUrl() {
		return storeUrl;
	}
	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}
	public String getStoreLogoPath() {
		return storeLogoPath;
	}
	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
}
