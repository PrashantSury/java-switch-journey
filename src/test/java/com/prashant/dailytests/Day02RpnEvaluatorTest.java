package com.prashant.dailytests;


/** Runs the shared Day02RpnEvaluatorContract cases against {@code Day02RpnEvaluator}. */
class Day02RpnEvaluatorTest extends Day02RpnEvaluatorContract {
    @Override
    protected int evaluate(String[] tokens) { return Day02RpnEvaluator.evaluate(tokens); }
}
