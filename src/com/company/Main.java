package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> river = new ArrayList<>();
    public static ArrayList<Integer> fibonacci = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("enter the width of the river");
        int width = inputInt();
        createRiver(width);
        System.out.println(river);
        createFibonacci();
        System.out.println(fibonacci);
        System.out.println(jump());
    }

    public static void createRiver(int n){
        for (int i = 0; i < n; i++){
            river.add(randomInt());
        }
    }

    public static int randomInt(){
        Random random = new Random();
        return random.nextInt(2);
    }

    public static void createFibonacci(){
        fibonacci.add(0);
        fibonacci.add(1);
        for (int i = 2; i < 10; i++){
            int out = fibonacci.get(i-1) + fibonacci.get(i-2);
            fibonacci.add(out);
        }
    }

    public static int inputInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static int jump(){
        int position = -1;
        int count = 0;
        boolean end = false;
        for (int i = 0; i < fibonacci.size(); i++){
            if (fibonacci.get(i) == river.size()+1){
                count++;
                end = true;
            }
        }
        while (!end){
            for (int i = 0; i < fibonacci.size()-1; i++){
                int num = fibonacci.size()-i;
                num = num -1;
                int newPos = fibonacci.get(num)+position;
                if (newPos == river.size()+1){
                    count++;
                    end = true;
                }
                else if (newPos < river.size()){
                    if(river.get(newPos) == 1){
                        position = newPos;
                        count++;
                    }
                }
            }
            end = true;
        }
        return count;
    }
}
