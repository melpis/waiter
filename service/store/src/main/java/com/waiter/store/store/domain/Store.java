package com.waiter.store.store.domain;

import com.waiter.store.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Store extends BaseEntity {
    private String storeName;

    private String addr;

    private String telNum;

    private String openTime; // HH: mm

    private String closeTime;

    private String waitStartTime;

    private String waitEndTime;

    private int estimatedMinute;

    private String description;
}
