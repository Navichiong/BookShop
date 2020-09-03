package com.nvc.bookshop.service;

import com.nvc.bookshop.pojo.Cart;
import com.nvc.bookshop.pojo.UserCartVo;
import com.nvc.bookshop.utils.ServerMessage;

import java.util.List;

public interface CartService {

    ServerMessage handleSaveCart(Cart cart);

    ServerMessage addToCart(Cart cart);

    ServerMessage updateCartByUserIdAndBookId(Cart cart);

    List<Cart> getCartListByUserId(Integer userId);

    UserCartVo getUserCartVo(List<Cart> carts);

    ServerMessage updateCartById(Cart cart);

    Integer batchDeleteCarts(String ids);

    Integer deleteCartById(Integer id);

    List<Cart> findCartListByIdsStr(String ids);

    List<UserCartVo> getUserCartVos(List<Cart> carts);

}
