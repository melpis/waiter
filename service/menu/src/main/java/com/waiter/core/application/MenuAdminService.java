package com.waiter.core.application;

import com.waiter.core.application.data.MenuCommand;
import com.waiter.core.domain.Menu;
import com.waiter.core.domain.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuAdminService {

    private MenuRepository menuRepository;

    public void create(MenuCommand menuCommand) {
        menuRepository.save(new Menu(menuCommand.getStoreId(), menuCommand.getName(), menuCommand.getPrice(), menuCommand.getDescription(), menuCommand.getImagePath()));
    }

    public void update(MenuCommand menuCommand) {
        menuRepository
                .findById(menuCommand.getId())
                .ifPresent(menu -> {
                    menuRepository.save(menu.update(menuCommand));
                });
    }

    public void delete(Long menuId) {
        menuRepository
                .findById(menuId)
                .ifPresent(menuRepository::delete);
    }

    public List<MenuCommand> getMenusByStoreId(Long storeId) {
        return menuRepository
                .findByStoreId(storeId)
                .stream()
                .map(menu -> {
                    return new MenuCommand(menu.getId(), menu.getStoreId(), menu.getName(), menu.getPrice(), menu.getDescription(), menu.getImagePath());
                })
                .collect(Collectors.<MenuCommand> toList());
    }
}
