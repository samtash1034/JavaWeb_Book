package com.sam.pojo;

import java.util.*;

/**
 * 把購物車訊息放到session域中
 */
public class Cart {

//    private Integer totalCount;
//    private Integer totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    /**
     * 添加商品項
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());

        if(item == null){
            items.put(cartItem.getId(), cartItem);
        }else{
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice() * item.getCount());
        }
    }

    /**
     * 刪除商品項
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空購物車
     */
    public void clear(){
        items.clear();
    }

    /**
     * 更新商品數量
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count){
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice() * cartItem.getCount());
        }
    }

    public Cart() {
    }


    public Integer getTotalCount() {
        //能使用區域變數就盡量使用
        Integer totalCount = 0;

        for(Map.Entry<Integer, CartItem> entry : items.entrySet()){
            //Map.Entry是Map聲明的一個內部接口，這個接口為泛型，定義為Entry<K,V>。
            //它表示Map中的一個實體（一個key-value對）。接口裡面有getKey(),getValue()方法。
            //entrySet()的返回值也是返回一个Set集合，此集合的類型为Map.Entry
            //entry：紀錄
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }

//    public void setTotalCount(Integer totalCount) {
//        this.totalCount = totalCount;
//    }

    public Integer getTotalPrice() {
        Integer totalPrice = 0;

        for(Map.Entry<Integer, CartItem> entry : items.entrySet()){
            totalPrice += entry.getValue().getTotalPrice();
        }
        return totalPrice;
    }

//    public void setTotalPrice(Integer totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
