package com.nvc.bookshop.mapper;

import com.nvc.bookshop.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

    Integer addGoodToCart(Cart cart);

    Integer updateCartByUserIdAndBookId(Cart cart);

    Cart findCartByUserIdAndBookId(Cart cart);

    List<Cart> findCartListByUserId(Integer userId);

    Integer updateCartById(Cart cart);

    Integer deleteCartById(Integer id);

    List<Cart> findCardListByIdsString(@Param("ids") List<Integer> ids);


}
