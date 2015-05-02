package com.asanka.jdbc.spring.model;

import java.io.Serializable;

public class ProductLine implements Serializable {

	private static final long serialVersionUID = -297281108114530801L;
	
	private String productLine;
	private String textDescription;
	
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getTextDescription() {
		return textDescription;
	}
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
}
