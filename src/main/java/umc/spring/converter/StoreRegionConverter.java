package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.storeRegionDTO.StoreRegionRequest;
import umc.spring.web.dto.storeRegionDTO.StoreRegionResponse;

@Component
public class StoreRegionConverter {

    public static Store toStore (StoreRegionRequest request, Region region) {

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }

    public static StoreRegionResponse.createStoreDTO toCreateStoreDTO (Store store) {

        return StoreRegionResponse.createStoreDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionId(store.getRegion().getId())
                .build();
    }

}
