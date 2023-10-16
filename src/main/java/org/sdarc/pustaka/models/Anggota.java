package org.sdarc.pustaka.models;

import jakarta.persistence.*;

import java.security.SecureRandom;

@Entity
@Table(name = "anggota")
public class Anggota {

        @Id
        @Column(name = "nomor")
        public String nomor;
        @Column(name = "nama")
        public String nama;
        @Column(name = "email")
        public String email;
        @Column(name = "nomor_hp")
        public String nomorHp;
        @Column(name = "jenis_kelamin")
        public String jk;

        public Anggota() {
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
