package umc.spring.web.dto.missionStoreDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
public class MissionStoreRequest {

    @NotNull
    private Integer reward;
    @NotNull
    private LocalDate deadline;
    @NotNull
    private String missionSpec;
    @NotNull
    private Long storeId;

}
