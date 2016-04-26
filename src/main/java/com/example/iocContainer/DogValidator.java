package com.example.iocContainer;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Administrator on 2016/3/30.
 */
public class DogValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return Dog.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        Dog dog = (Dog) o;
        if(dog.getWeight()<1){
            errors.reject("weight","too small");
        }else if(dog.getWeight()>100){
            errors.reject("weight","too big");
        }
    }
}
