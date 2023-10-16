package org.sdarc.pustaka.controllers;

import org.sdarc.pustaka.models.Petugas;
import org.sdarc.pustaka.repositories.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/petugas")
public class PetugasController {

    @Autowired
    PetugasRepository repo;

    // Make New Data
    @PostMapping("/buat-baru")
    public @ResponseBody Petugas buatPetugasBaru(
            @RequestParam String nama,
            @RequestParam String username,
            @RequestParam String password
    ) {
        Petugas p = new Petugas();
        p.nama = nama;
        p.username = username;
        p.password = password;
        repo.save(p);
        return p;
    }

    // Search and Get data by id
    @GetMapping("/{id}")
    public Petugas cariSatuPetugas(@PathVariable("id") String nomor) {
        return repo.findById(nomor).orElse(null);
    }

    // Edit data by id
    @PutMapping("/{id}")
    public @ResponseBody Petugas ubahPetugasBaruById(
            @PathVariable("id") String nomor,
            @RequestParam String nama,
            @RequestParam String username,
            @RequestParam String password
    ) {
        Petugas p = repo.findById(nomor).orElse(null);

        p.nama = nama;
        p.username = username;
        p.password = password;
        repo.save(p);
        return p;
    }

    // Delete Data by id
    @DeleteMapping("/{id}")
    public Petugas hapusSatuPetugasById(@PathVariable("id") String nomor) {
        Petugas p = repo.findById(nomor).orElse(null);
        assert p != null;
        repo.delete(p);
        return p;
    }
}
