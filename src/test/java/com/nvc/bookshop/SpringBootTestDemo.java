package com.nvc.bookshop;

import com.nvc.bookshop.mapper.BookMapper;
import com.nvc.bookshop.mapper.CartMapper;
import com.nvc.bookshop.mapper.OrderMapper;
import com.nvc.bookshop.pojo.Book;
import com.nvc.bookshop.pojo.Cart;
import com.nvc.bookshop.pojo.Order;
import com.nvc.bookshop.pojo.OrderItem;
import com.nvc.bookshop.service.BookService;
import com.nvc.bookshop.utils.OrderUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootTestDemo {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test() {

        if (bookMapper != null) {
            List<Book> books = bookMapper.findAll();
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    @Test
    public void test2() {
        if (bookService != null) {
            List<Book> books = bookService.handleBooks();
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    @Test
    public void test3() {
        List<Cart> cartList = cartMapper.findCartListByUserId(3);
        for (Cart cart : cartList) {
            System.out.println(cart);
        }
    }

    @Test
    public void test4() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        List<Cart> cartList = cartMapper.findCardListByIdsString(list);
        System.out.println(cartList);
    }

    @Test
    public void test5() {
        List<Order> orderList = orderMapper.findDetailOrderListByUserId(6);
        for (Order order : orderList) {
            System.out.println("User ==> " + order.getUser());
            System.out.println("Address ==> " + order.getAddress());
            System.out.println("****************************");
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                System.out.println(orderItem);
                System.out.println(orderItem.getBook());
            }
        }
    }

    @Test
    public void test6(){
        String orderNum = OrderUtils.createOrderNum();
        System.out.println(orderNum);
        System.out.println(OrderUtils.createOrderNum());
    }
}
