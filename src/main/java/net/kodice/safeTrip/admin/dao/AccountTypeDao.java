/**
 * 
 */
package net.kodice.safeTrip.admin.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.kodice.safeTrip.admin.dao.core.GenericDao;
import net.kodice.safeTrip.admin.model.AccountType;

/**
 * @author bentus
 *
 */
@Stateless
public class AccountTypeDao extends GenericDao<AccountType> {
	@PersistenceContext(unitName = "safeTripAdmin")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AccountTypeDao() {
		super(AccountType.class);
	}

	
/*	@SuppressWarnings("unchecked")	
	public List<AccountType> findAll(String tableName){
    	try {
    		String jpql = "select a from AccountType a";
    		Query query = getEntityManager().createQuery(jpql);
            List<AccountType> accountTypeList = query.getResultList() != null && !query.getResultList().isEmpty() ? (List<AccountType>) query.getResultList() : null;
            return accountTypeList;
    	} catch (Exception e) {
            Logger.getLogger(AccountTypeDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }    	
    }*/
	

}
