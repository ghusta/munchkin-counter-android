package com.datarockets.mnchkn.store;

import com.datarockets.mnchkn.models.Player;

public interface GameService {
    public void insertStep(Player player);
    public void clearSteps();
}
