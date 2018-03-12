package br.com.ecommerce.product.repositories;

//TODO Verificar testes
/*@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DefaultProductRepository.class})
@EnableAutoConfiguration*/
public class ProductRepositoryTest {
	
/*	@Autowired
	private ProductRepository productRepository;
	
	@MockBean
	private EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
	@Before
	public void before() {
		EntityManager em = mock(EntityManager.class);
		when(entityManagerFactory.createEntityManager()).thenReturn(em);
		entityManager = em;
	}
	
	@Test
	public void findAll_called_success() {
		TypedQuery<Product> tq = mockTypedQuery(Product.class);
		String sql = "SELECT p FROM Product p";
		when(entityManager.createQuery(sql, Product.class)).thenReturn(tq);
		List<Product> lp = mockList(Product.class);
		when(tq.getResultList()).thenReturn(lp);
		
		
		List<Product> lp1 = productRepository.findAll();
		
		verify(entityManager).createQuery(sql, Product.class);
		verify(tq).getResultList();
		assertNotNull(lp1);
	}*/
}
