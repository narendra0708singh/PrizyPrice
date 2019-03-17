package com.prizy.pricer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.pricer.dao.Product;
import com.prizy.pricer.dto.ApiGenricResponse;
import com.prizy.pricer.dto.ProductDetailsDTO;
import com.prizy.pricer.repository.ProductViewerRepository;

@RestController
public class ProductViewerController {
	
	
	@Autowired
	public ProductViewerRepository viewProduct;
	
	@RequestMapping(value="/v1/listProduct",method=RequestMethod.GET,consumes= "application/json",produces="application/json")
	@ResponseBody
	public ResponseEntity<ApiGenricResponse<List<Product>>> productList(@RequestParam (value="barCode" ,  required = false) Integer barCode)
	{
		System.out.println("-----barCode--------"+barCode);
		ApiGenricResponse<List<Product>> response = new ApiGenricResponse<>();
		List<Product> listProduct;
		try {
			response.setApiStatus("success");
			listProduct=viewProduct.listProduct(barCode);
			response.setResponse(listProduct);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.setApiStatus("failed");
			response.setReason("Error while loading products");
			response.setResponse(null);
			return ResponseEntity.ok(response);
		}
	}
	
	@RequestMapping(value="/v1/{barCode}/productViewer",method=RequestMethod.GET,consumes= "application/json",produces="application/json")
	@ResponseBody
	public ResponseEntity<ApiGenricResponse<ProductDetailsDTO>> productViewer(@PathVariable("barCode") Integer barCode)
	{
		ApiGenricResponse<ProductDetailsDTO> response = new ApiGenricResponse<>();
		try {
			ProductDetailsDTO detailsDTO= viewProduct.productDetails(barCode);
			System.out.println(detailsDTO);
			response.setApiStatus("success");
			response.setResponse(detailsDTO);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.setApiStatus("failed");
			response.setReason("Error while loading products");
			response.setResponse(null);
			return ResponseEntity.ok(response);
		}
	}
}
