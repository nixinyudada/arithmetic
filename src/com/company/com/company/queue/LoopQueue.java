package com.company.com.company.queue;

import com.company.Array;

import java.util.Random;

public class LoopQueue<E> implements Queue<E> {


    private E[] data;
    private int front,tail;
    private int size;


    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;

        System.out.println(capacity);

    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }


    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i =0;i <10;i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }


        // 测试
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time:"+time1+"s");

         LoopQueue<Integer> loopQueue = new LoopQueue<>();
         double time2 = testQueue(loopQueue,opCount);
         System.out.println("LoopQueue, time:"+time2+"s");

    }

    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0;i < opCount;i ++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0;i< opCount;i++){
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }


    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0;i < size;i++){
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;





    }



    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append(String.format("Queue:size = %d,capacity = %d\n",size,getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}


// O(1)  但是会触发缩容与扩容   均摊
