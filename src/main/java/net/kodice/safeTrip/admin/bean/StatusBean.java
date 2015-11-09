package net.kodice.safeTrip.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import net.kodice.safeTrip.admin.bean.core.GenericBean;
import net.kodice.safeTrip.admin.bean.core.UtilBean;
import net.kodice.safeTrip.admin.bean.core.UtilBean.*;
import net.kodice.safeTrip.admin.model.Status;

import net.kodice.safeTrip.admin.bundle.CurrentBundle;
import net.kodice.safeTrip.admin.dao.StatusDao;

@ManagedBean
@Named(value = "statusBean")
@ViewScoped
public class StatusBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private StatusDao statusDao;

	/*
	 * Model object local instance
	 */
	private Status status;
	private List<Status> statusList;

	public StatusBean() {
	}

	@Override
	@PostConstruct
	public void init() {
		status = new Status();
		status.setEditable(Boolean.FALSE);
		load();
		System.out.println(status.toString());
		sendMessage(msgLevel.INFO, "general.mensaje","");
	}

	@Override
	public void load() {
		try {
			statusList = new ArrayList<Status>();
			statusList = (List<Status>) statusDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create() {
		try {
			statusDao.create((Status) status);
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	public void edit() {
		try {
			statusDao.edit((Status) status);
			this.init();
			status.setEditable(Boolean.FALSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String edit(Status status) {
		status.setEditable(Boolean.FALSE);
		/*
		 * Here modify or calculate more values
		 */
		this.setStatus(status);
		return "";
	}

	@Override
	public void remove() {
		try {
			/*
			 * Logical remove
			 */
			status.setEnabled(Boolean.FALSE);
			statusDao.edit(status);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String select(Object o) {
		this.status = (Status) o;
		return "";
	}

	@Override
	public void sendMessage(msgLevel level, String bundleKey, String detail, Object... params ) {
		Locale locale;
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		UtilBean.sendMessage(
				FacesContext.getCurrentInstance(), RequestContext.getCurrentInstance(),
				level, CurrentBundle.getBundle(locale,bundleKey,params), detail);
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Status> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}

}
