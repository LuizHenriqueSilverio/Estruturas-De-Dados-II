/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luizh
 */
public class UserData {
    
    public static Map<String, User> users = new HashMap<>();

    public static void addData(User user) {
        users.put(user.getCpf(), user);
    }

    public static User getUser(String cpf) {
        return users.get(cpf);
    }
}
