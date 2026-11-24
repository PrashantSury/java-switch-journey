package com.prashant.dailytests.redo;

import com.prashant.dsa.stack.ScoreOfParenthesesContract;

/** Runs the shared ScoreOfParenthesesContract cases against {@code ScoreOfParenthesesRedoNov16}. */
class ScoreOfParenthesesRedoNov16Test extends ScoreOfParenthesesContract {
    @Override
    protected Solver newSolver() { return new ScoreOfParenthesesRedoNov16()::scoreOfParentheses; }
}
