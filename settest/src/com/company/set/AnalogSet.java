package com.company.set;


import java.util.AbstractCollection;

/**
 * Created by dima on 15.05.17.
 */
public interface AnalogSet {
    boolean add(String str);

    boolean remove(String str);

    boolean contains(String value);

    boolean isEmpty();

    int getHeightTree();

    int size();
}
