package com.waiter.core.application.data;

import lombok.Value;

@Value
public class MenuCommand {

    private Long id;

    private Long storeId;

    private String name;

    private int price;

    private String description;

    private String imagePath;
}
