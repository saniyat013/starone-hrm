package com.saniyat.webproject.rest;

import com.saniyat.webproject.entity.sale.Sale;
import com.saniyat.webproject.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleRestController {
    private SaleService saleService;

    @Autowired
    public SaleRestController(SaleService theSaleService) {
        saleService = theSaleService;
    }

    @GetMapping("/sales")
    public List<Sale> findAll() {
        return saleService.findAll();
    }

    @GetMapping("/sales/{saleId}")
    public Sale getSale(@PathVariable int saleId) {
        Sale theSale = saleService.findById(saleId);

        if (theSale == null) {
            throw new RuntimeException("Sale id not found - " + saleId);
        }

        return theSale;
    }

    @PostMapping("/sales")
    public Sale addSale(@RequestBody Sale theSale) {
        theSale.setId(0);
        Sale dbSale = saleService.save(theSale);
        return dbSale;
    }

    @PutMapping("/sales")
    public Sale updateSale(@RequestBody Sale theSale) {
        Sale dbSale = saleService.save(theSale);
        return dbSale;
    }

    @DeleteMapping("sales/{saleId}")
    public String deleteSale(@PathVariable int saleId) {
        Sale tempSale = saleService.findById(saleId);
        if (tempSale == null) {
            throw new RuntimeException("Sale id not found - " + saleId);
        }
        saleService.deleteById(saleId);
        return "Deleted sale with id - " + saleId;
    }
}
