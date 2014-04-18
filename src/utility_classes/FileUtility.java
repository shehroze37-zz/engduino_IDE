/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utility_classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Helper class for reading and writing files.
 */
public class FileUtility {

   
    private static final Charset CHARSET = Charset.forName("UTF-8");

    /**
     * Reads the specified file and returns the content as a String.
     * 
     * @param file
     * @return
     * @throws IOException thrown if an I/O error occurs opening the file
     */
    public static String readFile(File file) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();

        BufferedReader reader = Files.newBufferedReader(file.toPath(), CHARSET);

        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuffer.append(line);
        }

        reader.close();

        return stringBuffer.toString();
    }

    /**
     * Saves the content String to the specified file.
     * 
     * @param content
     * @param file
     * @throws IOException thrown if an I/O error occurs opening or creating the file
     */
    public static void saveFile(String content, File file) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(file.toPath(), CHARSET);
        writer.write(content, 0, content.length());
        writer.close();
    }
}