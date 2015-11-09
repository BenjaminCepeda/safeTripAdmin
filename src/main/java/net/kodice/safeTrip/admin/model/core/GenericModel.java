/**
 * 
 */
package net.kodice.safeTrip.admin.model.core;


/**
 * @author bentus
 *
 */
public abstract class GenericModel{
	/**
	 * 
	 */
	private boolean editable;

	public boolean getEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
