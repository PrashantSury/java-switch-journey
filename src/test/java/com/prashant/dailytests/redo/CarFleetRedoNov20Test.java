package com.prashant.dailytests.redo;

import com.prashant.dsa.stack.CarFleetContract;

/** Runs the shared CarFleetContract cases against {@code CarFleetRedoNov20}. */
class CarFleetRedoNov20Test extends CarFleetContract {
    @Override
    protected Solver newSolver() { return new CarFleetRedoNov20()::carFleet; }
}
