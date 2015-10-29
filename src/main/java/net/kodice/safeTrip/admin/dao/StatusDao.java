/**
 * 
 */
package net.kodice.safeTrip.admin.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.kodice.safeTrip.admin.dao.core.GenericDao;
import net.kodice.safeTrip.admin.model.Status;

/**
 * @author bentus
 *
 */
@Stateless
public class StatusDao extends GenericDao<Status> {
	@PersistenceContext(unitName = "safeTripAdmin")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public StatusDao() {
		super(Status.class);
	}
	
	@SuppressWarnings("unchecked")	
	public List<Status> findAll(String tableName){
    	try {
    		String jpql = "select s from Status s where s.tableName= :tableName"
    				+ "order by s.order";
    		Query query = getEntityManager().createQuery(jpql);
    		query.setParameter("tableName", tableName);
            List<Status> statusList = query.getResultList() != null && !query.getResultList().isEmpty() ? (List<Status>) query.getResultList() : null;
            return statusList;
    	} catch (Exception e) {
            Logger.getLogger(StatusDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }    	
    }

}
