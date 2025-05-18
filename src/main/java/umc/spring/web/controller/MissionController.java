package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.CreateMissionService;
import umc.spring.web.dto.missionStoreDTO.MissionStoreRequest;
import umc.spring.web.dto.missionStoreDTO.MissionStoreResponse;

import static umc.spring.converter.MissionStoreConverter.toMissionDTO;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final CreateMissionService createMissionService;

    @PostMapping("/stores/{store_id}/missions")
    public ApiResponse<MissionStoreResponse.createMissionDTO> createMission
            (@PathVariable("store_id") String storeId,
             @Valid @RequestBody MissionStoreRequest request) {
        Mission newMission = createMissionService.createMission(request);
        MissionStoreResponse.createMissionDTO missionDTO = toMissionDTO(newMission);

        return ApiResponse.onSuccess(missionDTO);
    }

}
