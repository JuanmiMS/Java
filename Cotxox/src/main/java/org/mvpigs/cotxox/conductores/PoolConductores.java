package org.mvpigs.cotxox.conductores;

import java.util.ArrayList;

public class PoolConductores {

    private ArrayList<Conductor> poolConductores = new ArrayList<Conductor>();

    public PoolConductores(ArrayList<Conductor> poolConductores) {
        this.poolConductores = poolConductores;
    }
}
