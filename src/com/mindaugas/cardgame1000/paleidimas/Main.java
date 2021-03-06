package com.mindaugas.cardgame1000.paleidimas;

import com.mindaugas.cardgame1000.systemoutspausinimas.MultiOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {


        try
        {
            FileOutputStream fout= new FileOutputStream("stdout.log");
            FileOutputStream ferr= new FileOutputStream("stderr.log");

            MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);
            MultiOutputStream multiErr= new MultiOutputStream(System.err, ferr);

            PrintStream stdout= new PrintStream(multiOut);
            PrintStream stderr= new PrintStream(multiErr);

            System.setOut(stdout);
            System.setErr(stderr);
        }
        catch (FileNotFoundException ex)
        {
            //Could not create/open the file
        }

        ZaidimoPagrindinis ts = new ZaidimoPagrindinis();
        ts.zaidimas();

        }
}

