package com.watier.bot.core.content.context.domain;

import com.watier.bot.common.BaseEntity;
import com.watier.bot.user.domain.KakaoUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class UserContext extends BaseEntity {

    @ManyToOne
    private KakaoUser kakaoUser;

    private String content;
}