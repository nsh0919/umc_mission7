package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import static umc.spring.converter.MemberConverter.memberMissionPreViewDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/members/{memberId}/missions")
    @Operation(summary = "진행중인 미션 조회 API",description = "자신이 도전중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 진행중인 미션 status와 page 번호 필요함")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 아이디, path variable 입니다.")
    })
    public ApiResponse<MemberResponseDTO.MemberMissionPreViewListDTO> getMissionList(
            @PathVariable("memberId") Long memberId,
            @RequestParam("status") MissionStatus status,
            @ValidPage @RequestParam("page") Integer page) {

        Page<MemberMission> missionList = memberQueryService.getMyMissionList(memberId,page-1);

        return ApiResponse.onSuccess(MemberConverter.memberMissionPreViewListDTO(missionList));
    }

    @PatchMapping("/members/{memberId}/missions/{missionId}")
    @Operation(summary = "미션완료 상태 변경 API",description = "미션을 완료하여 미션 상태를 CHALLENGING에서 COMPLETE로 변경하는 API 입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 아이디, path variable 입니다."),
            @Parameter(name = "missionId", description = "미션 아이디, path variable 입니다.")
    })
    public ApiResponse<MemberResponseDTO.MemberMissionPreViewDTO> missionComplete(
            @PathVariable("memberId") Long memberId,
            @PathVariable("missionId") Long missionId,
            @RequestBody MemberRequestDTO.MissionCompleteRequestDTO request) {

        MemberMission memberMission = memberQueryService.missionComplete(memberId,missionId,request.getStatus());
        return ApiResponse.onSuccess(memberMissionPreViewDTO(memberMission));
    }

}
