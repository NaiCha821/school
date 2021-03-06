package com.jichuangsi.school.statistics.model.homework;

import java.util.ArrayList;

public class CustomArrayList<E> extends ArrayList<E> {

    public E getFirst(){
        return this.get(0);
    }

    public E getLast(){
        if(this.size() > 0)
            return this.get(this.size() - 1);
        else
            return null;
    }
}
