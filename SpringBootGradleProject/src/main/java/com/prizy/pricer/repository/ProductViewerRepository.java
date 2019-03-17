package com.prizy.pricer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.prizy.pricer.dao.Product;
import com.prizy.pricer.dto.ProductDetailsDTO;

@Repository("viewProduct")
public interface ProductViewerRepository {
	
	public List<Product> listProduct(Integer barCode);
	
	public ProductDetailsDTO productDetails(int barCode);

}
