package br.com.ecommerce.cart.product.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.cart.product.entities.Product;

@Repository
public class DefaultProductRepository implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;
    

	@Override
	public List<Product> findAll() {
		TypedQuery<Product> tq = entityManager.createQuery("SELECT p FROM Product p", getEntityClass());
		return tq.getResultList();
	}
	
	@Override
	public List<Product> findAllComplete() {
		TypedQuery<Product> tq = entityManager.createQuery("SELECT DISTINCT(p) FROM Product p LEFT JOIN FETCH p.products LEFT JOIN FETCH p.images", getEntityClass());
		return tq.getResultList();
	}
	
	@Override
	public Product findByIdComplete(Long id) {
		TypedQuery<Product> tq = entityManager.createQuery("SELECT p FROM Product p LEFT JOIN FETCH p.products LEFT JOIN FETCH p.images WHERE p.id = :id", getEntityClass()); 
		tq.setParameter("id", id);
		List<Product> resultList = tq.getResultList();
		
		return resultList.isEmpty() ? new Product() : resultList.get(0);
	}
	
	@Override
	public Product findById(Long id) {
		return entityManager.find(getEntityClass(), id);
	}
	
	@Override
	public List<Product> findSubproductsByParentId(Long id) {
		TypedQuery<Product> tq = entityManager.createQuery("SELECT p FROM Product p WHERE p.parentProductId = :id", getEntityClass()); 
		tq.setParameter("id", id);
		
		return tq.getResultList();
	}


	@Override
	@Transactional
	public void save(Product product) {
		entityManager.persist(product);
	}
	
	@Override
	@Transactional
	public void update(Product product) {
		Product e = entityManager.find(getEntityClass(), product.getId());
		
		if(e != null) {
			entityManager.merge(product);
		} else {
			throw new RuntimeException("O Id informado não corresponde a um produto cadastrado");
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		TypedQuery<Product> tq = entityManager.createQuery("SELECT DISTINCT(p) FROM Product p LEFT JOIN FETCH p.products WHERE p.id = :id", getEntityClass());
		tq.setParameter("id", id);
		List<Product> resultList = tq.getResultList();
		
		if(!resultList.isEmpty()) {
			Product e = resultList.get(0);
			entityManager.remove(e);
		} else {
			throw new RuntimeException("O Id informado não corresponde a um produto cadastrado");
		}
		
	}

	
}
