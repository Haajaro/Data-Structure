
package company;

public class HospitalMedicalBillingSystem {

    // Abstract parent class for all medical services
    static abstract class MedicalService {
        protected String serviceId;
        protected String serviceName;
        protected double baseCost;

        // Constructor initializes common service information
        MedicalService(String serviceId, String serviceName, double baseCost) {
            this.serviceId = serviceId;
            this.serviceName = serviceName;
            this.baseCost = baseCost;
        }

        // Abstract method
        abstract double calculateTotalCost();

        // Concrete method
        void displayServiceInfo() {
            System.out.println("Service ID: " + serviceId);
            System.out.println("Service: " + serviceName);
            System.out.printf("Total Cost: $%.2f%n", calculateTotalCost());
        }
    }

    // Subclass for medical consultation services
    static class Consultation extends MedicalService {
        double doctorFee;

        // Calls the parent constructor using super()
        Consultation(String id, double baseCost, double doctorFee) {
            super(id, "Consultation", baseCost);
            this.doctorFee = doctorFee;
        }

        // Calculates consultation cost including doctor fee
        @Override
        double calculateTotalCost() {
            return baseCost + doctorFee;
        }
    }

    // Subclass for laboratory testing services
    static class LaboratoryTest extends MedicalService {
        double testCharge;

        // Initializes laboratory test details
        LaboratoryTest(String id, double baseCost, double testCharge) {
            super(id, "Laboratory Test", baseCost);
            this.testCharge = testCharge;
        }

        // Calculates laboratory cost including test charge
        @Override
        double calculateTotalCost() {
            return baseCost + testCharge;
        }
    }

    // Subclass for ultrasound services
    static class Ultrasound extends MedicalService {
        double additionalFee;

        // Initializes ultrasound service details
        Ultrasound(String id, double baseCost,
                   double additionalFee) {
            super(id, "Ultrasound", baseCost);
            this.additionalFee = additionalFee;
        }

        // Calculates ultrasound cost including additional fee
        @Override
        double calculateTotalCost() {
            return baseCost + additionalFee;
        }
    }

    // Main method: program execution starts here
    public static void main(String[] args) {

        // Polymorphism: stores different services in one array
        MedicalService[] services = {
                new Consultation("S001", 15, 10),
                new LaboratoryTest("S002", 10, 8),
                new Ultrasound("S003", 30, 10)
        };

        // Variable to store the total hospital bill
        double totalBill = 0;

        // Displays the hospital billing report heading
        System.out.println("===== HOSPITAL BILLING SYSTEM =====");

        // Displays each service and adds its cost to the bill
        for (MedicalService service : services) {
            System.out.println();
            service.displayServiceInfo();
            totalBill += service.calculateTotalCost();
        }

        // Displays the final hospital bill
        System.out.println();
        System.out.println("------------------------------");
        System.out.printf("Total Hospital Bill: $%.2f%n", totalBill);
    }
}
