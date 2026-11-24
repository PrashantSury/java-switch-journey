package com.prashant.dsa.stack;


/** Runs the shared RemoveKAdjacentDuplicatesContract cases against {@code RemoveKAdjacentDuplicates}. */
class RemoveKAdjacentDuplicatesTest extends RemoveKAdjacentDuplicatesContract {
    @Override
    protected Solver newSolver() { return new RemoveKAdjacentDuplicates()::removeDuplicates; }
}
