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

    private BufferedReader bufRead = null;

    /**
     * A FP constructor.
     *
     * @param file - a String file path
     */
    public FileParser(String file) {
        try {
            this.bufRead = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException f) {
            System.out.println("ERROR: File not found");
        }
    }

    /**
     * Reads a new line in the file and returns a String.
     *
     * @return a read String line
     */
    public String readNewLine() {
        if (bufRead != null) {
            try {
                String ln = bufRead.readLine();
                return ln;
            } catch (IOException e) {
                System.out.println("ERROR: Read");
                return null;
            }
        } else {
            return null;
        }
    }

    public ArrayList<User> stringConverter(){
        ArrayList<User> userArrayList = new ArrayList<>();
        String data = this.readNewLine();
        HashMap<Integer, ArrayList<String>> userHashmap = new HashMap<Integer, ArrayList<String>>();
       String[] dataArray = data.split("},");
       for (String userString : dataArray) {
           User user = new User(userString);
           userArrayList.add(user);
       }

       return userArrayList;
    }
}
