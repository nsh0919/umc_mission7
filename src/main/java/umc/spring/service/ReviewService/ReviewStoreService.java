package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.addReviewtoStoreDTO.ReviewStoreRequest;

public interface ReviewStoreService {

    Review createReview(ReviewStoreRequest request);

}
