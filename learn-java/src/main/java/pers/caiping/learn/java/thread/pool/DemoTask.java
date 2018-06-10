package pers.caiping.learn.java.thread.pool;

import java.io.*;

public class DemoTask implements Runnable {
    @Override
    public void run() {
        try {
            doService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doService() throws IOException {
        File file = new File("D:/tmp","t.tmp");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        bufferedWriter.write(1);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
