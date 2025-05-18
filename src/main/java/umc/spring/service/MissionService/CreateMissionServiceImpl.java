package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionStoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.StoreRepoy.MissionRepository;
import umc.spring.web.dto.missionStoreDTO.MissionStoreRequest;

@Service
@RequiredArgsConstructor
public class CreateMissionServiceImpl implements CreateMissionService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission createMission(MissionStoreRequest request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new RuntimeException("식당 없음"));

        Mission newMission = MissionStoreConverter.toMission(request,store);
        return missionRepository.save(newMission);
    }
}
