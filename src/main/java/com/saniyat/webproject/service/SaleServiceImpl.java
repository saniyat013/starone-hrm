package com.saniyat.webproject.service;

import com.saniyat.webproject.dao.SaleRepository;
import com.saniyat.webproject.entity.sale.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {
    private SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository theSaleRepository) {
        saleRepository = theSaleRepository;
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale findById(int theId) {
        Optional<Sale> result = saleRepository.findById(theId);

        Sale theSale = null;
        if (result.isPresent()) {
            theSale = result.get();
        } else {
            throw new RuntimeException("Did not find the sale with id - " + theId);
        }
        return theSale;
    }

    @Override
    public Sale save(Sale theSale) {
        return saleRepository.save(theSale);
    }

    @Override
    public void deleteById(int theId) {
        saleRepository.deleteById(theId);
    }
}
