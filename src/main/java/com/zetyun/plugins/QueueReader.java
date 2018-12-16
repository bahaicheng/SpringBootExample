package com.zetyun.plugins;

import java.util.concurrent.BlockingQueue;

public class QueueReader implements Runnable{

    BlockingQueue queue;

    public QueueReader(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("Queue Data:"+queue.poll());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
