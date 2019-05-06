import java.util.Random;

public class Generator {
    private final String[] chars = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "abcdefghijklmnopqrstuvwxyz", "!@#$%^&", "1234567890"};
    private Random random = new Random();

    public String generate(int length, boolean options[]) {
        int char_index, index;
        String temp = "";
        for (int i = 0; i < length ; i++) {
            char_index = random.nextInt(chars.length);
            if (options[char_index]) {
                index = random.nextInt(chars[char_index].length());
                temp += chars[char_index].charAt(index);
            } else {
                --i;
            }
        }
        return temp;
    }
}
