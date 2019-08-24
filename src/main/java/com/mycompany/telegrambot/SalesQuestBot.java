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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SalesQuestBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        /*   if (update.hasMessage() && update.getMessage().hasText()) {
        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(update.getMessage().getChatId())
                .setText(update.getMessage().getText()); */
        String command = update.getMessage().getText();
        
        SendMessage message = new SendMessage() ;
        
        if (command.equals("/share"))
        {
            ServicioBot servicio = new ServicioBot();
             
            List<Usuario> uList = servicio.demeUsuarios();
            for(Usuario us:uList){
                message.setText("Disfruta de estas nuevas promociones: " + "https://salesquest.website");
                message.setChatId(us.getChatid());
                try {
                    execute(message);
                } catch (TelegramApiException ex) {
                    Logger.getLogger(SalesQuestBot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        if (command.equals("/subscribe"))
        {
            ServicioBot serv = new ServicioBot();
            Usuario u = new Usuario(update.getMessage().getChatId(),update.getMessage().getFrom().getFirstName());
            serv.crearUsuario(u);
        }
      
    }


public String getBotUsername() {
        return "SalesQuestBot";
    }

    public String getBotToken() {
        return "937017422:AAGugmUclUtyyj9NRG40sUK5U4vBt99W8iM";
    }
    
}
