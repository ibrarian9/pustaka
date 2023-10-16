package org.sdarc.pustaka.controllers;

import org.sdarc.pustaka.models.Anggota;
import org.sdarc.pustaka.repositories.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anggota")
public class AnggotaController {

    @Autowired
    AnggotaRepository repo;

    //    Make New Data Anggota
    @PostMapping("/buat-baru")
    public @ResponseBody Anggota buatAnggotaBaru(
            @RequestParam String nama,
            @RequestParam String email,
            @RequestParam String nomorHp,
            @RequestParam String jk
    ) {
        Anggota a = new Anggota();
        a.nama = nama;
        a.email = email;
        a.nomorHp = nomorHp;
        a.jk = jk;
        repo.save(a);
        return a;
    }

    //    Search and Get Data by id
    @GetMapping("/{id}")
    public Anggota cariSatuAnggota(@PathVariable("id") String nomor){
        return repo.findById(nomor).orElse(null);
    }

    //    Edit Data by id
    @PutMapping("/{id}")
    public Anggota ubahSatuAnggotaById(
            @PathVariable("id") String nomor,
            @RequestParam String nama,
            @RequestParam String email,
            @RequestParam String nomorHp,
            @RequestParam String jk
    ) {
        Anggota a = repo.findById(nomor).orElse(null);

        a.nama = nama;
        a.email = email;
        a.nomorHp = nomorHp;
        a.jk = jk;
        repo.save(a);
        return a;
    }

    //   Delete data by id
    @DeleteMapping("/{id}")
    public Anggota hapusSatuAnggotaById(@PathVariable("id") String nomor) {
        Anggota a = repo.findById(nomor).orElse(null);
        assert a != null;
        repo.delete(a);
        return a;
    }

}
