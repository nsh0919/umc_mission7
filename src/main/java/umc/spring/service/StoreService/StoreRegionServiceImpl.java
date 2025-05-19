package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreRegionConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.storeRegionDTO.StoreRegionRequest;

@Service
@RequiredArgsConstructor
public class StoreRegionServiceImpl implements StoreRegionService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Store createStore(StoreRegionRequest request){

        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RuntimeException("식당 없음"));

        Store newStore = StoreRegionConverter.toStore(request,region);
        return storeRepository.save(newStore);
    }
}
