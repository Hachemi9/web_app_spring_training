package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class TodoListController {
    ArrayList<Todo> t = new ArrayList<Todo>();

    @PostMapping(value="/api/todo")

    public void POST(@RequestBody Todo a){
           t.add(a);
    }

    @GetMapping(value="/api/todo")
    public ArrayList<Todo> GET(){
        return t;
    }
}
