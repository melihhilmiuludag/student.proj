package tr.com.melihhilmiuludag.student.proj.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author muludag on 2.05.2020
 */
public class MessagesView {

	public static void saveMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Created Student and Detail Info"));
	}
	public static void deleteMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Deleted Student"));
	}
	public static void updateMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Updated Student"));
	}

	public static void saveNotMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Student Registered Previously!"));
	}
}
