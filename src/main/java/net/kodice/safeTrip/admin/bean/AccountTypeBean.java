/**
 * 
 */
package net.kodice.safeTrip.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
/*import javax.inject.Inject;
*/
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import net.kodice.safeTrip.admin.bean.core.GenericBean;
import net.kodice.safeTrip.admin.bean.core.UtilBean;
import net.kodice.safeTrip.admin.bean.core.UtilBean.msgLevel;
import net.kodice.safeTrip.admin.bundle.CurrentBundle;
import net.kodice.safeTrip.admin.dao.AccountTypeDao;
import net.kodice.safeTrip.admin.model.AccountType;

/**
 * @author bentus
 *
 */

@Named(value = "accountTypeBean")
@ViewScoped
public class AccountTypeBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AccountTypeDao accountTypeDao;

	/*
	 * Model object local instance
	 */
	private AccountType accountType;
	private List<AccountType> accountTypeList;

	public AccountTypeBean() {
	}

	@Override
	@PostConstruct
	public void init() {
		accountType = new AccountType();
		accountType.setEditable(Boolean.FALSE);
		try {
			if (accountTypeList == null) {
				accountTypeList = new ArrayList<AccountType>();
				accountTypeList = (List<AccountType>) accountTypeDao.findAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("init.mensaje");
		// sendMessage(msgLevel.INFO, "init.mensaje", "");
	}

	@Override
	public void load() {
		sendMessage(msgLevel.INFO, "load.mensaje", "");
		accountType.setEditable(Boolean.FALSE);
		try {
			accountTypeList = new ArrayList<AccountType>();
			accountTypeList = (List<AccountType>) accountTypeDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create() {
		sendMessage(msgLevel.INFO, "create.mensaje", "");
		// accountTypeDao.create((AccountType) accountType);

		// this.init();

	}

	@Override
	public void edit() {
		sendMessage(msgLevel.INFO, "edit.mensaje", "");
		try {
			accountTypeDao.edit((AccountType) accountType);
			this.init();
//			accountType.setEditable(Boolean.FALSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onRowEdit(RowEditEvent event) {
		/*
		 * Here modify or calculate more values
		 */
		AccountType element = (AccountType) event.getObject();
		System.out.println("onRowEdit:" + element.toString());
		if (element.getId() == null || element.getId()==0)
			accountTypeDao.create(element);
		else
			accountTypeDao.edit(element);
		accountType.setEditable(Boolean.FALSE);
		
	}

	public void onRowAdd(ActionEvent actionEvent) {
		/*
		 * Here modify or calculate more values
		 */
		AccountType newAccountType = new AccountType();
		accountTypeList.add(newAccountType);
		accountType.setEditable(Boolean.FALSE);
		System.out.println("onRowAdd:" + ((AccountType) newAccountType).toString());
	}

	public String onRowCancel(RowEditEvent event) {
		accountType.setEditable(Boolean.FALSE);
		/*
		 * Here modify or calculate more values
		 */
		this.load();
		System.out.println("onRowCancel:" + ((AccountType) event.getObject()).toString());
		return null;
	}

	@Override
	public void remove() {
		sendMessage(msgLevel.INFO, "remove.mensaje", "");
		try {
			/*
			 * Logical remove
			 */
//			accountType.setEditable(Boolean.FALSE);
			accountType.setEnabled(Boolean.FALSE);
			accountTypeDao.edit(accountType);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public String remove() { try {
	 * 
	 * Logical remove
	 * 
	 * accountType.setEditable(Boolean.FALSE);
	 * accountType.setEnabled(Boolean.FALSE); accountTypeDao.edit(accountType);
	 * } catch (Exception e) { e.printStackTrace(); } return null; }
	 */ public void remove(ActionEvent event) {
		sendMessage(msgLevel.INFO, "remove.mensaje", "");
		try {
			/*
			 * Logical remove
			 */
//			accountType.setEditable(Boolean.FALSE);
			accountType.setEnabled(Boolean.FALSE);
			accountTypeDao.edit(accountType);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String select(Object o) {
		sendMessage(msgLevel.INFO, "select.mensaje", "");

		this.accountType = (AccountType) o;
//		accountType.setEditable(Boolean.FALSE);
		return "";
	}

	public String select(RowEditEvent event) {
		sendMessage(msgLevel.INFO, "select.mensaje", "");

		this.accountType = (AccountType) event.getObject();
//		accountType.setEditable(Boolean.FALSE);
		return "";
	}

	@Override
	public void sendMessage(msgLevel level, String bundleKey, String detail, Object... params) {
		Locale locale;
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		UtilBean.sendMessage(FacesContext.getCurrentInstance(), RequestContext.getCurrentInstance(), level,
				CurrentBundle.getBundle(locale, bundleKey, params), detail);
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public List<AccountType> getAccountTypeList() {
		return accountTypeList;
	}

	public void setAccountTypeList(List<AccountType> accountTypeList) {
		this.accountTypeList = accountTypeList;
	}

}
