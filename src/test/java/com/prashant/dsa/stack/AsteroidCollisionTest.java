package com.prashant.dsa.stack;


/** Runs the shared AsteroidCollisionContract cases against {@code AsteroidCollision}. */
class AsteroidCollisionTest extends AsteroidCollisionContract {
    @Override
    protected Solver newSolver() { return new AsteroidCollision()::asteroidCollision; }
}
