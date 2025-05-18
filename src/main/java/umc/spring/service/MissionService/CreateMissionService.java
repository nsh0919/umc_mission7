package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.missionStoreDTO.MissionStoreRequest;

public interface CreateMissionService {

    Mission createMission(MissionStoreRequest request);
}
