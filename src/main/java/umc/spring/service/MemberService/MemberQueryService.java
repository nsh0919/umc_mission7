package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

public interface MemberQueryService {
    public Page<MemberMission> getMyMissionList(Long memberId, Integer page);

}
