package com.ecom.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductLine {
	
	private Long productID;
	private String productName;
	private Integer quantity;

}
