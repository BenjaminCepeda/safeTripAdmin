/**
 * 
 */
package net.kodice.safeTrip.admin.bean.core;



/**
 * @author bentus
 *
 */
public abstract class GenericBean  implements IBean {

	private boolean isEditMode;
	
	public boolean isEditMode() {
		return isEditMode;
	}

	public void setEditMode(boolean isEditMode) {
		this.isEditMode = isEditMode;
	}

}
