package com.prashant.dailytests.redo;

import com.prashant.dailytests.Day02RpnEvaluatorContract;

/** Runs the shared Day02RpnEvaluatorContract cases against {@code Day02RpnEvaluatorRedo7}. */
class Day02RpnEvaluatorRedo7Test extends Day02RpnEvaluatorContract {
    @Override
    protected int evaluate(String[] tokens) { return Day02RpnEvaluatorRedo7.evaluate(tokens); }
}
