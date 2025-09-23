package com.embx.EmbarkX.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    //    @Query("SELECT * FROM REVIEWS WHERE COMPANY_ID:=companyId")
    List<Reviews> findAllByCompanyId(Long companyId);
}
