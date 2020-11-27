package cn.edu.zjut.action;
import java.util.List;
import cn.edu.zjut.service.ItemService;
public class ItemAction{
    private List items;

    public String findItems() {
        ItemService itemServ = new ItemService();
        items=itemServ.findByHql();
//        for(int i = 0; i < items.size(); i++) {
//            items.set(i, items.get(i).toString());
//            System.out.println(items.get(i));
//        }
        System.out.println("Item Action executed!");
        return "success";
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}