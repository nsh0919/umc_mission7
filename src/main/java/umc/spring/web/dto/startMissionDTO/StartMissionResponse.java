package umc.spring.web.dto.startMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;

public class StartMissionResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class memberMissionDTO {

        private Long id;
        private MissionStatus status;
        private Long memberId;
        private Long missionId;

    }
}
