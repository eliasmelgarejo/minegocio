package com.minegocio.core;

import java.io.Serializable;

public interface IWrapperDto<BaseDto extends Serializable> {

	Object convertToDto(BaseDto dto);    
	BaseDto convertToEntity(Object o);
}
