package TemplatePattern;

abstract class ComputationTemplate {
    public final int perfomOperation(int operand1, int operand2) {

        int result = 0;

        result = operation1(operand1, operand2);
        result = operation2(result);

        return result;
    }

    abstract int operation1(int operand1, int operand2);

    public final int operation2(int result) {
        return 2*result;
    }
}