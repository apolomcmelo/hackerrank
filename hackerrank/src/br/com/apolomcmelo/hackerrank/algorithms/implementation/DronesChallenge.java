package br.com.apolomcmelo.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;

public class DronesChallenge implements IChallenge {

    private List<Integer> solveChallenge(Integer numberOfRequiredDrones, List<Drone> drones, List<Integer> inMaintenanceDrones) {

        List<Drone> availableDrones = (List<Drone>) drones.stream()
                                                            .filter(dr -> !inMaintenanceDrones.contains(dr.getId()))
                                                            .sorted((f1, f2) -> Integer.compare(f2.getFlightRange(), f1.getFlightRange()))
                                                            .limit(numberOfRequiredDrones)
                                                            .collect(Collectors.toList());
        return availableDrones.stream().map(drone -> drone.getId()).collect(Collectors.toList());
    }

    @Override
    public void execute(Input input) {

        int numberOfDrones = input.getData().nextInt();
        int numberOfRequiredDrones = input.getData().nextInt();
        int numberOfDronesInMaintenance = input.getData().nextInt();

        List<Drone> drones = new ArrayList<>();
        List<Integer> inMaintenanceDrones = new ArrayList<>();
   
        for(int i=0; i< numberOfDrones; i++) {
            drones.add(new Drone(input.getData().nextInt(), input.getData().nextInt()));
        }

        for(int i=0; i< numberOfDronesInMaintenance; i++) {
            inMaintenanceDrones.add(input.getData().nextInt());
        }

        List<Integer> greatestFlightRangeDrones = solveChallenge(numberOfRequiredDrones, drones, inMaintenanceDrones);

        for(int i=0; i < greatestFlightRangeDrones.size(); i++) {
            System.out.println(greatestFlightRangeDrones.get(i));
        }
    }
    
    private static class Drone {
        private int id;
        private int flightRange;

        public Drone(int id, int flightRange) {

            this.id = id;
            this.flightRange = flightRange;
        }

        public int getId() {
            return id;
        }

        public int getFlightRange() {
            return flightRange;
        }
    }

}
