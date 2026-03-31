package ocean_fleet;
import java.util.ArrayList;
import java.util.List;

public class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    public List<Vessel> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }

    // Requirement 1: Add Vessel
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Requirement 2: Get Vessel by ID
    public Vessel getVesselById(String vesselId) {
        for(Vessel v : vesselList) {
            if(v.getVesselId().equals(vesselId)) {
                return v;
            }
        }
        return null;
    }

    // Requirement 3: Get High Performance Vessels
    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> result = new ArrayList<>();

        double maxSpeed = 0;
        for(Vessel v : vesselList) {
            if(v.getAverageSpeed() > maxSpeed) {
                maxSpeed = v.getAverageSpeed();
            }
        }
        for(Vessel v : vesselList) {
            if(v.getAverageSpeed() == maxSpeed) {
                result.add(v);
            }
        }
        return result;
    }
}
