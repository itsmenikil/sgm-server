package in.mitransoftwares.ecommerce.helper.beans;

public class File {

	private String fileName;
	private String fileExtension;
	private byte []fileStreamArray;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileStreamArray() {
		return fileStreamArray;
	}
	public void setFileStreamArray(byte[] fileStreamArray) {
		this.fileStreamArray = fileStreamArray;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
}
