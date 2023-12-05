package com.saniyat.webproject.service;

import com.saniyat.webproject.entity.sale.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> findAll();

    Sale findById(int theId);

    Sale save(Sale theSale);

    void deleteById(int theId);
}
