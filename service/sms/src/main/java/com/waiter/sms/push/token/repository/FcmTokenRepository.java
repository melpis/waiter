package com.waiter.sms.push.token.repository;

import com.waiter.sms.push.token.entity.FcmToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FcmTokenRepository extends JpaRepository<FcmToken, Long> {
    FcmToken findFirstByPhoneOrderByIdDesc(String phone);

    List<FcmToken> findByPhone(String phone);
}
