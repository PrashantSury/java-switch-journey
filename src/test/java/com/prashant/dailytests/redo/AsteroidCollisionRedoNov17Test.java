package com.prashant.dailytests.redo;

import com.prashant.dsa.stack.AsteroidCollisionContract;

/** Runs the shared AsteroidCollisionContract cases against {@code AsteroidCollisionRedoNov17}. */
class AsteroidCollisionRedoNov17Test extends AsteroidCollisionContract {
    @Override
    protected Solver newSolver() { return new AsteroidCollisionRedoNov17()::asteroidCollision; }
}
