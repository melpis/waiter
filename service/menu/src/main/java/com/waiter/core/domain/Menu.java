package com.waiter.core.domain;

import com.waiter.core.application.data.MenuCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter // 임시 허용
    private Long id;

    private Long storeId;

    private String name;

    private int price;

    private String imagePath;

    private String description;

    public Menu(Long storeId, String name, int price, String description, String imagePath) {
        Assert.notNull(name, "require name");
        this.storeId = storeId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Menu update(MenuCommand menuCommand) {
        this.name = menuCommand.getName();
        this.price = menuCommand.getPrice();
        this.description = menuCommand.getDescription();

        return this;
    }
}
