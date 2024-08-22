package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Admin;
import org.example.util.FilePathUtil;
import org.example.util.JsonUtil;

import java.util.List;
import java.util.UUID;

public class AdminService {

    public Admin add(Admin admin){
        List<Admin> admins = readJson();
        if (hasAdmin(admin.getUsername(),admin.getPassword())){
            return null;
        }
        admin.setId(UUID.randomUUID());
        admins.add(admin);
        writeJson(admins);
        return admin;
    }



    private boolean hasAdmin(String username,String password){
        List<Admin> admins = readJson();
        return admins.stream()
                .anyMatch(admin -> admin.getUsername().equals(username) && admin.getPassword().equals(password));
    }
    public Admin login(String password,UUID id){
        List<Admin> admins = readJson();
        for (Admin admin:admins){
            if (admin.getCustomerId().equals(id)){
                if (admin.getPassword().equals(password)){
                    return admin;
                }
            }
        }
        throw new  RuntimeException("admin not fount");
    }

    private List<Admin> readJson(){return JsonUtil.readGson(FilePathUtil.getAdmin(), new TypeReference<>() {});
    }

    private void writeJson(List<Admin> admins){
        JsonUtil.writeGson(admins,FilePathUtil.getAdmin());
    }
}