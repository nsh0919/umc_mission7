package umc.spring.web.dto.addReviewtoStoreDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewStoreResponse {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewDTO {
        public Long id;
        public String title;
        public Float score;
        public String memberName;
        public String storeName;
    }
}
