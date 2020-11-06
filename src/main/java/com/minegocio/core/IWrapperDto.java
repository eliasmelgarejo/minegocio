package com.minegocio.core;

import java.io.Serializable;

public interface IWrapperDto<T extends Serializable> {

// wrapper dto/entity    
    BaseDto convertToDto(T t);    
    T convertToEntity(BaseDto dto);
}
