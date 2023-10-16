package org.sdarc.pustaka.models;

import jakarta.persistence.*;

@Entity
@Table(name = "buku")
public class Buku {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Integer id;
        @Column(name = "isbn")
        public String isbn;
        @Column(name = "judul")
        public String judul;
        @Column(name = "penulis")
        public String penulis;
        @Column(name = "penerbit")
        public String penerbit;
        @Column(name = "stok")
        public int stok;
        @Column( name = "posisi")
        public String posisi;
        @Column( name = "tahun_terbit")
        public int tahunTerbit;

}
