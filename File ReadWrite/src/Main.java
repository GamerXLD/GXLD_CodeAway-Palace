import java.io.*;
import java.util.*;

public class Main {
    static void writeFile (String line){
        try {
            RandomAccessFile raf = new RandomAccessFile("StudentInfo.txt","rw");
            raf.seek(raf.length());
            raf.writeBytes(line);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File Not Found");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to Read&Write");

        }
    }
    static void readFile(){
        try {
            RandomAccessFile raf = new RandomAccessFile("StudentInfo.txt","r");
            String line;
            while ((line = raf.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File Not Found");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to Read&Write");

        }
    }
    static void courseAdvice(String Courseadd){
        try {
            RandomAccessFile raf = new RandomAccessFile("CourseAdd.txt","rw");
            raf.seek(raf.length());
            raf.writeBytes(Courseadd);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File Not Found");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to Read&Write");

        }
    }
    static void courseReadFile(){
        try {
            RandomAccessFile raf = new RandomAccessFile("CourseAdd.txt","r");
            String line;
            while ((line = raf.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File Not Found");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to Read&Write");

        }
    }

    static void searchFor(int id){
        try {
            RandomAccessFile raf = new RandomAccessFile("CourseAdd.txt","r");
            String line;
            while ((line = raf.readLine())!=null){
               String[] arr = line.split(",");
               int num = Integer.parseInt(arr[0]);
               if (num == id){
                System.out.println("ID : "+num+" || "+arr[1]);
               }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File Not Found");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to Read&Write");

        }
    }
    
    public static void main(String[] args){
        searchFor(1006);
        

    }
}
