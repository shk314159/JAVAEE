package cn.edu.zjut.bean;
public interface IItem {
    String getItemID();
    void setItemID(String itemID);
    public String getTitle();
    public void setTitle(String title);
    public String getDescription();
    public void setDescription(String description);
    public double getCost();
    public void setCost(double cost);
}