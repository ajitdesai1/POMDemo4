package com.POMDemo4.qa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.POMDemo4.qa.base.Base;

public class RetryListenerClass extends Base implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod)	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		if (retry == null)	{
			testannotation.setRetryAnalyzer(RetryFailedTestCases.class);
		}

	}

}

