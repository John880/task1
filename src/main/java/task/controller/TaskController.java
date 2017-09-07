package task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import task.dao.TaskDAO;
import task.model.Item;

@RestController() 
public class TaskController  {

    @Autowired
    private TaskDAO dao;
    
    @RequestMapping(value = "/items", method = RequestMethod.GET)  
    @ResponseBody
    public List<Item> list(){
        List<Item> list = dao.queryItemList();
        return list;
    }
    
    
//    @RequestMapping(value = "/list")
//    
//    public ModelAndView list() {
//
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("message", "abc");
//        mv.setViewName("task");
//        
//        return mv;
//    }
    
    @RequestMapping(value = "/buy/{name}/{count}")  
    public void buy(@PathVariable("name") String name, @PathVariable("count") int count){
        dao.del(name, count);
    }
    
    public void myCart(){
        
    }
}
