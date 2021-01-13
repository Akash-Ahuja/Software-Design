package sample;

import java.io.*;
import java.util.Scanner;

public class HistogramAlphabet {

        private long total_alphabets = 0;
        private long[] alphabets_no = new long[26];

        //mapping arrays
        float[] probability = new float[26];
        char[] alphabets = new char[26];

        //The constructor directly reads the file and computes the values for all the alphabets
        HistogramAlphabet()
        {
            for(int i=97; i<=122; i++)
            {
                alphabets[i - 97] = (char)i;
            }
            try
            {
                File myObj = new File("/Users/akashahuja/Desktop/AliceInWonderland.txt");
                Scanner myReader = new Scanner(myObj);
                int ch = ' ';
                String data = "";
                while(myReader. hasNextLine()) {
                    String temp = myReader.nextLine();
                    data+= temp;
                }
                data = data.replaceAll("[^a-zA-Z]", "").toLowerCase();
                myReader.close();
                for(int j = 0; j < data.length(); j++){
                     ch = data.charAt(j);
                    alphabets_no[ ch - 'a']++;
                    total_alphabets++;
                }
//                    for(int i=65; i<=90; i++)
//                    {
//
//                        if(ch == (char)i)
//                        {
//                            alphabets_no[i - 65]++;
//                            total_alphabets++;
//                        }
//                    }

                } catch (FileNotFoundException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
            }
        }
//            catch(IOException io)
//            {
//                System.out.println("An Exception has occurred as follows\n" + io);
//            }
//        }

        void calculate_probability()
        {
            for(int i=0; i<26; i++)
            {
                probability[i] = (float)alphabets_no[i]/(float)total_alphabets;
                System.out.println(probability[i]);
            }
        }
    }
