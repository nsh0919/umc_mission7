package umc.spring.web.dto.startMissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StartMissionRequest {

    @NotNull
    private Long memberId;
    @NotNull
    private Long missionId;

}
