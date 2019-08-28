package com.watier.bot.core.content.bean;

import com.watier.bot.core.content.context.domain.UserContext;
import com.watier.bot.core.content.context.repository.UserContextRepository;
import com.watier.bot.core.content.service.BotMenuService;
import com.watier.bot.core.model.BotRequestMessage;
import com.watier.bot.core.model.BotResponseMessage;
import com.watier.bot.core.type.BotMenu;
import com.watier.bot.user.domain.KakaoUser;
import com.watier.bot.user.repository.KakaoUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ContentContext {

    @Autowired
    private BotMenuService[] botMenuServiceList;

    @Autowired
    private UserContextRepository userContextRepository;

    @Autowired
    private KakaoUserRepository kakaoUserRepository;

    private Map<BotMenu, BotMenuService> contentServiceMap;

    @PostConstruct
    private void init() {
        this.contentServiceMap = new HashMap<>();
        Arrays.stream(this.botMenuServiceList).forEach(contentService -> {
            this.contentServiceMap.put(contentService.myMenu(), contentService);
        });
    }

    private List<String> pushUserContext(KakaoUser kakaoUser, BotRequestMessage botRequestMessage) {
        BotMenu botMenu = BotMenu.findByValue(botRequestMessage.getContent());
        if (botMenu != null) {
            List<UserContext> pastContexts = this.userContextRepository.findByKakaoUserOrderById(kakaoUser);
            this.userContextRepository.deleteAll(pastContexts);
        }

        UserContext userContext = new UserContext();
        userContext.setKakaoUser(kakaoUser);
        userContext.setContent(botRequestMessage.getContent());
        this.userContextRepository.save(userContext);

        return this.userContextRepository.findByKakaoUserOrderById(kakaoUser).stream().map(UserContext::getContent).collect(Collectors.toList());
    }

    public KakaoUser getKakaoUser(BotRequestMessage botRequestMessage) {
        KakaoUser user = this.kakaoUserRepository.findFirstByUserKey(botRequestMessage.getUser_key());
        if (user == null) {
            user = new KakaoUser();
            user.setUserKey(botRequestMessage.getUser_key());
            user = this.kakaoUserRepository.save(user);
        }

        return user;

    }

    public BotResponseMessage processsContentService(BotRequestMessage botRequestMessage) {
        KakaoUser kakaoUser = this.getKakaoUser(botRequestMessage);
        List<String> context = this.pushUserContext(kakaoUser, botRequestMessage);
        if (context.isEmpty()) {
            return null;
        }
        log.info("context size : " + context.size() + " " + Arrays.toString(context.toArray()));

        BotMenuService service = this.contentServiceMap.get(BotMenu.findByValue(context.get(0)));
        if (service != null && context.size() > 1) {
            for (int i = 1; i < context.size(); i++) {
                service = service.getChildService();
                if (service == null) {
                    log.info("context size is invalid : return top");
                    return null;
                }
            }
        }
        String lastContext = context.size() > 2 ? context.get(context.size() - 2) : null;
        assert service != null;
        return service.contentProcess(botRequestMessage, lastContext, context, kakaoUser);
    }

    public List<String> getContext(BotRequestMessage botRequestMessage) {
        KakaoUser kakaoUser = this.kakaoUserRepository.findFirstByUserKey(botRequestMessage.getUser_key());
        List<UserContext> contexts = this.userContextRepository.findByKakaoUserOrderById(kakaoUser);
        if (contexts.isEmpty()) {
            return new ArrayList<>();
        } else {
            return contexts.stream().map(UserContext::getContent).collect(Collectors.toList());
        }
    }

}
