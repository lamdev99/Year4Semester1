/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_socket;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author lamit
 */
public class DemoInoutFile {
    static String pathTest = "D:\\Java\\JavaProj\\LapTrinhMang\\src\\demo_socket\\testimg.PNG";
    static String pathOut = "D:\\Java\\JavaProj\\LapTrinhMang\\src\\demo_socket\\example-tiff1.PNG";
    public static void main(String[] args) {
        readFile();
//        writeFile();
//        writeFilePS();
//        readFileSC();
//        readAndWriteImage();
    }
    
    private static void writeImage(){
        
    }
    private static void readAndWriteImage(){
        File imageFile = new File("D:\\Java\\JavaProj\\LapTrinhMang\\src\\demo_socket\\testimg.PNG");
        
        try {
            BufferedImage image = ImageIO.read(imageFile);
            System.out.println(image.getSource().toString());
            File outputFile = new File("D:\\Java\\JavaProj\\LapTrinhMang\\src\\demo_socket\\example-tiff.PNG");
            ImageIO.write(image, "PNG", outputFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void readFileSC(){
        File text = new File(pathTest);
     
        //Creating Scanner instnace to read File in Java
        Scanner scnr;
        try {
            scnr = new Scanner(text);
            int lineNumber = 1;
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                System.out.println("line " + lineNumber + " :" + line);
                lineNumber++;
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoInoutFile.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        //Reading each line of file using Scanner class
          
    }
    public static void writeFilePS(){
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(pathTest);
            PrintStream pout = new PrintStream(fout);
            pout.println(2020);
            pout.println("Hello Java");
            pout.println("Welcome to Java");
            pout.close();
            fout.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoInoutFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DemoInoutFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    static ArrayList<Integer> list = new ArrayList<>();
    public static void readFile(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(pathTest);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int i;
            while((i = bis.read())!=-1){
                list.add(i);
            }
            writeFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoInoutFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DemoInoutFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void writeFile(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pathOut);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
//            for(int i = 1; i <= 10; i++){
//                bos.write(i);
//            }
            for(int i = 0; i <list.size(); i++){
                bos.write(i);
            }
            bos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoInoutFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DemoInoutFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
