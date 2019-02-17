package com.company;

public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }


    // 无参的构造函数，默认数组的容量 capacity = 10
    public Array(){
        this(10);
    }

    // 获取数组中元素个数
    public int getSize(){
        return size;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向数组末尾添加元素
    public void addLast(E e){
//        if(size == data.length){
//            throw new IllegalArgumentException("AddLast failed.Array is full.");
//        }
//        data[size] = e;
//        size ++;
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    // 在 index 位置插入一个新元素e
    public void add(int index, E e){
        if(size == data.length){
            resize(2 * data.length);
        }

        if (index < 0 || index > size){
            throw new IllegalArgumentException("Illegal 'index'");
        }

        for (int i = size - 1; i >= index;i --){
            data[i+1] = data[i];

        }

        data[index] = e;
        size ++;
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array:size = %d, capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i< size; i++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("'index' is Illegal");
        return data[index];
    }

    //  修改index索引的元素
    void set(int index,E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index is Illegal!");
        data[index] = e;
    }


    // 查找元素中是否有元素 e
    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if (data[i] == e)
                return true;
        }
        return false;
    }



    // 查找一个数的下标，如果没有就返回 -1,有则返回其下标
    public int find(E e){
        for (int i = 0;i < size;i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //删除指定位置的元素
    public E remove1(int index){
        E y;
        for (int i = index; i < size - 1;i++){
            y = data[index + i];
            data[index + i] = data[i];
            data[i] = y;
        }
        size --;
        data[size] = null;
        return data[index];
    }


    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("'index' is Illegal.");

        E ret = data[index];
        for (int i = index + 1; i < size; i ++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;

        // Lazy
        if (size == data.length / 4 && data.length /2 != 0)
            resize(data.length / 2);
        return ret;
    }



    // 从数组中删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }



    // 元素如果存在则删除，没有则算了
    public boolean removeElement(E e){
        int index = find(e);
        if(index != -1){
            E ret = remove(index);
            if(ret == e){
                return true;
            }
        }

        return false;
    }


    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0;i < size;i ++)
            newData[i] = data[i];
        data = newData;
    }




    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

}

