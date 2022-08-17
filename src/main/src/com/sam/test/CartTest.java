package com.sam.test;

import com.sam.pojo.Cart;
import com.sam.pojo.CartItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {

       Cart cart = new Cart();

       cart.addItem(new CartItem(1, "java8", 2, 300, 600));
       cart.addItem(new CartItem(2, "java10", 2, 300, 600));
       cart.addItem(new CartItem(3, "java16", 2, 300, 600));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java8", 2, 300, 600));
        cart.addItem(new CartItem(2, "java10", 2, 300, 600));
        cart.addItem(new CartItem(3, "java16", 2, 300, 600));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java8", 2, 300, 600));
        cart.addItem(new CartItem(2, "java10", 2, 300, 600));
        cart.addItem(new CartItem(3, "java16", 2, 300, 600));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java8", 2, 300, 600));
        cart.addItem(new CartItem(2, "java10", 2, 300, 600));
        cart.addItem(new CartItem(3, "java16", 2, 300, 600));

        cart.updateCount(1, 10);
        System.out.println(cart);
    }
}