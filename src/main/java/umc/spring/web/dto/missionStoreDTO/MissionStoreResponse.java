package umc.spring.web.dto.missionStoreDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionStoreResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createMissionDTO {

        private Long id;
        private Integer reward;
        private LocalDate deadline ;
        private String missionSpec;
        private Long storeId;

    }
}
