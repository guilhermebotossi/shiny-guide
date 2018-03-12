package br.com.ecommerce.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.product.services.ProductService;
import br.com.ecommerce.product.vos.ProductVO;


@RestController(value = "productController")
@RequestMapping("/product")
@SuppressWarnings("rawtypes")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(path = "/add",method = RequestMethod.PUT)
	public ResponseEntity create(@RequestBody ProductVO product) {
		try {
			productService.create(product);
			return ResponseEntity.status(HttpStatus.OK).body("Ok");
		} catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	
	@RequestMapping(path = "/edit",method = RequestMethod.POST)
	public ResponseEntity edit(@RequestBody ProductVO product) {
		try {
			productService.update(product);
			return ResponseEntity.status(HttpStatus.OK).body("Ok");
		} catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResponseEntity list() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
		} catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	@RequestMapping(path="/list/{id}", method = RequestMethod.GET)
	public ResponseEntity findById(@PathVariable(value = "id") Long id) {
		try {
			return ResponseEntity.ok(productService.findById(id));
		} catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@RequestMapping(path="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable(value = "id") Long id) {
		try {
			productService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Ok");
		} catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	
}
