package com.waiter.core.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

        List<Menu> findByStoreId(Long storeId);
}
