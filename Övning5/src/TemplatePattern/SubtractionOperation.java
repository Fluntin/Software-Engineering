package TemplatePattern;

public class SubtractionOperation extends ComputationTemplate {

    @Override
    int operation1(int operand1, int operand2) {
        return operand1 - operand2;
    }

}
