package ru.kpfu.itis.termtaskmanager.services;

public interface TelegramService {
    void sendMessage(String chatId, String message);
}
