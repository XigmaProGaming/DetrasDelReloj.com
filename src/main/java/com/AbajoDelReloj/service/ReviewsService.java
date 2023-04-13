package com.AbajoDelReloj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.AbajoDelReloj.model.Reviews;
import com.AbajoDelReloj.repository.ReviewsRepository;



@Service
public class ReviewsService {

   
    private final ReviewsRepository reviewsRepository;
    @Autowired
    
	public ReviewsService (ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;
	}
    
    
   /* public void crearReviews(Reviews review) {
		//Necesitamos saber si el producto buscado existe, SI EXISTE lo ponemos dentro del optional
		Optional<Reviews> reviewBuscado =
				reviewsRepository.findById(review.getIdReview()); //buscamos por ID*/
		
    public Reviews crearReviews(Reviews review) {
        return reviewsRepository.save(review);
    }

    public List <Reviews> obtenerReviews() {
        return reviewsRepository.findAll();
    }

    public Reviews obtenerReviewPorId(Long idreview) {
        return reviewsRepository.findById(idreview).orElse(null);
    }

    public void eliminarReview(Long idreview) {
        reviewsRepository.deleteById(idreview);
    }
}
