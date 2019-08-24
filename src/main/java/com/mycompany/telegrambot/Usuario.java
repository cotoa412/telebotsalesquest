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
public class Usuario {
     
    private Long chatid;
    private String nombre;
    

    public Usuario(Long chatid, String nombre) {
        this.chatid = chatid;
        this.nombre = nombre;
    }
    
    

    public Long getChatid() {
        return chatid;
    }

    public void setChatid(Long chatid) {
        this.chatid = chatid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "chatid=" + chatid + ", nombre=" + nombre + '}';
    }
    
    
}
