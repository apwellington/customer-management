package com.example.customermanagement.util;

import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wellington Adames on 07/08/2021
 */
public class GenericMapper {

    public static  <T, R> R map(T t, Class<R> rClass, ModelMapper mapper){
        R r = mapper.map(t, rClass);
        return r;
    }

    public static  <T, R> List<R> mapCollection(List<T> t, Class<R> rClass, ModelMapper mapper){
        return t.stream().map(item -> mapper.map(item, rClass)).collect(Collectors.toList());
    }
}
