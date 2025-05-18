package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.StartMissionService;
import umc.spring.web.dto.startMissionDTO.StartMissionRequest;
import umc.spring.web.dto.startMissionDTO.StartMissionResponse;

import static umc.spring.converter.StartMissionConverter.toStartMissionDTO;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final StartMissionService startMissionService;

    @PostMapping("/stores/{store_id}/missions/challenge")
    public ApiResponse<StartMissionResponse.memberMissionDTO> startMission
            (@PathVariable("store_id") String store_id,
             @Valid @RequestBody StartMissionRequest request) {
        MemberMission mem_mission = startMissionService.startMission(request);
        StartMissionResponse.memberMissionDTO startMissionDTO = toStartMissionDTO(mem_mission);

        return ApiResponse.onSuccess(startMissionDTO);
    }

}
