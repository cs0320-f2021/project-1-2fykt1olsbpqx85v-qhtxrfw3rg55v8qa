package edu.brown.cs.student.main.core;

import edu.brown.cs.student.main.DataTypes.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * A generic file parser.
 */
public class FileParser {

    private BufferedReader _bufRead = null;

    /**
     * A FP constructor.
     *
     * @param file - a String file path
     */
    public FileParser(String file) {

        try {
            this._bufRead = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException f) {
            System.out.println("ERROR: File not found");
        }
    }

    /**
     * Reads a new line in the file and returns a String.
     *
     * @return a read String line
     */
    public ArrayList<String> readLines() {
        if (_bufRead != null) {
            try {
                ArrayList<String> lineList = new ArrayList<>();
                String curr;
                while ((curr = _bufRead.readLine()) != null){
                    lineList.add(curr);
                }
                return lineList;

            } catch (IOException e) {
                System.out.println("ERROR: Read");
                return null;
            }
        } else {
            return null;
        }
    }

    public ArrayList<User> linesToUsers(){
        ArrayList<String> data = this.readLines();
        ArrayList<User> userList = new ArrayList<>();

       for (String item : data) {
           User user = new User(item);
           userList.add(user);
       }

       return userList;
    }
}
