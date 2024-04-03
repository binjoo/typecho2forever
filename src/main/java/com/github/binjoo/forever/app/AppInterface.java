package com.github.binjoo.forever.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-10 18:26
 */
@Component
public abstract class AppInterface {

    public abstract void run();

    public void writer(String text, String fileName) {
        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(fileName));
            osw = new OutputStreamWriter(fos, "UTF-8");
            bw = new BufferedWriter(osw);
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (osw != null) {
                    osw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
