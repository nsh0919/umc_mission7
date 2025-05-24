package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getMyMissionList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> missionPage = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        return missionPage;
    }

    @Transactional
    @Override
    public MemberMission missionComplete(Long memberId, Long missionId, MissionStatus status) {
        Member member = memberRepository.findById(memberId).get();
        Mission mission = missionRepository.findById(missionId).get();
        MemberMission memberMission = memberMissionRepository.findByMemberAndMissionAndStatus(member, mission, MissionStatus.CHALLENGING);

        memberMission.setStatus(status);

        return memberMissionRepository.save(memberMission);
    }
}
