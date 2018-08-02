package com.etoak.VO;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/7/10
 */
public class Test {
    public static void main(String[] args) {
        ArrayBlockingQueue<Task> a =  new ArrayBlockingQueue<Task>(1);
        LinkedBlockingQueue l = new LinkedBlockingQueue();
        a.offer(new Task());
        System.out.println(a.offer(new Task()));
        l.add(new Task());
        l.add(new Task());
        l.add(new Task());
        l.add(new Task());
        l.add(new Task());
        Task peek =(Task) l.poll();
        System.out.println(l.size());

    }
}
