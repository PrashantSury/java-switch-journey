package com.prashant.dsa.stack;


/** Runs the shared ScoreOfParenthesesContract cases against {@code ScoreOfParentheses}. */
class ScoreOfParenthesesTest extends ScoreOfParenthesesContract {
    @Override
    protected Solver newSolver() { return ScoreOfParentheses::scoreOfParentheses; } // static in the original
}
