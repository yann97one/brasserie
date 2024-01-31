package com.example.beer2.controller.converter;
import com.example.beer2.bo.TypeBiere;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToTypeBiereConverter implements Converter<String, TypeBiere> {



    @Override
    public TypeBiere convert(String source) {

        return TypeBiere.valueOf(source);
    }


}
