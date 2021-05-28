package ru.kpfu.itis.termtaskmanager.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UtilsServiceImpl implements UtilsService {
    @Override
    public String generateRandomString(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
