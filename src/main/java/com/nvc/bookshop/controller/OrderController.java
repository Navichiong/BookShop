package com.nvc.bookshop.controller;

import com.nvc.bookshop.pojo.Address;
import com.nvc.bookshop.pojo.Cart;
import com.nvc.bookshop.pojo.Order;
import com.nvc.bookshop.pojo.User;
import com.nvc.bookshop.pojo.UserCartVo;
import com.nvc.bookshop.service.AddressService;
import com.nvc.bookshop.service.CartService;
import com.nvc.bookshop.service.OrderService;
import com.nvc.bookshop.utils.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/toOrderPage")
    public String toOrderPage(String ids, Model model, HttpSession session) {
        List<Cart> cartList = cartService.findCartListByIdsStr(ids);
        UserCartVo userCartVo = cartService.getUserCartVo(cartList);

        User user = (User) session.getAttribute("user");
        List<Address> addressList = addressService.getAddressesByUserId(user.getId());

        model.addAttribute("addressList", addressList);
        model.addAttribute("cartList", cartList);
        model.addAttribute("userCartVo", userCartVo);
        session.setAttribute("readyCommitCartList", cartList);

        return "confirm_order";
    }

    @GetMapping("/commit")
    @ResponseBody
    public ServerMessage commitOrder(Integer addressId, HttpSession session) {
        List<Cart> cartList = (List<Cart>) session.getAttribute("readyCommitCartList");
        User user = (User) session.getAttribute("user");
        boolean b = orderService.buy(cartList, addressId, user.getId());
        if (b) {
            return ServerMessage.success().message("订单提交成功！");
        } else {
            return ServerMessage.error().message("订单提交失败！");
        }
    }

    @GetMapping("/list")
    public String toOrderListPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Order> orderList = orderService.findOderListByUserId(user.getId());
        model.addAttribute("orderList", orderList);
        return "order_list";
    }

    @GetMapping("/totalPrice")
    @ResponseBody
    public ServerMessage getOrderTotalPrice(Order order) {
        Double price = orderService.getSignalOrderPrice(order);
        if (price != null) {
            return ServerMessage.success().message("计算单个订单总金额成功！").addData("totalPrice", price);
        }
        return ServerMessage.error().message("计算单个订单总金额失败！");
    }
}
