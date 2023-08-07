package com.systeminfos.design.pattern.GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

class Request {
    private final String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }

    public synchronized Request getRequest() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }
}

class ClientThread extends Thread {
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("Request " + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request.getData());
            requestQueue.putRequest(request);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ServerThread extends Thread {
    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = requestQueue.getRequest();
                System.out.println(Thread.currentThread().getName() + " handles " + request.getData());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();

        Thread clientThread1 = new ClientThread(requestQueue, "ClientThread-1");
        Thread clientThread2 = new ClientThread(requestQueue, "ClientThread-2");
        Thread clientThread3 = new ClientThread(requestQueue, "ClientThread-3");

        Thread serverThread1 = new ServerThread(requestQueue, "ServerThread-1");
        Thread serverThread2 = new ServerThread(requestQueue, "ServerThread-2");

        clientThread1.start();
        clientThread2.start();
        clientThread3.start();

        serverThread1.start();
        serverThread2.start();
    }
}
