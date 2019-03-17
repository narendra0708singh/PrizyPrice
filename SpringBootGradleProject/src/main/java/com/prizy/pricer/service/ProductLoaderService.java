package com.prizy.pricer.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.pricer.dao.Product;
import com.prizy.pricer.dao.ProductLoaderDAO;
import com.prizy.pricer.dto.ProductLoaderDTO;
import com.prizy.pricer.repository.ProductRepository;

@Service
public class ProductLoaderService implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean insertProductDetails(ProductLoaderDTO loaderDTO) {
		
		ProductLoaderDAO loaderDAO=new ProductLoaderDAO();
		loaderDAO.setBarCode(loaderDTO.getBarCode());
		loaderDAO.setNotes(loaderDTO.getNotes());
		loaderDAO.setPrice(loaderDTO.getPrice());
		loaderDAO.setStore(loaderDTO.getStore());
		try {
			Session session = null;
			System.out.println(this.sessionFactory);
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(loaderDAO);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean searchProductDetails(int barCode, String store) {
		String selectQuery = "FROM productsloader WHERE BarCode = :barCode  AND Store = :store";
		try {
			ProductLoaderDAO dao = sessionFactory.openSession().createQuery(selectQuery, ProductLoaderDAO.class)
					.setParameter("barCode", barCode).setParameter("store", store).uniqueResult();
			if (dao != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isProductExist(int barCode) {
		String selectQuery = "FROM products WHERE BarCode = :barCode";
//		try {
			Product product = sessionFactory.openSession().createQuery(selectQuery, Product.class)
					.setParameter("barCode", barCode).uniqueResult();
			System.out.println("------product-----"+product);
			if (product != null) {
				return true;
			} else {
				return false;
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}
}
