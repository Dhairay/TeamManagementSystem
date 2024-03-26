package com.wissen.tms.projectmanagement.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName,String fieldName,Integer fieldValue){
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=resourceName;
        this.fieldValue=fieldValue;
    }
}
