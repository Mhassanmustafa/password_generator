import java.util.Random;
import java.util.Scanner;

public class function {
    public static final String Ualpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String Salpha ="abcdefghijklmnopqrstuvwxyz";
    public static final String special_char = "!@#$%^&";
    public static final String number = "1234567890";
    public static Random random = new Random();

    public static String pass_generator(int length, String value){
        String temp = "";
        for(int i = 0; i < length; i++){
            int index = random.nextInt(value.length());
            temp += value.charAt(index); // charAt(int index) returns the character at the specified index
        }
        return temp;
    }
}
