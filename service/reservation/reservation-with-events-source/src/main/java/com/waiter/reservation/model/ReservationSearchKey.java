package com.waiter.reservation.model;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class ReservationSearchKey {

    private Long id;
    private Long userId;
    private Long storeId;

    private int page;
    private int size;
    private String order;
    private String field;


    private boolean isPageable() {
        return this.order != null && this.field != null && this.size > 0;
    }

    private boolean isDesc() {
        return (order != null && order.equalsIgnoreCase("desc"));
    }

    public Pageable pageable() {
        if (!isPageable()) {
            return null;
        }
        return PageRequest.of(this.page, this.size, this.isDesc() ? Sort.Direction.DESC : Sort.Direction.ASC, this.field);
    }

}
