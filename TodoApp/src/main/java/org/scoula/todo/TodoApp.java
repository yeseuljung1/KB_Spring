package org.scoula.todo;

import org.example.ui.App;
import org.scoula.todo.command.DeleteTodoCommand;
import org.scoula.todo.command.DetailTodoCommand;
import org.scoula.todo.command.PrintTodoCommand;
import org.scoula.todo.ui.MenuItem;
import org.scoula.todo.ui.Menu;

import java.awt.*;

public class TodoApp extends App {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);
        menu.add(new MenuItem("목록", new PrintTodoCommand()));
        menu.add(new MenuItem("상세", new DetailTodoCommand()));
        menu.add(new MenuItem("추가", null));
        menu.add(new MenuItem("수정", null));
        menu.add(new MenuItem("삭제", new DeleteTodoCommand()));
    }
    public static void main(String[] args) {
        App app = new TodoApp();
        app.run();
    }
}
