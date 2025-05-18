package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.startMissionDTO.StartMissionRequest;
import umc.spring.web.dto.startMissionDTO.StartMissionResponse;

@Component
public class StartMissionConverter {

    public static MemberMission toMemberMission(StartMissionRequest request, Member member, Mission mission) {

        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .member(member)
                .mission(mission)
                .build();
    }

    public static StartMissionResponse.memberMissionDTO toStartMissionDTO(MemberMission memberMission) {

        return StartMissionResponse.memberMissionDTO.builder()
                .id(memberMission.getId())
                .status(memberMission.getStatus())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }


}
