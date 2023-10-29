package com.example.algorithms2.Service;

import com.example.algorithms2.Exception.ElementNotFoundException;
import com.example.algorithms2.Exception.InvalidIndexException;
import com.example.algorithms2.Exception.ItemNullException;
import com.example.algorithms2.Exception.StorageIsFullException;
import com.example.algorithms2.Interface.IntegerList;

import java.util.Arrays;

public class IntegerListImp implements IntegerList {
    private final Integer[] storage;
    private int size;

    public IntegerListImp() {
        storage = new Integer[10];
    }
    public IntegerListImp(int initSize){
        storage = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        checkItem(String.valueOf(item));
        checkSize();
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkSize();
        checkIndex(index);
        checkItem(String.valueOf(item));
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
    public Integer remove(Integer item) {
        checkItem(String.valueOf(item));
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
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = storage[index];
        if(index != size){
            System.arraycopy(storage,index+1,storage,index,size-(index+1));}
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size ; i++) {
            if(storage[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i>=0 ; i--) {
            if (storage[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return storage[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        checkItem(String.valueOf(item));
        storage[index]=item;
        return item;
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
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
