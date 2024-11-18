package go.backend_go.service;

import go.backend_go.dtos.memberLike.memberLikeViewDto;
import go.backend_go.entity.Member;
import go.backend_go.entity.Place;
import go.backend_go.entity.User_Like;
import go.backend_go.repository.MemberLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberLikeService {

    private final MemberLikeRepository memberLikeRepository;


    public memberLikeViewDto addLike(Member findMember, Place findPlace) {
        User_Like userLike = new User_Like(findMember, findPlace);

        findMember.getPlace_like_member().add(userLike);
        findPlace.getPlace_like_member().add(userLike);
        findPlace.likePlace();

        memberLikeRepository.save(userLike);

        memberLikeViewDto returnDto = new memberLikeViewDto(findMember, findPlace);

        return returnDto;
    }

    public memberLikeViewDto deleteLike(Member findMember, Place findPlace){

        User_Like userLike = memberLikeRepository.findByUserNameAndPlaceName(findMember.getId(), findPlace.getId());

        findMember.getPlace_like_member().remove(userLike);
        findPlace.getPlace_like_member().remove(userLike);

        findPlace.unlikePlace();

        memberLikeRepository.delete(userLike);

        memberLikeViewDto returnDto = new memberLikeViewDto(findMember, findPlace);

        return returnDto;
    }
}
