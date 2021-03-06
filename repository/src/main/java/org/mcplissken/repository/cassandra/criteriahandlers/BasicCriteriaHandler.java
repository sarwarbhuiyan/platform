/**
 * 
 */
package org.mcplissken.repository.cassandra.criteriahandlers;

import java.util.Map;

import org.mcplissken.repository.key.RestCriteria;
import org.mcplissken.repository.key.exception.InvalidCriteriaException;

import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.Select.Where;

/**
 * @author 	Sherief Shawky
 * @email 	sherif.shawki@mubasher.info
 * @date 	Sep 8, 2014
 */
public abstract class BasicCriteriaHandler implements CriteriaHandler {

	private Map<String, Clause> criterias;
	private String id;
	
	/* (non-Javadoc)
	 * @see com.mubasher.market.repository.cassandra.criteriahandlers.CriteriaHandler#handle(com.mubasher.market.repository.key.RestCriteria, java.util.Map, com.datastax.driver.core.querybuilder.Select.Where)
	 */
	@Override
	public void handle(RestCriteria criteria, Map<String, Clause> criterias,
			Where query) throws InvalidCriteriaException {

		try {
			
			this.criterias = criterias;
		
			String id = criteria.readCriteriaId();
			
			this.id = id;
		
			resolveCriteria(criteria, query);

		} catch (Exception e) {

			throw new InvalidCriteriaException(e);
		}

	}
	
	protected void addClause(Clause clause){
		criterias.put(id, clause);
	}
	
	protected Clause readClause(String id){
		return criterias.get(id);
	}
	
	protected abstract void resolveCriteria(
			RestCriteria criteria, Where query) throws Exception;
}
