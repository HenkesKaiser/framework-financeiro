package framework.core.orm;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.poi.hssf.record.formula.functions.T;

public class JpaService
{

	@PersistenceContext
	private EntityManager em;

	public JpaService()
	{
	}

	private Class<T> type;

	/**
	 * Default constructor
	 * 
	 * @param type
	 *            entity class
	 */
	public JpaService(Class<T> type)
	{
		this.type = type;
	}

	/**
	 * Stores an instance of the entity class in the database
	 * 
	 * @param T
	 *            Object
	 * @return
	 */
	public T create(T t)
	{
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	/**
	 * Retrieves an entity instance that was previously persisted to the
	 * database
	 * 
	 * @param T
	 *            Object
	 * @param id
	 * @return
	 */
	public T find(Object id)
	{
		return this.em.find(this.type, id);
	}

	/**
	 * Removes the record that is associated with the entity instance
	 * 
	 * @param type
	 * @param id
	 */
	public void delete(Object id)
	{
		Object ref = this.em.getReference(this.type, id);
		this.em.remove(ref);
	}

	/**
	 * Removes the number of entries from a table
	 * 
	 * @param <T>
	 * @param items
	 * @return
	 */
	public boolean deleteItems(T[] items)
	{
		for (T item : items) {
			em.remove(em.merge(item));
		}
		return true;
	}

	/**
	 * Updates the entity instance
	 * 
	 * @param <T>
	 * @param t
	 * @return the object that is updated
	 */
	public T update(T t)
	{
		return this.em.merge(t);
	}

	/**
	 * Returns the number of records that meet the criteria
	 * 
	 * @param namedQueryName
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName)
	{
		return this.em.createNamedQuery(namedQueryName).getResultList();
	}

	/**
	 * Returns the number of records that meet the criteria
	 * 
	 * @param namedQueryName
	 * @param parameters
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName, Map parameters)
	{
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	/**
	 * Returns the number of records with result limit
	 * 
	 * @param queryName
	 * @param resultLimit
	 * @return List
	 */
	public List findWithNamedQuery(String queryName, int resultLimit)
	{
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit)
				.getResultList();
	}

	/**
	 * Returns the number of records that meet the criteria
	 * 
	 * @param <T>
	 * @param sql
	 * @param type
	 * @return List
	 */
	public List<T> findByNativeQuery(String sql)
	{
		return this.em.createNativeQuery(sql, type).getResultList();
	}

	/**
	 * Returns the number of total records
	 * 
	 * @param namedQueryName
	 * @return int
	 */
	public int countTotalRecord(String namedQueryName)
	{
		Query query = em.createNamedQuery(namedQueryName);
		Number result = (Number) query.getSingleResult();
		return result.intValue();
	}

	/**
	 * Returns the number of records that meet the criteria with parameter map
	 * and result limit
	 * 
	 * @param namedQueryName
	 * @param parameters
	 * @param resultLimit
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName, Map parameters,
			int resultLimit)
	{
		Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQueryName);
		if (resultLimit > 0) {
			query.setMaxResults(resultLimit);
		}
		for (Map.Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	/**
	 * Returns the number of records that will be used with lazy loading /
	 * pagination
	 * 
	 * @param namedQueryName
	 * @param start
	 * @param end
	 * @return List
	 */
	public List findWithNamedQuery(String namedQueryName, int start, int end)
	{
		Query query = this.em.createNamedQuery(namedQueryName);
		query.setMaxResults(end - start);
		query.setFirstResult(start);
		return query.getResultList();
	}

	public String findByToJPQL(String findBy)
	{
		findBy = findBy.substring(2);
		StringBuilder jpql = new StringBuilder();
		String subRequest;
		if (findBy.contains("OrderBy")) {
			subRequest = findBy.split("OrderBy")[0];
		}
		else {
			subRequest = findBy;
		}
		String[] parts = subRequest.split("And");
		int index = 1;
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (part.endsWith("NotEqual")) {
				String prop = extractProp(part, "NotEqual");
				jpql.append(prop).append(" <> ?").append(index++);
			}
			else if (part.endsWith("Equal")) {
				String prop = extractProp(part, "Equal");
				jpql.append(prop).append(" = ?").append(index++);
			}
			else if (part.endsWith("IsNotNull")) {
				String prop = extractProp(part, "IsNotNull");
				jpql.append(prop).append(" is not null");
			}
			else if (part.endsWith("IsNull")) {
				String prop = extractProp(part, "IsNull");
				jpql.append(prop).append(" is null");
			}
			else if (part.endsWith("LessThan")) {
				String prop = extractProp(part, "LessThan");
				jpql.append(prop).append(" < ?").append(index++);
			}
			else if (part.endsWith("LessThanEquals")) {
				String prop = extractProp(part, "LessThanEquals");
				jpql.append(prop).append(" <= ?").append(index++);
			}
			else if (part.endsWith("GreaterThan")) {
				String prop = extractProp(part, "GreaterThan");
				jpql.append(prop).append(" > ?").append(index++);
			}
			else if (part.endsWith("GreaterThanEquals")) {
				String prop = extractProp(part, "GreaterThanEquals");
				jpql.append(prop).append(" >= ?").append(index++);
			}
			else if (part.endsWith("Between")) {
				String prop = extractProp(part, "Between");
				jpql.append(prop).append(" < ?").append(index++)
						.append(" AND ").append(prop).append(" > ?")
						.append(index++);
			}
			else if (part.endsWith("Like")) {
				String prop = extractProp(part, "Like");
				// HSQL -> LCASE, all other dbs lower
				if (isHSQL()) {
					jpql.append("LCASE(").append(prop).append(") like ?")
							.append(index++);
				}
				else {
					jpql.append("LOWER(").append(prop).append(") like ?")
							.append(index++);
				}
			}
			else if (part.endsWith("Ilike")) {
				String prop = extractProp(part, "Ilike");
				if (isHSQL()) {
					jpql.append("LCASE(").append(prop).append(") like LCASE(?")
							.append(index++).append(")");
				}
				else {
					jpql.append("LOWER(").append(prop).append(") like LOWER(?")
							.append(index++).append(")");
				}
			}
			else if (part.endsWith("Elike")) {
				String prop = extractProp(part, "Elike");
				jpql.append(prop).append(" like ?").append(index++);
			}
			else {
				String prop = extractProp(part, "");
				jpql.append(prop).append(" = ?").append(index++);
			}
			if (i < parts.length - 1) {
				jpql.append(" AND ");
			}
		}
		// ORDER BY clause
		if (findBy.contains("OrderBy")) {
			jpql.append(" ORDER BY ");
			String orderQuery = findBy.split("OrderBy")[1];
			parts = orderQuery.split("And");
			for (int i = 0; i < parts.length; i++) {
				String part = parts[i];
				String orderProp;
				if (part.endsWith("Desc")) {
					orderProp = extractProp(part, "Desc") + " DESC";
				}
				else {
					orderProp = part.toLowerCase();
				}
				if (i > 0) {
					jpql.append(", ");
				}
				jpql.append(orderProp);
			}
		}
		return jpql.toString();
	}

	public Query bindParameters(Query q, Map<String, Object> params)
	{
		if (params == null) {
			return q;
		}
		for (String key : params.keySet()) {
			q.setParameter(key, params.get(key));
		}
		return q;
	}

	protected static String extractProp(String part, String end)
	{
		String prop = part.substring(0, part.length() - end.length());
		prop = (prop.charAt(0) + "").toLowerCase() + prop.substring(1);
		return prop;
	}

}