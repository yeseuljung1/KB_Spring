package org.scoula.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Todo implements Cloneable{
    private static int gid = 1;

    private int id;
    private String title;
    private String description;
    private boolean done;
    private Date date;

    @Builder
    public Todo(String title, String description, boolean done, Date date) {
//        여기에서 this는 다른 생성자를 호출한다
        this(gid++,title,description,done,new Date());
    }
//    객체를 안전하게 복제하기 위해서는 Cloneable 인터페이스까지 구형해야한다
    @Override
    protected Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }
    public String getRegDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    }

