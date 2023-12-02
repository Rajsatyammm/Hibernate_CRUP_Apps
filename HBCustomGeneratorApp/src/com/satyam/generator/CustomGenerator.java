package com.satyam.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenerator implements IdentifierGenerator {

	static {
		System.out.println("CustomGenerator.class file is loaded....");
	}

	public CustomGenerator() {
		System.out.println("CustomGenerator.class file is created...");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		System.out.println("CustomGenerator.generate()..");
		int value = new Random().nextInt(10000);
		System.out.println("Random Value generated is :: " + value);
		return value;
	}

}
