package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.startMissionDTO.StartMissionRequest;

public interface StartMissionService {

    MemberMission startMission(StartMissionRequest request);
}
