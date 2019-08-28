package com.watier.bot.core.content.context.repository;


import com.watier.bot.core.content.context.domain.UserContext;
import com.watier.bot.user.domain.KakaoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserContextRepository extends JpaRepository<UserContext, String> {
    List<UserContext> findByKakaoUserOrderById(KakaoUser kakaoUser);
    List<UserContext> findByKakaoUserIn(List<KakaoUser> kakaoUsers);
    List<UserContext> findByKakaoUser(KakaoUser kakaoUser);
}