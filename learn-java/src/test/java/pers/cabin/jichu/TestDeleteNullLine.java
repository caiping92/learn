package pers.cabin.jichu;

import org.junit.Test;

import java.io.*;

/**
 * 去掉纯文本中的空行
 * Created by caiping on 2017/6/29.
 */
public class TestDeleteNullLine {

    @Test
    public void testDeleteNullLine() {
        String file = "C:\\Users\\caiping\\Desktop\\t\\代码.txt";
        String res = "C:\\Users\\caiping\\Desktop\\t\\rest.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(res))));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim() != "" && line.trim().length()!=0) {
                    bufferedWriter.write(line.trim()+"\r\n");
                    bufferedWriter.flush();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
