package com.watier.bot.user.component;

import com.watier.bot.core.content.context.repository.UserContextRepository;
import com.watier.bot.user.domain.KakaoUser;
import com.watier.bot.user.repository.KakaoUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDataComponent {

    private final @NonNull
    KakaoUserRepository kakaoUserRepository;
    private final @NonNull
    UserContextRepository userContextRepository;

    public void deleteUser(KakaoUser kakaoUser) {
        this.userContextRepository.deleteAll(this.userContextRepository.findByKakaoUser(kakaoUser));
        this.kakaoUserRepository.delete(kakaoUser);
    }
    public void cleanlUserFromSoreId(Long id) {
        List<KakaoUser> users = this.kakaoUserRepository.findByStoreId(id);

        if (!users.isEmpty()) {
            this.userContextRepository.deleteAll(this.userContextRepository.findByKakaoUserIn(users));
            this.kakaoUserRepository.deleteAll(users);
        }
    }

}
