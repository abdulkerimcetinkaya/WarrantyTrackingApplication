package dev.kerim.service;

import dev.kerim.entities.Warranty;
import dev.kerim.repository.IWarrantyRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyService {

    private final IWarrantyRepository iWarrantyRepository;

    public Warranty saveWarranty(Warranty warranty) {
        checkWarrantyStatus(warranty);
        return iWarrantyRepository.save(warranty);
    }

    public Warranty updateWarranty(Warranty warranty) {
        checkWarrantyStatus(warranty);
        return iWarrantyRepository.save(warranty);
    }

    public void deleteWarranty(Long id) {
        iWarrantyRepository.deleteById(id);
    }

    public List<Warranty> getAllWarranties() {
        return iWarrantyRepository.findAll();
    }

    public Warranty getWarrantyById(Long id) {
        return iWarrantyRepository.findById(id).orElse(null);
    }

    private void checkWarrantyStatus(Warranty warranty) {
        LocalDate purchaseDate = warranty.getPurchaseDate();
        LocalDate currentDate = LocalDate.now();

        if (purchaseDate != null) {
            long yearsBetween = ChronoUnit.YEARS.between(purchaseDate, currentDate);
            if (yearsBetween >= 2) {
                warranty.setWarrantyStatus("Warranty Expired");
            } else {
                warranty.setWarrantyStatus("Warranty Valid");
            }
        } else {
            warranty.setWarrantyStatus("Purchase Date Not Provided");
        }
    }
}
