package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class RandomUtils {
    private static Random random = new Random();

    private RandomUtils() {
    }

    public static int randomInt(int bound) {
        return random.nextInt(bound);
    }

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }

    private String id;
    private String name;

    public RandomUtils(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean insert() {
        return RandomUtils.randomBoolean();
    }

    @Override
    public String toString() {
        return "RandomUtils{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Queue<RandomUtils> queue = new ArrayBlockingQueue(5);
            queue.offer(new RandomUtils("a", "Tom"));
            queue.offer(new RandomUtils("b", "Tommy"));
            queue.offer(new RandomUtils("c", "Jerry"));
            queue.offer(new RandomUtils("d", "Jimmy"));
            queue.offer(new RandomUtils("e", "Jack"));
            queue.offer(new RandomUtils("f", "Rose"));

            System.out.println(queue);

            Map<String, Integer> cache = new HashMap<>();
            while (!queue.isEmpty()) {
                RandomUtils poll = queue.poll();
                if (!poll.insert()) {
                    if (cache.containsKey(poll.id)) {
                        cache.put(poll.id, cache.get(poll.id) + 1);
                    } else {
                        cache.put(poll.id, 1);
                    }
                    if (cache.get(poll.id) < 3) {
                        boolean offer = queue.offer(poll);
                        System.out.println(poll.name + " 入队成功: " + offer);
                    } else {
                        System.out.println("异常数据: " + poll.toString());
                    }
                }
            }

            System.out.println(queue);

            System.out.println("End ...");
        }
    }
}
