package com.ems.handler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
/**
 * 
 * @author dev
 *
 */
    @Component
    public class ModelMapperUtil extends ModelMapper{
        public ModelMapperUtil() {       
        this.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        }   
    }