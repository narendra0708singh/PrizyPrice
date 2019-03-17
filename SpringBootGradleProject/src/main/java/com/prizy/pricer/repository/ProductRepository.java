package com.prizy.pricer.repository;

import org.springframework.stereotype.Repository;

import com.prizy.pricer.dto.ProductLoaderDTO;

@Repository("loaderService")
public interface ProductRepository{
	
	public boolean insertProductDetails(ProductLoaderDTO productDTO);
	
	public boolean searchProductDetails(int barCode, String store);
	
	public boolean isProductExist(int barCode);

}
