package dev.mcodex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;

public class AES256Cipher {
  private static final byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

  public static byte[] encrypt(byte[] keyBytes, byte[] textBytes)
    throws java.io.UnsupportedEncodingException,
    NoSuchAlgorithmException,
    NoSuchPaddingException,
    InvalidKeyException,
    InvalidAlgorithmParameterException,
    IllegalBlockSizeException,
    BadPaddingException {

    AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
    SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
    Cipher cipher = null;
    cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
    return cipher.doFinal(textBytes);
  }

  public static byte[] decrypt(byte[] keyBytes, byte[] textBytes)
    throws java.io.UnsupportedEncodingException,
    NoSuchAlgorithmException,
    NoSuchPaddingException,
    InvalidKeyException,
    InvalidAlgorithmParameterException,
    IllegalBlockSizeException,
    BadPaddingException {

    AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
    SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
    return cipher.doFinal(textBytes);
  }
}