package task.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import task.model.Item;

@Repository("TaskDAO")
public class TaskDAOImpl implements TaskDAO {

    private static List<Item> items;
    
    static {
        items = new ArrayList<Item>();
        Item itemA = new Item();
        itemA.setName("A");
        itemA.setCount(20);
        items.add(itemA);
        Item itemB = new Item();
        itemB.setName("B");
        itemB.setCount(10);
        items.add(itemB);
    }

    public List<Item> queryItemList() {

        return items;
    }

    @Override
    public void del(String name, int count) {

        for (Item item : items) {
            if (item.getName().equals(name)) {
                item.setCount(item.getCount() - count);
            }
        }
    }

}
