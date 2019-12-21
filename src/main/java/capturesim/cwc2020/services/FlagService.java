package capturesim.cwc2020.services;

import capturesim.cwc2020.scores.Flag;

import java.util.List;

public class FlagService {

    private final List<Flag> flags;

    FlagService(List<Flag> flags) {
        this.flags = flags;
    }

    public Flag find(String name) {
        return flags
            .stream()
            .filter(flag -> flag.getName().equals(name))
            .findFirst()
            .orElse(new Flag("Empty Flag", 0));
    }
}
