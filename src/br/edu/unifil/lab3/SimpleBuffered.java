package br.edu.unifil.lab3;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleBuffered {

    public static void main(String[] args) throws IOException {
        BufferedWriter out = null;
        Scanner scanner = null;
        long times[] = new long[10];
        String files[] = {"small", "medium", "large"};

        for (String file : files) {

            for(int i = 0; i < times.length; i++){
                long startTime = System.currentTimeMillis();
                try {
                    scanner = new Scanner(new BufferedReader(new FileReader(String.format("files/in/%s.txt", file))));
                    out = new BufferedWriter(new FileWriter(String.format("files/out/%s.txt", file)));

                    while (scanner.hasNext()){
                        out.write(scanner.next());
                        out.write("\n");
                    }
                } finally {
                    if (scanner != null) {
                        scanner.close();
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
