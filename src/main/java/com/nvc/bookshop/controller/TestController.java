package com.nvc.bookshop.controller;

import com.nvc.bookshop.pojo.Test;
import com.nvc.bookshop.utils.ServerMessage;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ServerMessage test(@Validated Test test, BindingResult result) {
        boolean b = result.hasErrors();
        ServerMessage serverMessage = ServerMessage.success();
        serverMessage.addData("hasError",b);
        return serverMessage;
    }
}
