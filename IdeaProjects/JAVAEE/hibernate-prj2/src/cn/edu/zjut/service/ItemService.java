package cn.edu.zjut.service;
import java.util.List;
import java.util.ArrayList;
import cn.edu.zjut.dao.ItemDAO;
public class ItemService {
    private List items = new ArrayList();
    public List findByHql() {
        ItemDAO dao = new ItemDAO();
//        String hql = "from cn.edu.zjut.po.Item";
//        String hql = "from Item as item";
//        String hql = "select item.title from Item as item";
//        String hql = "select item.title, item.cost from Item as item";
        //聚集函数
//        String hql = "select count(*) from Item as count";
        //where查询
//        String hql = "from Item where cost<25";
        //order by 降序排序
//        String hql = "from Item order by cost DESC";
        //子查询
        String hql = "from Item i where i.cost<25";
        List list = dao.findByHql(hql);

        dao.getSession().close();
        return list;
    }
}