/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.telegrambot;

/**
 *
 * @author Kainthel
 */

import java.util.List;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Tester {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new SalesQuestBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        
         
       
        
        
    }

    }
    

