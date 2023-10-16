package org.sdarc.pustaka.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.security.SecureRandom;

@Entity
@Table(name = "petugas")
public class Petugas {

    @Id
    @Column(name = "nomor")
    public String nomor;
    @Column(name = "nama")
    public String nama;
    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;

    public Petugas() {
        this.nomor = Uuid(10);
    }

    private String Uuid(int length) {
        SecureRandom random = new SecureRandom();
        String Chara = "ABCDEFGHI123456789";
        StringBuilder idBuild = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(Chara.length());
            char randomChar = Chara.charAt(randomIndex);
            idBuild.append(randomChar);
        }
        return idBuild.toString();
    }
}

