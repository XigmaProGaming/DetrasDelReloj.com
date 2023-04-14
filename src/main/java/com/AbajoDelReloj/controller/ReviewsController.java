package com.AbajoDelReloj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.AbajoDelReloj.model.Reviews;
import com.AbajoDelReloj.service.ReviewsService;


import java.util.List;
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
@RestController
@RequestMapping("/abdr/reviews/")
public class ReviewsController {

    @Autowired
    private final ReviewsService reviewService;

    @PostMapping
    public ResponseEntity<Reviews> crearReview(@RequestBody Reviews reviews) {
        Reviews crearReview = reviewService.crearReviews(reviews);
        return new ResponseEntity<>(crearReview, HttpStatus.CREATED);
    }
    
	public ReviewsController (ReviewsService reviewService) {
		this.reviewService = reviewService;
	}
    
    

    @GetMapping
    public ResponseEntity<List<Reviews>> obtenerReviews() {
        List<Reviews> reviews = reviewService.obtenerReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id_review}")
    public ResponseEntity<Reviews> obtenerReviewPorId(@PathVariable Long id_review) {
        Reviews reviews = reviewService.obtenerReviewPorId(id_review);
        //Si es nula, significa que no se encontró ninguna Review con el identificador proporcionado y, por lo tanto, se devuelve una ResponseEntity con el código de estado HTTP 404 (NOT FOUND).
        if (reviews == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @DeleteMapping("/{id_review}")
    public ResponseEntity<Void> eliminarReview(@PathVariable Long id_review) {
        reviewService.eliminarReview(id_review);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}