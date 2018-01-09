package com.crfchina.cdg.common.utils;

import com.crfchina.cdg.common.enums.common.SignatureAlgorithm;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 * 签名验签类
 */
public class SignatureUtils {

	private static final String RSA = "RSA";
	
	private static final Charset DEFAULT_CHARSET = Charset.forName("utf-8");

	public static KeyPair generateRsaKeyPair(int keySize)
			throws NoSuchAlgorithmException {

		KeyPairGenerator keyPairGen = null;
		keyPairGen = KeyPairGenerator.getInstance(RSA);

		keyPairGen.initialize(keySize, new SecureRandom());
		KeyPair keyPair = keyPairGen.generateKeyPair();

		return keyPair;
	}

	public static PublicKey getRsaX509PublicKey(byte[] encodedKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		KeyFactory keyFactory = KeyFactory.getInstance(RSA);
		return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
	}

	public static PrivateKey getRsaPkcs8PrivateKey(byte[] encodedKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		KeyFactory keyFactory = KeyFactory.getInstance(RSA);
		return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
	}
	
	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
							  String data)
			throws GeneralSecurityException {
		return sign(algorithm, privateKey, data, DEFAULT_CHARSET);
	}

	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
			String data, String charset)
			throws GeneralSecurityException {
		return sign(algorithm, privateKey, data.getBytes(Charset.forName(charset)));
	}
	
	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
			String data, Charset charset)
			throws GeneralSecurityException {
		return sign(algorithm, privateKey, data.getBytes(charset));
	}

	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
			byte[] data) throws GeneralSecurityException {
		ByteArrayInputStream input = new ByteArrayInputStream(data);
		try {
			return sign(algorithm, privateKey, input);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

	public static byte[] sign(SignatureAlgorithm algorithm, PrivateKey privateKey,
			InputStream data) throws GeneralSecurityException,
			IOException {

		Signature signature = Signature.getInstance(algorithm
				.getSignAlgorithm());

		signature.initSign(privateKey);
		doUpdate(signature, data);

		return signature.sign();
	}
	
	public static boolean verify(SignatureAlgorithm algorithm, PublicKey publicKey,
			String data, byte[] sign)
			throws GeneralSecurityException, UnsupportedEncodingException {
		return verify(algorithm, publicKey,
				data, DEFAULT_CHARSET, sign);
	}

	public static boolean verify(SignatureAlgorithm algorithm, PublicKey publicKey,
			String data, String charset, byte[] sign)
			throws GeneralSecurityException, UnsupportedEncodingException {
		return verify(algorithm, publicKey,
				data.getBytes(Charset.forName(charset)), sign);
	}
	
	public static boolean verify(SignatureAlgorithm algorithm, PublicKey publicKey,
			String data, Charset charset, byte[] sign)
			throws GeneralSecurityException {
		return verify(algorithm, publicKey,
				data.getBytes(charset), sign);
	}

	public static boolean verify(SignatureAlgorithm algorithm, PublicKey publicKey, byte[] data,
			byte[] sign) throws GeneralSecurityException {
		ByteArrayInputStream input = new ByteArrayInputStream(data);
		try {
			return verify(algorithm, publicKey, input, sign);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

	public static boolean verify(SignatureAlgorithm algorithm, PublicKey publicKey,
			InputStream input, byte[] sign)
			throws GeneralSecurityException, IOException {

		Signature signature = Signature.getInstance(algorithm.getSignAlgorithm());

		signature.initVerify(publicKey);
		doUpdate(signature, input);

		return signature.verify(sign);
	}

	private static void doUpdate(Signature signature, InputStream input)
			throws IOException, SignatureException {

		byte[] buf = new byte[4096];

		int c = 0;
		do {
			c = input.read(buf);

			if (c > 0) {
				signature.update(buf, 0, c);
			}
		} while (c != -1);
	}

	public static boolean checkSign(String sign, String signData) {
		//验签
		AppConfig config = AppConfig.getConfig();
		PublicKey publicKey = null;
		try {
			publicKey = SignatureUtils.getRsaX509PublicKey(Base64
					.decodeBase64(config.getLmPublicKey()));
			boolean verify = SignatureUtils.verify(
					SignatureAlgorithm.SHA1WithRSA, publicKey, signData,
					Base64.decodeBase64(sign));
			return verify;
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
