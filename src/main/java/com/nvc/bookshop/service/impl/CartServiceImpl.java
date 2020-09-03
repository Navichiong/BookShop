package com.nvc.bookshop.service.impl;

import com.nvc.bookshop.mapper.CartMapper;
import com.nvc.bookshop.pojo.Cart;
import com.nvc.bookshop.pojo.UserCartVo;
import com.nvc.bookshop.service.CartService;
import com.nvc.bookshop.utils.MyCollectionUtils;
import com.nvc.bookshop.utils.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public ServerMessage handleSaveCart(Cart cart) {

        Cart existCart = cartMapper.findCartByUserIdAndBookId(cart);
        // 判断是否曾经添加过购物车
        if (existCart == null) {
            return addToCart(cart);
        } else {
            existCart.setCount(existCart.getCount() + cart.getCount());
            return updateCartByUserIdAndBookId(existCart);
        }
    }

    @Override
    public ServerMessage addToCart(Cart cart) {
        Integer integer = cartMapper.addGoodToCart(cart);
        if (integer > 0) {
            return ServerMessage.success().message("添加购物车成功!");
        } else {
            return ServerMessage.error().message("添加购物车失败");
        }
    }

    @Override
    public ServerMessage updateCartByUserIdAndBookId(Cart cart) {
        Integer integer = cartMapper.updateCartByUserIdAndBookId(cart);
        if (integer > 0) {
            return ServerMessage.success().message("修改购物车成功!");
        } else {
            return ServerMessage.error().message("修改购物车失败");
        }
    }

    @Override
    public List<Cart> getCartListByUserId(Integer userId) {
        return cartMapper.findCartListByUserId(userId);
    }

    // 获取一个购物车中所有商品的总价和数量
    @Override
    public UserCartVo getUserCartVo(List<Cart> carts) {
        UserCartVo userCartVo = new UserCartVo();
        userCartVo.setNum(carts.size());
        userCartVo.setTotalPrice(getTotalPrice(carts));
        return userCartVo;
    }

    @Override
    public ServerMessage updateCartById(Cart cart) {
        Integer integer = cartMapper.updateCartById(cart);
        if (integer > 0) {
            return ServerMessage.success().message("修改购物车成功!");
        } else {
            return ServerMessage.error().message("修改购物车失败");
        }
    }

    @Override
    @Transactional
    public Integer batchDeleteCarts(String ids) {

        if (StringUtils.isEmpty(ids)) {
            return null;
        }
        String[] strings = ids.split(",");
        for (String string : strings) {
            int id = Integer.parseInt(string);
            Integer integer = this.deleteCartById(id);
            if (integer == null || integer < 0) {
                throw new RuntimeException("删除失败!");
            }
        }
        return 1;
    }

    @Override
    public Integer deleteCartById(Integer id) {
        return cartMapper.deleteCartById(id);
    }

    private Double getTotalPrice(List<Cart> carts) {
        double totalPrice = 0.0;
        if (!CollectionUtils.isEmpty(carts)) {
            for (Cart cart : carts) {
                totalPrice += (cart.getCount() * cart.getBook().getNew_price());
            }
        }
        return totalPrice;
    }

    @Override
    public List<Cart> findCartListByIdsStr(String ids) {

        List<Cart> list = new LinkedList<>();

        if (!StringUtils.isEmpty(ids)) {
            String[] strings = ids.split(",");
            List<Integer> idsList = MyCollectionUtils.toIntegerList(Arrays.asList(strings));
            list = cartMapper.findCardListByIdsString(idsList);
        }

        return list;
    }

    // 获取购物车中每一种商品的总价
    @Override
    public List<UserCartVo> getUserCartVos(List<Cart> carts) {

        List<UserCartVo> cartVoList = new LinkedList<>();
        for (Cart cart : carts) {
            UserCartVo userCartVo = new UserCartVo();
            userCartVo.setBookId(cart.getBook_id());
            userCartVo.setNum(cart.getCount());
            userCartVo.setTotalPrice(cart.getCount() * cart.getBook().getNew_price());
            cartVoList.add(userCartVo);
        }
        return cartVoList;
    }
}
