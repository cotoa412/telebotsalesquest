/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.telegrambot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kainthel
 */
public class ServicioBot extends Servicio {
    
    
    public List<Usuario> demeUsuarios(){
        ResultSet rs = null;
        Statement stmt=null;
        List<Usuario> uList =new ArrayList<>();
        try{
            //STEP 3: Execute a querey
            super.conectar();
            stmt=conn.createStatement();
            String sql;
            sql="SELECT chatid, name FROM user;";
            rs=stmt.executeQuery(sql);
            //STEP 3.1: Extract data from result set
            while (rs.next()){
                //Retrieve by column name
                Long chatId = rs.getLong("chatid");
                String nombre = rs.getString("name");
                
                //Display values
             //   System.out.println("ID: "+id+", Nombre: " +nombre);
                Usuario u = new Usuario(chatId,nombre);
                uList.add(u);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                stmt.close();
                super.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return uList;
    } 
    
    public void crearUsuario(Usuario u){
        
        try{
            super.conectar();
            String sql;
            sql="INSERT INTO user (chatid, name) values (?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, u.getChatid());
            preparedStatement.setString(2, u.getNombre());
            preparedStatement.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                super.desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
      }
    
    }
}


