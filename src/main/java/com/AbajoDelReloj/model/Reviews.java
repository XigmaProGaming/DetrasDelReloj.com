package com.AbajoDelReloj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Long id_Review;

    @Column(name = "review")
    private String review;

    @Column(name = "valoracion")
    private Float valoracion;
    
    @Column(name = "products_idproducts")
    private Long products_idproducts;
    
    
    
    public Reviews() {

  		
  	}
//constructor
   

	public Reviews(Long idReview, String review, Float valoracion, Long products_idproducts) {
	
	this.id_Review = idReview;
	this.review = review;
	this.valoracion = valoracion;
	this.products_idproducts = products_idproducts;
}
	
	// getters y setters
	public Long getIdReview() {
		return id_Review;
	}
public void setIdReview(Long idReview) {
		this.id_Review = idReview;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Float getValoracion() {
		return valoracion;
	}

	public void setValoracion(Float valoracion) {
		this.valoracion = valoracion;
	}

	public Long getProducts_idproducts() {
		return products_idproducts;
	}


	@Override
	public String toString() {
		return "Reviews [id_Review=" + id_Review + ", review=" + review + ", valoracion=" + valoracion
				+ ", products_idproducts=" + products_idproducts + "]";
	}




	

    
 
    
    
}

