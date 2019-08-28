package com.waiter.reservation.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.annotation.PostConstruct;

@Component
public class BaseConverter {


    private ModelMapper modelMapper;

    @PostConstruct
    public void initMapper(){
        this.modelMapper = new ModelMapper();
    }

    public <T> T convert(Object from, Class<T> to) {
        return this.modelMapper.map(from, to);
    }

}
