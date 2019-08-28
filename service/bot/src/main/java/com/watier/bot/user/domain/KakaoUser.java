package com.watier.bot.user.domain;

import com.watier.bot.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class KakaoUser extends BaseEntity {

    private String userKey;
    private Long storeId;

}
