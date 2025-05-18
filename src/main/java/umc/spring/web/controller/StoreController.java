package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewStoreService;
import umc.spring.web.dto.addReviewtoStoreDTO.ReviewStoreRequest;
import umc.spring.web.dto.addReviewtoStoreDTO.ReviewStoreResponse;

import static umc.spring.converter.ReviewStoreConverter.toReviewDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final ReviewStoreService reviewStoreService;

    @PostMapping("/{store_id}/reviews")
    public ApiResponse<ReviewStoreResponse.ReviewDTO> addReview(
            @PathVariable("store_id") Long storeId,
            @Valid @RequestBody ReviewStoreRequest request)
    {
        Review review = reviewStoreService.createReview(request);
        ReviewStoreResponse.ReviewDTO reviewDTO = toReviewDTO(review);
        return ApiResponse.onSuccess(reviewDTO);
    }
}
