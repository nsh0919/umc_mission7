package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.missionStoreDTO.MissionStoreRequest;
import umc.spring.web.dto.missionStoreDTO.MissionStoreResponse;

@Component
public class MissionStoreConverter {

    public static Mission toMission(MissionStoreRequest request, Store store){

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionStoreResponse.createMissionDTO toMissionDTO(Mission mission){

        return MissionStoreResponse.createMissionDTO.builder()
                .id(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .storeId(mission.getStore().getId())
                .build();
    }


}
