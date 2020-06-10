/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lsz.concurrent;

/**
 * @author liushuangzeng
 * @Date 20/6/9 下午2:23
 */
public class Main {

    private static String lastCompleteStr = "C";

    public static void main(String[] args) {
        new Thread(new PrintTask("A", "C")).start();
        new Thread(new PrintTask("B", "A")).start();
        new Thread(new PrintTask("C", "B")).start();
    }

    static class PrintTask implements Runnable {

        private String cur;

        private String waitLastStr;

        public PrintTask(String cur, String waitLastStr) {
            this.cur = cur;
            this.waitLastStr = waitLastStr;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (Main.class) {
                        while (!lastCompleteStr.equals(waitLastStr)) {
                            Main.class.wait();
                        }

                        System.out.println(cur);

                        lastCompleteStr = cur;

                        Main.class.notifyAll();
                    }
                }
            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }
}