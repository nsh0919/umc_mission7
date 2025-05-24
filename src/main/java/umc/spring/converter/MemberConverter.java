package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MemberMissionPreViewDTO memberMissionPreViewDTO(MemberMission memberMission) {
        return MemberResponseDTO.MemberMissionPreViewDTO.builder()
                .missionId(memberMission.getId())
                .memberName(memberMission.getMember().getName())
                .storeName(memberMission.getMission().getStore().getName())
                .reward(memberMission.getMission().getReward())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();
    }

    public static MemberResponseDTO.MemberMissionPreViewListDTO memberMissionPreViewListDTO(Page<MemberMission> missionList) {

        List<MemberResponseDTO.MemberMissionPreViewDTO> memberMissionPreViewDTOList = missionList.stream()
                .map(MemberConverter::memberMissionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MemberMissionPreViewListDTO.builder()
                .missionList(memberMissionPreViewDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionList.getSize())
                .build();
    }

}
