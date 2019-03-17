package com.prizy.pricer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.pricer.dto.ApiGenricResponse;
import com.prizy.pricer.dto.ProductLoaderDTO;
import com.prizy.pricer.repository.ProductRepository;

@RestController
public class ProductLoaderController {
	
	@Autowired
	public ProductRepository loaderService;
	
	@RequestMapping(value="/v1/productLoader",method=RequestMethod.POST,consumes= "application/json",produces="application/json")
	@ResponseBody
	public ResponseEntity<ApiGenricResponse<Boolean>> productLoader(@Valid @RequestBody ProductLoaderDTO loaderDTO)
	{
		ApiGenricResponse<Boolean> response = new ApiGenricResponse<>();
		try {
			if (loaderService.isProductExist(loaderDTO.getBarCode())) {
				if (!loaderService.searchProductDetails(loaderDTO.getBarCode(), loaderDTO.getStore())) {
					if (loaderService.insertProductDetails(loaderDTO)) {
						response.setApiStatus("success");
						response.setResponse(new Boolean(true));
						return ResponseEntity.ok(response);
					} else {
						response.setApiStatus("failed");
						response.setReason("Product insertion failed");
						response.setResponse(new Boolean(false));
						return ResponseEntity.ok(response);
					}
				} else {
					response.setApiStatus("failed");
					response.setReason("Product alrady entered");
					response.setResponse(new Boolean(false));
					return ResponseEntity.ok(response);
				}
			} else {
				response.setApiStatus("failed");
				response.setReason("Product does not exist in Product list");
				response.setResponse(new Boolean(false));
				return ResponseEntity.ok(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setApiStatus("failed");
			response.setResponse(new Boolean(false));
			return ResponseEntity.ok(response);
		}
	}
		
}
