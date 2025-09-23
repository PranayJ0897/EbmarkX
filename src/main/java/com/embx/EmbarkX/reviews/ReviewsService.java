package com.embx.EmbarkX.reviews;

import java.util.List;

public interface ReviewsService {

    List<Reviews> findAll(Long companyId);

    String createReview(Long companyId, Reviews reviews);

    Reviews findById(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Reviews reviews);

    boolean deleteReviews(Long companyId, Long reviewId);

}
