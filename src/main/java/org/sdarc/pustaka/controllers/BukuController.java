package org.sdarc.pustaka.controllers;

import org.sdarc.pustaka.models.Buku;
import org.sdarc.pustaka.repositories.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
public class BukuController {

    @Autowired
    BukuRepository repo;

    //    Make new Data
    @PostMapping("/buat-baru")
    public @ResponseBody Buku buatSatuBuku (
            @RequestParam String isbn,
            @RequestParam String judul,
            @RequestParam String penerbit,
            @RequestParam String penulis,
            @RequestParam String posisi,
            @RequestParam int stok,
            @RequestParam int tahunTerbit
    ) {

        Buku buku = new Buku();
        buku.isbn = isbn;
        buku.judul = judul;
        buku.penulis = penulis;
        buku.penerbit = penerbit;
        buku.posisi = posisi;
        buku.stok = stok;
        buku.tahunTerbit = tahunTerbit;
        repo.save(buku);
        return buku;

    }

    //    Get all data
    @GetMapping("/")
    public List<Buku> semuaBuku() {
        return (List<Buku>) repo.findAll();
    }

    //    Search and Get Data by id
    @GetMapping("/{id}")
    public Buku cariSatuBukuById(@PathVariable("id") Integer id) {
        return repo.findById(id).orElse(null);
    }

    //    Edit Data by id
    @PutMapping("/{id}")
    public Buku ubahSatuBukuById(
            @PathVariable("id") Integer id,
            @RequestParam String isbn,
            @RequestParam String judul,
            @RequestParam String penerbit,
            @RequestParam String penulis,
            @RequestParam String posisi,
            @RequestParam int stok,
            @RequestParam int tahunTerbit
    ) {
        Buku buku = repo.findById(id).orElse(null);

        buku.isbn = isbn;
        buku.judul = judul;
        buku.penulis = penulis;
        buku.penerbit = penerbit;
        buku.posisi = posisi;
        buku.stok = stok;
        buku.tahunTerbit = tahunTerbit;
        repo.save(buku);
        return buku;
    }

    //    Delete Data
    @DeleteMapping("/{id}")
    public Buku hapusSatuBukuById(@PathVariable("id") Integer id) {
        Buku buku = repo.findById(id).orElse(null);
        assert buku != null;
        repo.delete(buku);
        return buku;
    }

}
