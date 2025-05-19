package umc.spring.web.dto.storeRegionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.Region;

@Getter
@RequiredArgsConstructor
public class StoreRegionRequest {
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private Long regionId;
}
