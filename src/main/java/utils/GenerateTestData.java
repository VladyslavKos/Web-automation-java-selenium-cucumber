package utils;

import java.util.Random;

public class GenerateTestData {
    public String generateEmail(){
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        int length = 10;
        Random random = new Random();
        StringBuilder email = new StringBuilder(length + 12); // 10 for random part, 12 for "@example.com"

        for (int i = 0; i < length; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }

        return email.append("@test.com").toString();
    }
}
