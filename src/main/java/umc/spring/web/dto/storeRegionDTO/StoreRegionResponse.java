package umc.spring.web.dto.storeRegionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Region;

public class StoreRegionResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createStoreDTO {

        private Long id;
        private String name;
        private String address;
        private Long regionId;
    }

}
