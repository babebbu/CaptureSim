package capturesim.cwc2020.services;

import capturesim.cwc2020.scores.Hill;

import java.util.List;

public class HillService {

    private final List<Hill> hills;

    HillService(List<Hill> hills) {
        this.hills = hills;
    }

    public List<Hill> all() {
        return hills;
    }

    public Hill find(String name) {
        return hills
            .stream()
            .filter(hill -> hill.getName().equals(name))
            .findFirst()
            .orElse(new Hill("Abandoned Hills", 0, 0, 0, 0, 0, 0, 0));
    }

}
