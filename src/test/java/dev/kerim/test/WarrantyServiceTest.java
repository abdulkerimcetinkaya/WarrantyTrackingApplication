package dev.kerim.test;

import dev.kerim.entities.Warranty;
import dev.kerim.repository.IWarrantyRepository;
import dev.kerim.service.WarrantyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;



public class WarrantyServiceTest {

    @InjectMocks
    private WarrantyService warrantyService;

    @Mock
    private IWarrantyRepository warrantyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testWarrantyExpired() {
        // Given
        Warranty warranty = new Warranty();
        warranty.setPurchaseDate(LocalDate.now().minusYears(2).minusDays(1));

        // When
        Mockito.when(warrantyRepository.save(warranty)).thenReturn(warranty);
        Warranty savedWarranty = warrantyService.saveWarranty(warranty);

        // Then
        Assertions.assertEquals("Warranty Expired", savedWarranty.getWarrantyStatus());
    }

    @Test
    void testWarrantyValid() {
        // Given
        Warranty warranty = new Warranty();
        warranty.setPurchaseDate(LocalDate.now().minusYears(1));

        // When
        Mockito.when(warrantyRepository.save(warranty)).thenReturn(warranty);
        Warranty savedWarranty = warrantyService.saveWarranty(warranty);

        // Then
        Assertions.assertEquals("Warranty Valid", savedWarranty.getWarrantyStatus());
    }

    @Test
    void testWarrantyNoPurchaseDate() {
        // Given
        Warranty warranty = new Warranty();

        // When
        Mockito.when(warrantyRepository.save(warranty)).thenReturn(warranty);
        Warranty savedWarranty = warrantyService.saveWarranty(warranty);

        // Then
        Assertions.assertEquals("Purchase Date Not Provided", savedWarranty.getWarrantyStatus());
    }
}
