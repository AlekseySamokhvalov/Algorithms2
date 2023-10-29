package com.example.algorithms2.Service;

import com.example.algorithms2.Exception.ElementNotFoundException;
import com.example.algorithms2.Exception.InvalidIndexException;
import com.example.algorithms2.Exception.ItemNullException;
import com.example.algorithms2.Exception.StorageIsFullException;
import com.example.algorithms2.Interface.StringList;

import java.util.Arrays;

public class StringListImp implements StringList {
    private final String[] storage;
    private int size;

    public StringListImp() {
        storage = new String[10];
    }
    public StringListImp(int initSize){
        storage = new String[initSize];
    }

    @Override
    public String add(String item) {
        checkItem(item);
        checkSize();
        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkSize();
        checkIndex(index);
        checkItem(item);
        if (index == size){
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage,index,storage,index+1,size-index);
        storage[size++] = item;
        size++;
        return item;
    }

    @Override
    public String remove(String item) {
        checkItem(item);
        int index = indexOf(item);
        if(index == -1){
            throw new ElementNotFoundException("элемент не найден");
        }
        if(index == size){
            storage[size--]=null;
            return item;
        }
        System.arraycopy(storage,index+1,storage,index,size-(index+1));
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = storage[index];
        if(index != size){
            System.arraycopy(storage,index+1,storage,index,size-(index+1));}
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size ; i++) {
            if(storage[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i>=0 ; i--) {
            if (storage[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return storage[index];
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkItem(item);
        storage[index]=item;
        return item;
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public void clear() {
        size=0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage,size());
    }
    private void checkSize(){
        if(size()==storage.length){
            throw new StorageIsFullException("в массиве нет свободного места");
        }
    }
    private void checkItem(String item){
        if (item == null){
            throw new ItemNullException("элемент отсутствует");
        }
    }
    private void checkIndex(int index){
        if(index<0||index>=size()){
            throw new InvalidIndexException("индекс не соответствует параметрам");
        }
    }
}
