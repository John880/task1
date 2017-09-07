package task.dao;

import java.util.List;

import task.model.Item;

public interface TaskDAO {

    List<Item> queryItemList();
    
    void del(String name, int count);
}
