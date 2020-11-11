package cn.edu.zjut.action;

import cn.edu.zjut.bean.Item;
import cn.edu.zjut.service.ItemService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ItemAction extends ActionSupport {
    private List items;
    public String getAllItems() {
        ItemService itemServ = new ItemService();
        items=itemServ.getAllItems();
        System.out.println("ItemAction excuted!");
//        for(int i = 0; i < items.size(); i++) {
//            Item a = (Item) items.get(i);
//            System.out.println(a.getCost());
//        }
        return "success";
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}