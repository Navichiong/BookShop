package com.nvc.bookshop.service;

import com.nvc.bookshop.pojo.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAddressesByUserId(Integer userId);

    Integer handleSaveAddress(Address address);
}
