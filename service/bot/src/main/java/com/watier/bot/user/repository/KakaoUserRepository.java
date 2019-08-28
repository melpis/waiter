package com.watier.bot.user.repository;

import com.watier.bot.user.domain.KakaoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KakaoUserRepository extends JpaRepository<KakaoUser, Long> {

    List<KakaoUser> findByStoreId(Long storeId);

    KakaoUser findFirstByUserKey(String userKey);
}
