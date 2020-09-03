package com.nvc.bookshop.controller;

import com.nvc.bookshop.pojo.Cart;
import com.nvc.bookshop.pojo.User;
import com.nvc.bookshop.pojo.UserCartVo;
import com.nvc.bookshop.service.CartService;
import com.nvc.bookshop.utils.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车控制器
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    @ResponseBody
    public ServerMessage addCart(Cart cart, HttpSession session) {

        // 判断用户id
        if (cart.getUser_id() == null) {
            User user = (User) session.getAttribute("user");
            if (user == null) {
                return ServerMessage.error().message("用户未登录");
            } else {
                cart.setUser_id(user.getId());
            }
        }
        System.out.println("====> " + cart);
        return cartService.handleSaveCart(cart);
    }

    @GetMapping("/list")
    public String cartList(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Cart> cartList = cartService.getCartListByUserId(user.getId());
            UserCartVo userCartVo = cartService.getUserCartVo(cartList);
            model.addAttribute("cardList", cartList);
            session.setAttribute("userCartVo", userCartVo);
        }
        return "cart";
    }

    @PostMapping("/updateCart")
    @ResponseBody
    public ServerMessage updateCart(Cart cart, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ServerMessage.error().message("用户未登录");
        }
        ServerMessage sm = cartService.updateCartById(cart);
        if (sm.getCode() == 200) {
            return sm;
        }
        List<Cart> cartList = cartService.getCartListByUserId(user.getId());
        UserCartVo userCartVo = cartService.getUserCartVo(cartList);
        sm.addData("userCartVo", userCartVo);
        session.setAttribute("userCartVo", userCartVo);
        return sm;
    }

    @GetMapping("/delete")
    @ResponseBody
    public ServerMessage cartDelete(String ids) {
        try {
            Integer integer = cartService.batchDeleteCarts(ids);
            if (integer > 0) {
                return ServerMessage.success().message("商品删除成功");
            }
            return ServerMessage.error().message("商品删除失败");
        } catch (RuntimeException e) {
            return ServerMessage.error().message("商品删除失败");
        }
    }
}
