/**
 * 
 */
package net.kodice.safeTrip.admin.bean.core;

import net.kodice.safeTrip.admin.bean.core.UtilBean.msgLevel;

/**
 * @author bentus
 *
 */
public interface IBean {
	
	public void init();

	public void load();
	
	public void create();
	
	public void edit();
	
	public void remove();
	
	public String select(Object o);
	
	public void sendMessage(msgLevel level, String bundleKey, String detail, Object... params );

		
}
