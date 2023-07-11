package crypto;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("\"HELLO WORLD\""));
		assertFalse(CryptoManager.isStringInBounds("hello world"));
		assertFalse(CryptoManager.isStringInBounds("<HELLO"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE < IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("see", 3));
		assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
		assertEquals("a6", CryptoManager.caesarEncryption("HELLO", 106));
		assertEquals("8.719", CryptoManager.caesarEncryption("WORLD", 105));
		assertEquals("BDDM", CryptoManager.caesarEncryption("ZZZZ", 4));
		assertEquals("WKLVLVDWHVW", CryptoManager.caesarEncryption("THIS IS A TEST", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("ZZZZ", CryptoManager.caesarDecryption("BDDM", 4));
		assertEquals("THIS IS A TEST STRING", CryptoManager.caesarDecryption(";;::;;6<6=8<;6>=;;::;;", 1000));
		assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("OLSSV^VYRL", 300));
		assertEquals("THIS IS A TEST", CryptoManager.caesarDecryption("WKLVLVDWHVW", 3));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("Z^d^cb_", CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("Z:;>><:=:", CryptoManager.bellasoEncryption("HAPPY NEW YEAR", "HELLO"));
		assertEquals("::;;==<><=;;:::", CryptoManager.bellasoEncryption("THIS IS A TEST", "CMSC203"));
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager.bellasoDecryption("Z^d^cb_", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("HAPPY NEW YEAR", CryptoManager.bellasoDecryption("Z:;>><:=:", "HELLO"));
		assertEquals("THIS IS A TEST", CryptoManager.bellasoDecryption("::;;==<><=;;:::", "CMSC203"));
	}
}