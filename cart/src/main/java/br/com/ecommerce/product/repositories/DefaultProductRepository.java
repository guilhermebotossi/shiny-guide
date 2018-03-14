package br.com.ecommerce.product.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.product.model.Product;

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
	public Product findById(Long id) {
		return entityManager.find(getEntityClass(), id);
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
		TypedQuery<Product> tq = entityManager.createQuery("SELECT p FROM Product p WHERE p.id = :id", getEntityClass());
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
