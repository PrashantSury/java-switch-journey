package com.prashant.dailytests.redo;

import com.prashant.dsa.stack.ValidParenthesesContract;

/** Runs the shared ValidParenthesesContract cases against {@code ValidParenthesesRedoNov08}. */
class ValidParenthesesRedoNov08Test extends ValidParenthesesContract {
    @Override
    protected boolean isValid(String s) { return ValidParenthesesRedoNov08.isValid(s); }
}
