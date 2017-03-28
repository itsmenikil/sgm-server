package in.mitransoftwares.ecommerce.utility;

public class SuccessMessage {

	public SuccessMessage(String uiMessage, Object entityObject) {
		this.uiMessage = uiMessage;
		this.entityObject = entityObject;
	}
	
	private String uiMessage;
	private Object entityObject;
	
	public String getUiMessage() {
		return uiMessage;
	}
	public void setUiMessage(String uiMessage) {
		this.uiMessage = uiMessage;
	}
	public Object getEntityObject() {
		return entityObject;
	}
	public void setEntityObject(Object entityObject) {
		this.entityObject = entityObject;
	}
	
}
