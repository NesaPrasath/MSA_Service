package com.example.msa.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FileHandling {
    private String folder;
    private String data;
    @Value("${file.path1}")
    private String location;

    public boolean generateFolder(){
        Path path=Paths.get(location+this.folder);
        try {
            Files.createDirectories(path);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean storeFile(){
        try {
            byte[] bt=new byte[1024];
            FileInputStream fi=new FileInputStream(this.data);
            FileOutputStream fo=new FileOutputStream(location);
            int byteRead;
            while ((byteRead=fi.read(bt))!=-1) {
                fo.write(bt, 0, byteRead);
            }
            fi.close();
            fo.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
