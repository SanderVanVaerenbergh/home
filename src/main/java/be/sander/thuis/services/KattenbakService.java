package be.sander.thuis.services;

import be.sander.thuis.domain.Kattenbak;

import java.util.List;

public interface KattenbakService {
    List<Kattenbak> findAll();
    Long countByNaam(String naam);
    List<Kattenbak> findAllByDatum();
    void create(Kattenbak kattenbak);
}
