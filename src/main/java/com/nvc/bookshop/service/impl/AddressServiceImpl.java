package com.nvc.bookshop.service.impl;

import com.nvc.bookshop.mapper.AddressMapper;
import com.nvc.bookshop.pojo.Address;
import com.nvc.bookshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddressesByUserId(Integer userId) {
        List<Address> addressList = new LinkedList<>();
        if (userId != null) {
            addressList = addressMapper.findAddressesByUserId(userId);
        }
        return addressList;
    }

    @Override
    public Integer handleSaveAddress(Address address) {
        return addressMapper.addAddress(address);
    }
}
