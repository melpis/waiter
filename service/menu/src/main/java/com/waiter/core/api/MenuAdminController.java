package com.waiter.core.api;

import com.waiter.config.SessionContext;
import com.waiter.core.application.MenuAdminService;
import com.waiter.core.application.data.MenuCommand;
import com.waiter.core.domain.Menu;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MenuAdminController {

    private MenuAdminService menuAdminService;

    @PostMapping("/menu")
    public void create(@RequestBody MenuCommand menuCommand) {
        menuAdminService.create(menuCommand);
    }

    @PutMapping("/menu/{id}")
    public void update(@PathVariable(value = "id") Long menuId, @RequestBody MenuCommand menuCommand) {
        menuAdminService.update(menuCommand);
    }

    @DeleteMapping("/menu/{id}")
    public void delete(@PathVariable(value = "id") Long menuId) {
        menuAdminService.delete(menuId);
    }

    // 인증테스트용
    @GetMapping("/admin/menu")
    public String hello(){
        SessionContext sessionContext = (SessionContext) SecurityContextHolder.getContext().getAuthentication();
        System.out.println(sessionContext.getId());
        return "hello";
    }

    @GetMapping("/menus/save/test")
    public List<Menu> saveTestMenu() {
        MenuCommand menu1 = new MenuCommand(null, 1L, "원조선지해장국", 7000, "정말 맛있어요. 사골로 우려 냈음", "/static/images/1.png");
        MenuCommand menu2 = new MenuCommand(null, 1L, "순대국", 6500, "와! 한번 맛보면 잊을수 없는맛. 바로그 사골순대국", "/static/images/2.png");
        MenuCommand menu3 = new MenuCommand(null, 1L, "순두부찌게", 8000, "초당 순두부 보다 맛있어요.", "/static/images/3.png");
        MenuCommand menu4 = new MenuCommand(null, 1L, "육개장", 7000, "얼큰한 맛이 일품인 육개장", "/static/images/4.png");
        MenuCommand menu5 = new MenuCommand(null, 1L, "얼큰짱뽕", 7500, "얼큰한 맛이 해장에 최고", "/static/images/5.png");
        MenuCommand menu6 = new MenuCommand(null, 1L, "부대찌게", 8000, "건강한 재료로 엄선해서 만든 부대찌게", "/static/images/6.png");

        menuAdminService.create(menu1);
        menuAdminService.create(menu2);
        menuAdminService.create(menu3);
        menuAdminService.create(menu4);
        menuAdminService.create(menu5);
        menuAdminService.create(menu6);
        return null;
    }
}
