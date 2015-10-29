/**
 * 
 */
package net.kodice.safeTrip.admin.bean.core;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

/**
 * @author bentus
 *
 */
public class UtilBean {

	public static void sendMessage(
			FacesContext facesContext, RequestContext requestContext,
			final msgLevel level,  final String summary, final String detail) {
		FacesMessage infoMessage = new FacesMessage();
		infoMessage.setSummary(summary);
		infoMessage.setDetail(detail);
		switch (level) {
			case ERROR:
				infoMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				break;
			case FATAL:
				infoMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
				break;
			case INFO:
				infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
				break;
			case WARN:
				infoMessage.setSeverity(FacesMessage.SEVERITY_WARN);
				break;
			default:
				infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
				break;
		};
		facesContext.addMessage("messages", infoMessage);
		requestContext.update("messages");
	}
	
	public enum  msgLevel {
		ERROR, FATAL, INFO, WARN
	}
}
