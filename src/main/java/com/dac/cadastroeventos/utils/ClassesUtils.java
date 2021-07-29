package com.dac.cadastroeventos.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

@Component
public class ClassesUtils {

/*
Funciona se campos declarados de deObject e paraObject tiverem os mesmos nomes
*/
    public <T, R> R fazDePara(T deObject, R paraObject) {

        Arrays.stream(paraObject.getClass().getDeclaredFields())
                .forEach(f-> {
                    String paraClasseCampoNome = f.getName();
                    try {
                        Field deClasseCampo = deObject.getClass().getDeclaredField(paraClasseCampoNome);
                        deClasseCampo.setAccessible(true);
                        f.setAccessible(true);
                        f.set(paraObject, deClasseCampo.get(deObject));

                    } catch (NoSuchFieldException ignored) {

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return paraObject;
    }
}
