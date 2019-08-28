package com.waiter.reservation.converter;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class BaseConverter {

    private ModelMapper modelMapper;

    @PostConstruct
    public void initMapper() {
        this.modelMapper = new ModelMapper();
    }

    public <T> T convert(Object from, Class<T> to) {

        log.info("convert from : " + from.getClass().getName() + " to : " + to.getName());
        return this.modelMapper.map(from, to);
    }

}
