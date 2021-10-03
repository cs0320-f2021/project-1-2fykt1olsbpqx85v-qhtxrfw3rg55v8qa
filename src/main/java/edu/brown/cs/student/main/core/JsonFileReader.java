package edu.brown.cs.student.main.core;

import java.io.*;
import java.net.http.HttpRequest;
import com.google.gson.Gson;

import java.nio.Buffer;
import java.util.*;


public class JsonFileReader {

    public JsonFileReader(String filename) throws IOException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("data/justreviewsSMALL"));
        String s = br.readLine();
        String userData = gson.fromJson(br, String.class);
        

    }

}
