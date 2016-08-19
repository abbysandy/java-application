package com.starter.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public abstract class HashUtil {

	private static final String HASH_ALGORITH = "SHA-256";

	public static String randomHash() throws NoSuchAlgorithmException {
		return hash(UUID.randomUUID().toString());
	}

	public static String hash(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(HASH_ALGORITH);
		md.update(input.getBytes());
		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

}
