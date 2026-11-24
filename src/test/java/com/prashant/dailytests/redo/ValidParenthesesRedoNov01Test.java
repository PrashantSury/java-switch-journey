package com.prashant.dailytests.redo;

import com.prashant.dsa.stack.ValidParenthesesContract;

/** Runs the shared ValidParenthesesContract cases against {@code ValidParenthesesRedoNov01}. */
class ValidParenthesesRedoNov01Test extends ValidParenthesesContract {
    @Override
    protected boolean isValid(String s) { return ValidParenthesesRedoNov01.isValid(s); }
}
