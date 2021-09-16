package com.thanthu.thread.coordination.complexcalculation;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		ComplexCalculation complexCalculation = new ComplexCalculation();
		System.out.println(complexCalculation.calculateResult(BigInteger.TWO, BigInteger.TEN, BigInteger.TEN, BigInteger.TWO));
	}

}
