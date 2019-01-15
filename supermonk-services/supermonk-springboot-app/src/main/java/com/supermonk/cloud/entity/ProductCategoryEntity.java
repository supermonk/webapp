package com.supermonk.cloud.entity;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

public class ProductCategoryEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", updatable = false, nullable = false)
	private String productId;

	@OneToOne
	@JoinColumn(name = "productId", referencedColumnName = "id", nullable = false, updatable = true, foreignKey = @ForeignKey(name = "fkProduct"))
	private ProductEntity productEntity;

	@OneToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "id", nullable = false, updatable = true, foreignKey = @ForeignKey(name = "fkCategory"))
	private CategoryEntity categoryEntity;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

}
