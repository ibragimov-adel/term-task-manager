package ru.kpfu.itis.termtaskmanager.services;

import okhttp3.*;
import okhttp3.Request.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TelegramServiceImpl implements TelegramService {

    @Value("${telegram.token}")
    private String token;

    @Autowired
    private OkHttpClient okHttpClient;

    @Override
    public void sendMessage(String chatId, String message) {
        StringBuilder url = new StringBuilder();
        url.append("https://api.telegram.org/bot");
        url.append(token);
        url.append("/sendMessage?chat_id=");
        url.append(chatId);
        url.append("&text=");
        url.append(message);
        url.append("&parse_mode=HTML");
        Request request = new Builder().url(url.toString()).build();
        try {
            okHttpClient.newCall(request).execute();
        } catch (IOException ignored) {
        }
    }
}
