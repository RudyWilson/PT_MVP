package com.akvasov.android.paintbolltrainermvp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by alex on 29.07.15.
 */
public class Game {

    private Integer state = 0;
    private Random rnd = new Random();
    private List<Integer> unused = new ArrayList<>();

    public Game() {
        for (Integer i = 1; i <=3; i++) {
            unused.add(i);
        }
    }

    public Integer getNewBarrier () {
        if (unused.size() == 0) return -1;
        int index = rnd.nextInt(unused.size());
        state = unused.get(index);
        unused.remove(index);
        return state;
    }

    public Boolean isOver() {
        return unused.size() == 0;
    }
}
