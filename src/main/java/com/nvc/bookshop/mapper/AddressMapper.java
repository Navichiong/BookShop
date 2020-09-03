package com.nvc.bookshop.mapper;

import com.nvc.bookshop.pojo.Address;

import java.util.List;

public interface AddressMapper {

    List<Address> findAddressesByUserId(Integer userId);

    Integer addAddress(Address address);

    Address findAddressById(Integer addressId);

}
