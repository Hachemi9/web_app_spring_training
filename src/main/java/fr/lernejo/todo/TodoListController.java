package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoListController {
    TodoRepository t;

    public TodoListController(TodoRepository t) {
        this.t = t;
    }

    @PostMapping(value="/api/todo")

    public TodoEntity post(@RequestBody TodoEntity a){
          return t.save(a);
    }
    
    @GetMapping(value="/api/todo")
    public Iterable<TodoEntity> get(){
        return t.findAll();
    }
}
