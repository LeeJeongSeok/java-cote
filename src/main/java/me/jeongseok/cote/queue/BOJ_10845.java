package me.jeongseok.cote.queue;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 연습문제 - 큐 (실버 4)
 * 배열을 이용하여 큐를 규현
 */
class Queue {
    int[] array = new int[10000];
    int front = 0;
    int back = 0;

    void push(int X) {
        array[back] = X;
        back++;
    }

    int pop() {
       if (size() != 0) {
           int value = array[front];
           front++;

           return value;
       }
       return -1;
    }

    int size() {
        return back - front;
    }

    int empty() {
        if (size() != 0) {
            return 0;
        }
        return 1;
    }

    int front() {
        if (size() != 0) {
            return array[front];
        }
        return -1;
    }

    int back() {
        if (size() != 0) {
            return array[back];
        }
        return -1;
    }
}

public class BOJ_10845 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
