package Exam2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static RecursionExamples.Recursion.isPalindrome;

public class Exam {
    public static String [] load_words(String path, int n) {

        // connect to the webpage of speeds
        URL url = null;
        Scanner s = null;



        try {
            url = new URL(path);
            s = new Scanner(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //create an array of strings
        String [] palindromes = new String [n];
        int i = 0;

        while (s.hasNextLine()){
            String line = s.nextLine();
            if(isPalindrome(line))
                palindromes[i++] = line;
        }

        return palindromes;
    }

    public static String[] reverse(String [] arr) {

        for (int i = 0; i < arr.length/2; i++){
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
    public static void print_array(String [] arr) {
        System.out.print('[');
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1]);
        System.out.println(']');
    }

    public static void main(String[] args) {
        String [] palindromes = load_words("http://10.60.15.25/~ehar/cs219/wordle-nyt-solutions.txt", 9);
        print_array(reverse(palindromes));
    }
}
