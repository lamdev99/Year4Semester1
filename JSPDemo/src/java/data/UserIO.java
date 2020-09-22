/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author lamit
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.User;

/**
 *
 * @author Nguye
 */
public class UserIO {

    public static void add(User user, String filepath)
            throws IOException {
        File file = new File(filepath);
        PrintWriter out = new PrintWriter(
                new FileWriter(file, true));
//        out.println(user.getEmailAddress() + "|"
//                + user.getFirstName() + "|"
//                + user.getLastName()+"|");
        out.println("Success");
        out.close();
    }
}
