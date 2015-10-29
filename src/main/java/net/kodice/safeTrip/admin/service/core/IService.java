/**
 * 
 */
package net.kodice.safeTrip.admin.service.core;

import java.util.List;

/**
 * @author bentus
 *
 */
public interface IService {

	public void create(Object o) throws Exception ;
	
	public void edit(Object o) throws Exception ;
	
	public void remove(Object o) throws Exception ;
	
	public Object find(Object o) throws Exception ;
		
	public List<?> findAll(Object o) throws Exception ;

	public List<?> findAll() throws Exception ;

}
