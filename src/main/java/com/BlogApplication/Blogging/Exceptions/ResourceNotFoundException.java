package com.BlogApplication.Blogging.Exceptions;

import lombok.Data;
import lombok.Getter;

@Getter
@Data

public class ResourceNotFoundException extends RuntimeException
{
    String ResourceName;
    String ResourceType;
    long fieldValue;

    public ResourceNotFoundException(String resourceName,String resourceType,long fieldValue) {
        super(String.format("Resource %s not found with userId " +" "+fieldValue, resourceName));
        this.ResourceType = resourceType;
        this.ResourceName = resourceName;
        this.fieldValue = fieldValue;
    }
}
