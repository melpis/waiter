package com.waiter.core.api;

import com.waiter.core.application.MenuAdminService;
import com.waiter.core.application.data.MenuCommand;
import com.waiter.core.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MenuUserController {


    @Autowired
    private MenuAdminService menuAdminService;

    @GetMapping("menus/{storeId}")
    public List<MenuCommand> getMentus(@PathVariable(value = "storeId") Long storeId) {
        return menuAdminService.getMenusByStoreId(storeId);
    }
}
