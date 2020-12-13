package cn.edu.zjut.app;

import cn.edu.zjut.bean.IItem;
import cn.edu.zjut.bean.IItemOrder;
import cn.edu.zjut.bean.ShoppingCart;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class SpringEnvTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        IItem item1 = (IItem) ctx.getBean("item1");
//        System.out.println(item1.getItemID());
//        System.out.println(item1.getTitle());
//        System.out.println(item1.getDescription());
//        System.out.println(item1.getCost());
//        IItem item2 = (IItem) ctx.getBean("item2");
//        System.out.println(item2.getItemID());
//        System.out.println(item2.getTitle());
//        System.out.println(item2.getDescription());
//        System.out.println(item2.getCost());
//        IItemOrder itemorder1 = (IItemOrder)
//                ctx.getBean("itemorder1");
//        System.out.println("书名：" + itemorder1.getItem().getTitle());
//        System.out.println("数量：" + itemorder1.getNumItems());
//        IItemOrder itemorder2 = (IItemOrder)
//                ctx.getBean("itemorder2");
//        System.out.println("书名：" + itemorder2.getItem().getTitle());
//        System.out.println("数量：" + itemorder2.getNumItems());

        //list
//        ShoppingCart shoppingCart = (ShoppingCart) ctx.getBean("shoppingcart");
//        List<IItemOrder> list = shoppingCart.getItemsOrdered();
//        for (IItemOrder i : list) {
//            System.out.println("书名：" + i.getItem().getTitle());
//            System.out.println("数量：" + i.getNumItems());
//        }
        //set
//        ShoppingCart shoppingCart = (ShoppingCart) ctx.getBean("shoppingcart");
//        Set<IItemOrder> set = shoppingCart.getItemsOrdered();
//        for (IItemOrder i : set) {
//            System.out.println("书名：" + i.getItem().getTitle());
//            System.out.println("数量：" + i.getNumItems());
//        }
        //map
//        ShoppingCart shoppingCart = (ShoppingCart) ctx.getBean("shoppingcart");
//        Map<Integer,IItemOrder> map = shoppingCart.getItemsOrdered();
//        System.out.println("书名：" + map.get(1).getItem().getTitle());
//        System.out.println("数量：" + map.get(1).getNumItems());
//        System.out.println("书名：" + map.get(2).getItem().getTitle());
//        System.out.println("数量：" + map.get(2).getNumItems());
//        ShoppingCart shoppingCart = (ShoppingCart) ctx.getBean("shoppingcart");
//        Properties properties = shoppingCart.getItemsOrdered();
//        System.out.println(properties.getProperty("1"));
//        System.out.println(properties.getProperty("2"));

//        System.out.println("getBean(item1)---1");
//        IItem item11 = (IItem) ctx.getBean("item1");
//        System.out.println("getBean(item1)---2");
//        IItem item12 = (IItem) ctx.getBean("item1");
//        System.out.println("getBean(item2)---1");
//        IItem item21 = (IItem) ctx.getBean("item2");
//        System.out.println("getBean(item2)---2");
//        IItem item22 = (IItem) ctx.getBean("item2");

        IItemOrder itemorder2 = (IItemOrder)ctx.getBean("itemorder2");
    }
}