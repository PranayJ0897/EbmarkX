package com.embx.EmbarkX.reviews.impl;

import com.embx.EmbarkX.companies.CompanyRepository;
import com.embx.EmbarkX.reviews.Reviews;
import com.embx.EmbarkX.reviews.ReviewsRepository;
import com.embx.EmbarkX.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsServiceImp implements ReviewsService {

    CompanyRepository companyRepository;

    ReviewsRepository reviewsRepository;


    public ReviewsServiceImp(CompanyRepository companyRepository, ReviewsRepository reviewsRepository) {
        this.companyRepository = companyRepository;
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public List<Reviews> findAll(Long companyId) {
        return reviewsRepository.findAllByCompanyId(companyId);
    }

    @Override
    public String createReview(Long companyId, Reviews reviews) {
        if (companyRepository.existsById(companyId)) {
            //company found review can be created
            reviewsRepository.save(reviews);
            return "Review added successfully!";
        } else {
            return "Company not found!";
        }
    }

    @Override
    public Reviews findById(Long companyId, Long reviewId) {
        if (companyRepository.existsById(companyId)) {
            //company found review can be created
            Optional<Reviews> reviewsOptional = reviewsRepository.findById(reviewId);
            return reviewsOptional.orElse(null);
        } else {
            return null;
        }

    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews reviews) {
        if (companyRepository.existsById(companyId)) {
            Optional<Reviews> reviewsOptional = reviewsRepository.findById(reviewId);
            if (reviewsOptional.isPresent()) {
                Reviews reviewsUpdated = reviewsOptional.get();
                reviewsUpdated.setTitle(reviews.getTitle());
                reviewsUpdated.setDescription(reviews.getDescription());
                reviewsRepository.save(reviewsUpdated);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteReviews(Long companyId, Long reviewId) {
        if (companyRepository.existsById(companyId)) {
            reviewsRepository.deleteById(reviewId);
            return true;
        } else {
            return false;
        }
    }
}
