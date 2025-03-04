package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BooksDatabase {

    private static BooksDatabase instance;
    private ArrayList<String> booksIn = new ArrayList<>();

    private BooksDatabase(){

        try{

            File x = new File("J:\\Uni\\Year Four\\HonsProjCode\\SensibleLabSession\\src\\main\\java\\org\\example\\database.csv");

            Scanner scan = new Scanner(x);

            while (scan.hasNextLine()){
                booksIn.add(scan.nextLine());
            }
        }
        catch (Exception e){
            System.err.println("Filepath is incorrectly specified. For this task, just hardcode the absolute filepath!");
        }
    }

    public static BooksDatabase getInstance(){
        if(instance == null){
            instance = new BooksDatabase();
        }
        return instance;
    }

    public String getBook(){

        if(!booksIn.isEmpty()){
            String out = booksIn.get(0);
            booksIn.remove(0);

            return out;

        }
        return null;

    }

}
