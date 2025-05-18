package umc.spring.web.dto.addReviewtoStoreDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.CheckStore;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReviewStoreRequest {

    @NotNull
    private String title;
    @NotNull
    private Float score;
    @NotNull
    private Long memberId;
    @CheckStore
    private Long storeId;
}
