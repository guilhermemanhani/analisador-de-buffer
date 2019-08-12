package br.edu.unifil.lab3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleByteStream{

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        long times[] = new long[10];
        String files[] = {"small", "medium", "large"};

        for (String file : files) {

            for(int i = 0; i < times.length; i++){
                long startTime = System.currentTimeMillis();
                try {
                    in = new FileInputStream("files/in/"+file+".txt");
                    out = new FileOutputStream(String.format("files/out/%s.txt", file));
                    int c;
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                } finally {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
                long endTime = System.currentTimeMillis();
                times[i] = (endTime-startTime);
            }
            System.out.println(Arrays.stream(times).average().orElse(Double.NaN));

        }


    }
}
