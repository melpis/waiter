package com.waiter.store.store.controller;

import com.waiter.store.store.model.StoreModel;
import com.waiter.store.store.service.StoreService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final @NonNull
    StoreService storeService;

    @GetMapping("{id}")
    public StoreModel getStore(@PathVariable Long id) {
        return this.storeService.getStore(id);
    }

/*
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getPartner(@PathVariable Long id) {

        StoreModel partnerModel = null;
        if (id == 1) {
            partnerModel = new StoreModel(1, "쓰부", "경기도 용인시 수지구 죽전로168번길 29 ", "010-2121-2345", "09:00", "23:00",
                    "08:00", "22:00", 20, "단대앞 중국집");
        } else if (id == 2) {
            partnerModel = new StoreModel(2, "해피덮", "경기도 용인시 수지구 죽전동 1336-5 ", "010-2121-2345", "09:00", "23:00",
                    "08:00", "22:00", 70, "단대앞 덮밥");
        } else if (id == 3) {
            partnerModel = new StoreModel(3, "고수찜닭", "경기도 용인시 수지구 죽전로168번길 19", "010-2121-2345", "09:00", "23:00",
                    "08:00", "22:00", 10, "단대앞 찜닭");
        } else if (id == 4) {
            partnerModel = new StoreModel(4, "유가네닭갈비", "경기도 용인시 수지구 죽전로144번길 12-6", "010-2121-2345", "09:00", "23:00",
                    "08:00", "22:00", 30, "단대앞 닭갈비");
        } else {
            partnerModel = new StoreModel();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        String partnerStr = null;
        try {
            partnerStr = objectMapper.writeValueAsString(partnerModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return partnerStr;
    }*/

}
