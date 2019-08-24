/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.telegrambot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kainthel
 */
public abstract class Servicio {
    // JDBC driver name and database URL
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL="jdbc:mysql://localhost:3306/boot?useSSL=false"; 
    String USER="root";
    String PASS="canales00";
    Connection conn=null;
    
    
    protected void conectar(){
        try{
            //STEP 1: Register JDBC driver

            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void desconectar() throws SQLException{
        try{
            if(!conn.isClosed()){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
      }    
    }
