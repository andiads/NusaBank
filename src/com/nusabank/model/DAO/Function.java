/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.ModelAdmin;
import com.nusabank.model.ModelNasabah;
import com.nusabank.view.viewAdmin.ViewManageAdmin;
import com.nusabank.view.viewAdmin.ViewMenuAdmin;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JFrame;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class Function {
    
   public String generateNoRek(String nmNasabah, String dob, String dj) {
        String norekResult = "1234567890";

        String a = nmNasabah;
        String b = dob;
        String c = dj;
        int hash1 = a.hashCode();
        int hash2 = b.hashCode();
        int hash3 = c.hashCode();
        String pt1 = String.valueOf(hash1).substring(1, 5);
        String pt2 = String.valueOf(hash2).substring(1, 5);
        String pt3 = String.valueOf(hash3).substring(1, 5);
        String cont = pt1 + pt2 + pt3;
        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println(hash3);
        System.out.println(pt1);
        System.out.println(pt2);
        System.out.println(pt3);
        System.out.println(cont);
        norekResult = cont;
        
        return norekResult;
    }
   
   public String uploadPhotoNasabah(ViewRegisNasabah vRegNasabah, ModelNasabah nasabah) {
    File newPath = null;
        String newFileName = "";
        try {
            String fileType = "";
            String oldFileName = vRegNasabah.getFileName();
            if (oldFileName.endsWith(".png")){
                fileType=".png";
            } else if (oldFileName.endsWith(".jpg")){
                fileType=".jpg";
            } else if (oldFileName.endsWith(".jpeg")){
                fileType=".jpeg";
            }
            
            String prefix = nasabah.getUsername();
            String mid = "_NusaBank_";
            String sufix = String.valueOf(nasabah.getTglPembuatan())
                    .replace(" ", "_")
                    .replace(":", "-");
            String destPath = "res/nasabah_photos/";
            newFileName = 
                    destPath.concat(
                        prefix.concat(
                            mid.concat(
                                sufix.concat(fileType)
                            )
                        )
                    );
            String copyNewFile = 
                    System.getProperty("user.dir")
                            .concat("/src/com/nusabank/")
                            .concat(newFileName);
            System.out.println(newFileName);
            
            File srcPhoto = new File(vRegNasabah.getLbFoto().getText());

            newPath = new File(copyNewFile);
            Files.copy(srcPhoto.toPath(), newPath.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return newFileName;
   } 
   
   public String uploadPhotoAdmin(ViewManageAdmin vma, ModelAdmin admin){
        File newPath = null;
        String newFileName = "";
        String oldFileName = vma.getFileName();
        // check if admin has photo or not, if not > set to default avatar from res
        if (!vma.getTfPhotoAdminPath().getText().isEmpty()) {
            try {
                String fileType = "";

                if (oldFileName.endsWith(".png")){
                    fileType=".png";
                } else if (oldFileName.endsWith(".jpg")){
                    fileType=".jpg";
                } else if (oldFileName.endsWith(".jpeg")){
                    fileType=".jpeg";
                }

                String prefix = admin.getUsername();
                String mid = "_NusaBank_";
                String sufix = String.valueOf(admin.getTglLahir())
                        .replace(" ", "_")
                        .replace(":", "-");
                String destPath = "res/admin_photos/";
                newFileName = 
                        destPath.concat(
                            prefix.concat(
                                mid.concat(
                                    sufix.concat(fileType)
                                )
                            )
                        );
                String copyNewFile = 
                        System.getProperty("user.dir")
                                .concat("/src/com/nusabank/")
                                .concat(newFileName);
                System.out.println(newFileName);

                File srcPhoto = new File(vma.getTfPhotoAdminPath().getText());

                newPath = new File(copyNewFile);
                Files.copy(srcPhoto.toPath(), newPath.toPath(), StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            newFileName = "";
        }
        
        return newFileName;
   }
}
