package com.waiter.core.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Category {

    @Id
    private Long id;

    private String name;
}
