package com.selfish.gene.io.serializable.customize;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/5.
 */
public class Orientation implements Serializable{

    public static final Orientation HORIZONTAL = new Orientation(1);
    public static final Orientation VERTICAL = new Orientation(2);

    private int value;

    private Orientation(int value) {
        this.value = value;
    }

    private Object readResolve() throws ObjectStreamException{
        if(value == 1){
            return HORIZONTAL;
        }if(value == 2){
            return VERTICAL;
        }
        return null;
    }
}
