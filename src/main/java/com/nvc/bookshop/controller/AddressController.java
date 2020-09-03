package com.nvc.bookshop.controller;

import com.nvc.bookshop.pojo.Address;
import com.nvc.bookshop.pojo.User;
import com.nvc.bookshop.service.AddressService;
import com.nvc.bookshop.utils.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ResponseBody
    @PostMapping("/save")
    public ServerMessage saveAddress(Address address, HttpSession session) {
        User user = (User) session.getAttribute("user");
        address.setUser_id(user.getId());
        Integer integer = addressService.handleSaveAddress(address);
        if (integer > 0) {
            return ServerMessage.success().message("添加地址成功！");
        } else {
            return ServerMessage.error().message("添加地址失败！");
        }
    }

}
