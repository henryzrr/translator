package com.livecron.util.lib;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringFile {

    public static String fileToString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static void stringToFile(String content,String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(content);
        writer.close();
    }
}
