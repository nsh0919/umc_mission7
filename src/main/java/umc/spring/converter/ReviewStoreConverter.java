package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.addReviewtoStoreDTO.ReviewStoreRequest;
import umc.spring.web.dto.addReviewtoStoreDTO.ReviewStoreResponse;

@Component
public class ReviewStoreConverter {

    public static Review toReview (ReviewStoreRequest request, Member member, Store store) {

        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewStoreResponse.ReviewDTO toReviewDTO (Review review) {

        return ReviewStoreResponse.ReviewDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .memberName(review.getMember().getName())
                .storeName(review.getStore().getName())
                .build();

    }



}
