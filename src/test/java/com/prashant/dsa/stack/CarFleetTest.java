package com.prashant.dsa.stack;


/** Runs the shared CarFleetContract cases against {@code CarFleet}. */
class CarFleetTest extends CarFleetContract {
    @Override
    protected Solver newSolver() { return new CarFleet()::carFleet; }
}
