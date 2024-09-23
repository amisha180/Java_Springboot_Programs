/*package WorkExperience_3years.Spiro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class UnitTestLeadCreation {

        @Mock
        private LeadRepository leadRepository;

        @InjectMocks
        private LeadService leadService;

        @Test
        public void testCreateLead() {
            // Arrange
            String customerId = "cust123";
            String vehicleId = "veh456";
            Lead lead = new Lead(customerId, vehicleId, LeadStatus.NEW);

            // Mock the save operation
            when(leadRepository.save(any(Lead.class))).thenReturn(lead);

            // Act
            Lead result = leadService.createLead(customerId, vehicleId);

            // Assert
            assertNotNull(result);
            assertEquals(customerId, result.getCustomerId());
            assertEquals(vehicleId, result.getVehicleId());
            assertEquals(LeadStatus.NEW, result.getStatus());

            // Verify that the repository's save method was called exactly once
            verify(leadRepository, times(1)).save(any(Lead.class));
        }
    }
 */
