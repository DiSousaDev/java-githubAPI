/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author ederc
 */
public class GitHubAPI {

    public User getUser(String login) {

        try {

            String url = "https://api.github.com/users/" + login;

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }

            conn.disconnect();

            Gson gson = new Gson();
            User dados = gson.fromJson(new String(output.getBytes()), User.class);

            User user = new User();
            
                       
            user.setId(dados.getId());
            user.setName(dados.getName());
            user.setLogin(dados.getLogin());
            user.setHtml_url(dados.getHtml_url());
            user.setAvatar_url(dados.getAvatar_url());
            user.setLocation(dados.getLocation());
            user.setCreated_at(dados.getCreated_at());
                
            return user;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter informações" + e);

        }
        return null;
    }
}
