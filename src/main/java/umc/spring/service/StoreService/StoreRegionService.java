package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.web.dto.storeRegionDTO.StoreRegionRequest;

public interface StoreRegionService {

    Store createStore(StoreRegionRequest request);

}
