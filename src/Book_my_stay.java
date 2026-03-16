import java.util.*;

// Add-On Service class
class Service {
    private String serviceName;
    private double cost;

    public Service(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getServiceName() {
        return serviceName;
    }
}

// Manager class for Add-On Services
class AddOnServiceManager {

    // Map: Reservation ID -> List of Services
    private Map<String, List<Service>> reservationServices = new HashMap<>();

    // Add service to reservation
    public void addService(String reservationId, Service service) {
        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    // Calculate total add-on cost
    public double calculateTotalCost(String reservationId) {
        List<Service> services = reservationServices.get(reservationId);

        if (services == null) {
            return 0;
        }

        double total = 0;
        for (Service s : services) {
            total += s.getCost();
        }
        return total;
    }
}

public class Book_my_stay {

    public static void main(String[] args) {

        System.out.println("Add-on Service selection");

        String reservationId = "Single-1";

        AddOnServiceManager manager = new AddOnServiceManager();

        // Guest selects services
        manager.addService(reservationId, new Service("Spa", 800));
        manager.addService(reservationId, new Service("Airport Pickup", 700));

        double totalCost = manager.calculateTotalCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On-cost: " + (int)totalCost);
    }
}