package com.waiter.store.store.service;

import com.waiter.store.store.model.StoreModel;
import com.waiter.store.store.repository.StoreRepository;
import hsim.checkpoint.util.ValidationObjUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final @NonNull
    StoreRepository storeRepository;

    @Override
    public StoreModel getStore(Long id) {
        return ValidationObjUtil.objectDeepCopyWithBlackList(this.storeRepository.findById(id).get(), StoreModel.class);
    }
}
