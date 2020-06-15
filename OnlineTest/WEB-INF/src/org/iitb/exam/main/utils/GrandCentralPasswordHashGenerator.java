/**
 * 
 */
package org.iitb.exam.main.utils;

import grandcentral.security.SimpleCrypto;

import org.apache.log4j.Logger;

/**
 * @author deepak
 *
 */
public class GrandCentralPasswordHashGenerator {

	static final Logger logger = Logger.getLogger(GrandCentralPasswordHashGenerator.class);
	private static GrandCentralPasswordHashGenerator encrypt = null;
	/**
	 * 
	 */
	public static GrandCentralPasswordHashGenerator GetInstance() {
		if(encrypt == null) {
			encrypt = new GrandCentralPasswordHashGenerator();
		}
		return encrypt;
	}
	public String hashPasswordToSHA512(String password) {
		logger.info("Entered password is : "+password);
		SimpleCrypto.setAlgorithm("SHA-512");
		SimpleCrypto.setPath(null);
		SimpleCrypto.setText(password);
		String pass = new SimpleCrypto().generateDigest();
		logger.info("Encrypted password is : "+pass);
		return pass;
	}
	public static void main(String[] args) {
		GrandCentralPasswordHashGenerator g = new GrandCentralPasswordHashGenerator();
		g.hashPasswordToSHA512("deepak");
	}
}