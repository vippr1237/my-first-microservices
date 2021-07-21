package com.ifisolution.bussiness_management.mapper;

import com.ifisolution.bussiness_management.dto.CustomerDto;
import com.ifisolution.bussiness_management.models.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    CustomerDto mapCustomerToDto(Customer customer);

    @InheritInverseConfiguration
    Customer mapProduct(CustomerDto customerDto);
}
