package me.jeongseok.cote.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2606 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[] visit = new boolean[n + 1];
        int count = 0;

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visit[1] = true;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int i = 0; i < list.get(cur).size(); i++) {
                if (list.get(cur).get(i) >= 1 && !visit[i]) {
                    visit[i] = true;
                    stack.push(list.get(cur).get(i));
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
