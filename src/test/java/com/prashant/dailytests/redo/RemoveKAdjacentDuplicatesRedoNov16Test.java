package com.prashant.dailytests.redo;

import com.prashant.dsa.stack.RemoveKAdjacentDuplicatesContract;

/** Runs the shared RemoveKAdjacentDuplicatesContract cases against {@code RemoveKAdjacentDuplicatesRedoNov16}. */
class RemoveKAdjacentDuplicatesRedoNov16Test extends RemoveKAdjacentDuplicatesContract {
    @Override
    protected Solver newSolver() { return new RemoveKAdjacentDuplicatesRedoNov16()::removeDuplicates; }
}
