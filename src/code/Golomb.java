package code;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class Golomb {

    private int T;
    private int m;

    Golomb(int t, int M){
        if (t == pow(2,M)){
            T = t;
            m = M;
        }
        else{
            System.out.println("Ne kvadrat");
            T = 8;
            m = 3;
        }
    }


    private String binary(int value){
        StringBuilder stringBuilder = new StringBuilder("");
        int tmpM = m;
        while (tmpM != 0) {
            if (value % 2 == 0)
                stringBuilder.append('0');
            else
                stringBuilder.append('1');
            value /= 2;
            tmpM--;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    private void makeCode(int value){
        int firstPart = value/T + 1;
        int secondPart = value % T;


        for (int i = 0; i < firstPart-1; i++)
            System.out.print("1");
        System.out.print("0,");
        System.out.print(binary(secondPart));
        System.out.print(" ");

    }


    public static void main(String[] args) {
       Golomb golomb = new Golomb(16,4);
       String str = "kuzmichev semen";
        for (int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i));
            System.out.print(" ");
            //golomb.makeCode(str.charAt(i));
        }
        System.out.println("");
        for (int i = 0; i < str.length(); i++){
            System.out.print((int)str.charAt(i));
            System.out.print(" ");
            //golomb.makeCode(str.charAt(i));
        }
        System.out.println("");
       for (int i = 0; i < str.length(); i++){
           //System.out.println((int)str.charAt(i));
           golomb.makeCode(str.charAt(i));
       }

    }
}
