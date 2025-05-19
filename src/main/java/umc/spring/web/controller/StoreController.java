package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreRegionService;
import umc.spring.web.dto.storeRegionDTO.StoreRegionRequest;
import umc.spring.web.dto.storeRegionDTO.StoreRegionResponse;

import static umc.spring.converter.StoreRegionConverter.toCreateStoreDTO;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private StoreRegionService storeRegionService;

    @PostMapping("/regions/{region_id}/stores")
    public ApiResponse<StoreRegionResponse.createStoreDTO> createStore
            (@PathVariable("region_id") String regionId,
             @Valid @RequestBody StoreRegionRequest request) {
        Store newStore = storeRegionService.createStore(request);
        StoreRegionResponse.createStoreDTO storeDTO = toCreateStoreDTO(newStore);

        return ApiResponse.onSuccess(storeDTO);

    }

}
