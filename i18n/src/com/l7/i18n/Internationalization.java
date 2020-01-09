package com.l7.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalization {

	private static final String MESSAGE_FILE = "com.l7.core.i18n.Messages";
	public static void main(String[] args) {

		System.out.println(Locale.getDefault());
		
		ResourceBundle bundle = ResourceBundle.getBundle(MESSAGE_FILE);
		ResourceBundle bundleFR = ResourceBundle.getBundle(MESSAGE_FILE, Locale.FRANCE);
		ResourceBundle bundleJP = ResourceBundle.getBundle(MESSAGE_FILE, Locale.JAPAN);
		ResourceBundle bundleUS = ResourceBundle.getBundle(MESSAGE_FILE, Locale.US);
		ResourceBundle bundleCH = ResourceBundle.getBundle(MESSAGE_FILE, Locale.CHINA);
		
		printMessages(bundle);
		printMessages(bundleFR);
		printMessages(bundleJP);
		printMessages(bundleUS);
		printMessages(bundleCH);
		
	}
	private static void printMessages(ResourceBundle bundle) {
		System.out.println("country name:" + bundle.getString("CountryName"));
		System.out.println("Currency:" + bundle.getString("Currency"));
	}
}
