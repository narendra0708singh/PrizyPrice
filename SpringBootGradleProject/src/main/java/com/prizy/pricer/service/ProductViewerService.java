package com.prizy.pricer.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.pricer.dao.Product;
import com.prizy.pricer.dao.ProductLoaderDAO;
import com.prizy.pricer.dto.ProductDetailsDTO;
import com.prizy.pricer.repository.ProductViewerRepository;

@Service
public class ProductViewerService implements ProductViewerRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> listProduct(Integer barCode) {
		if(barCode==null)
		{
			return sessionFactory.openSession().createQuery("from products").list();
		}
		else {
			return sessionFactory.openSession().createQuery("from products  WHERE BarCode = :barCode").setParameter("barCode", barCode).list();
		}
		
	}

	@Override
	public ProductDetailsDTO productDetails(int barCode) {
		try {
			return getPoductViewerDetails(barCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	private ProductDetailsDTO getPoductViewerDetails(int barCode) {
		List<ProductLoaderDAO> loaderList;
		double lowPrice = 0;
		double highestPrice = 0;
		double avgPrice = 0;
		double idealPrice = 0;

		String selectQuery = "FROM productsloader WHERE BarCode = :barCode order by price asc";
		try {
			loaderList = sessionFactory.openSession().createQuery(selectQuery, ProductLoaderDAO.class)
					.setParameter("barCode", barCode).list();
			for (int i = 0; i < loaderList.size(); i++) {
				System.out.println(loaderList.get(i));
				if (i == 0) {
					lowPrice = loaderList.get(i).getPrice();
				}

				avgPrice += loaderList.get(i).getPrice();

				if (i == loaderList.size() - 1) {
					highestPrice = loaderList.get(i).getPrice();
					avgPrice = avgPrice / loaderList.size();
				}

				if (loaderList.size() > 4) {
					if (i != 0 && i != 1 && i != loaderList.size() - 1 && i != loaderList.size() - 2) {
						idealPrice += loaderList.get(i).getPrice();
					}
				}
			}
			if (loaderList.size() > 4) {
				idealPrice = (idealPrice / (loaderList.size() - 4))
						+ (((idealPrice / (loaderList.size() - 4)) * 20) / 100);
			} else {
				idealPrice = avgPrice;
			}
			ProductDetailsDTO detailsDTO = new ProductDetailsDTO();
			detailsDTO.setAvgPrice(avgPrice);
			detailsDTO.setBarCode(barCode);
			detailsDTO.setHighestPrice(highestPrice);
			detailsDTO.setLowPrice(lowPrice);
			detailsDTO.setIdealPrice(idealPrice);
			detailsDTO.setNoOfPriceCollected(priceCollected(loaderList));
			detailsDTO.setProductDiscription(productDesc(barCode));
			return detailsDTO;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	 public int priceCollected (List<ProductLoaderDAO> myList){
	        Set<Integer> hashsetList =new HashSet<>();
	        for (int i = 0; i <myList.size(); i++) {
	        	hashsetList.add(myList.get(i).getPrice());
			}
	        return hashsetList.size();
	 }

	public String productDesc(int barCode) {

		String selectQuery = "FROM products WHERE BarCode = :barCode";
			Product product = sessionFactory.openSession().createQuery(selectQuery, Product.class)
					.setParameter("barCode", barCode).uniqueResult();
			return product.getDiscription();
	
	}
}
