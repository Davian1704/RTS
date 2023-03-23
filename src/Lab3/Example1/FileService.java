package Lab3.Example1;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Date;

public class FileService {

    String fileName;

    BufferedReader in;

    PrintWriter out;

    public FileService(String fname){

        this.fileName = fname;

        try {
            out = new PrintWriter(new FileWriter(fileName, true));
            in = new BufferedReader(new FileReader(fileName));
         } catch (Exception e) { e.printStackTrace();}
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }
}