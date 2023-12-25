package com.surya.controller;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class CryptoUtils {
	
	static String privateKeyString = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCylDDM/WtiuANDQbr5OC3MDomo77jhmWGF6+2tlzF9EpU8R35y7zxCkzDuwIjV68yhM26EONgMTTGrLoAgN0JQVY6dXHXZCp4VYz7FBQ3KCC8h3/IeRK3gZOQa227t06TLK1ibC/MgmLmj+AWZOL0VfuOpXrSbD4o6SAJ3CG288wEHPzEIcIhaBsb0tNtdRzPPTCb5EMGeMiAHG+z3/vpmATiSv/jbqbmbqKY8s9YXeXD8hLROGUZDA1nN2AFO2QNKC4Z7R+simn5lPU9OSPylnVNL+7RqTU+c95yRJE494ndfZogOGsTu5+qRjLil5ALM7xmZ+HElNtckiEEdp5Y3AgMBAAECggEALCnA3dkoRvwp9maZhkux676GpcxPJR+pAhUkLONwvjUrygIGUAdBGFfNaKYd0QWlEBKnmLR0Haqzh1mTHyR7VmGqSNlWXawmBzUJj3DeBaI7gb2f44Npms5oqQmuZ8uI/CPGoGV2pY+PjXDndYqWHGxKghblRFm1/g7T6Tsg5HKseEqjaP6QH1Pnss1MWS4QTBxK2ciHuiOyd41mcqVOWowqsPGqxOByS/nlDw4RiYzbbnHpEVt1k2yx01Dk+R/6iXrJTDztHTaWzFQICjYdxDPLs3zwFblugHGzM1queNzCTmmCGmsT36RRwLN6CH8PMo1zHvHQbEzHxO5S+5s+mQKBgQDcF/B0m/b82CKeSN8zqEkJSMcK3Ea7oeuDD/kpMCj+7ub4rXSGwHTeSvDBnfXihXYcZU98IePN15onkbCJC913ztzMGNTbgXjfGQtPBTVFjgbYXtUzeJ6ni68nIrYBt6iRPmwezP0USV/9jG5AZ9IQCFgbIU78GzYPq+ZCdHtMWQKBgQDPtmtqtpoUxN7DsISVhvGFv2WbY3162eQW1Db9jv40ZK9gM/LtIlGb6i5ZKFTjdRoFPSmF3WYEkmOb009zXWaYDgZmDcisUrSGYdBNYLZFev5f1UwqhLAA4LOsiCvBtTiTz0XTK4FeX8K9pGDCHejiv/eoW5mRwLvnP2vXqedlDwKBgHb5jedLRCmMILKVy+pdxxV4vPgW+TmGnwwbP2JPgWnF9R9qjHonYUWlFx5i6D9KS/2vmlcM7tsf+Fn5fIeo3VBdh6fgqHf8Nj3LiPxvYUu3KeYe5XtMcd86ODWcouysvje9ma7QuuIThAtItXSlar119UK9L7hCcWfpUbCMzPYJAoGBAJUYOe51eBAkaEpLMEAshr0cb5CkT3OZZ5HDbl1/AJUXGJOTdnIkyjOCWxaATr6eVbkg9+cwzoPFmF5HxaXnizbmCk3C4yJek1pKZ7zDCNLCwEiF0JBMghF/OTlE3TPEIwJmK5ayib/2ONDrZtCvq3TnmptsdMUcdUQ+T+iT+padAoGADibk+0zIjPIIIHMpbFkkqfho38POSmgzuLyi+B8V1JORws+TJh7SfaVXWqUrIw7U0QBDpf3S61aqRhHuccMWPEGUcsfyK4KbelZnxV+OVqAhEU0OYcVw5VpPof8Kpohd4P+eB/Jxe1kMhP5fiSCkphebY6i8bL0M6ulnbKdx7D4=";
	
	   public static byte[] decrypt(byte[] encryptedData) throws Exception {
		   PrivateKey privateKey = getPrivateKeyFromString(privateKeyString);
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.DECRYPT_MODE, privateKey);
	        byte[] decryptedBytes = cipher.doFinal(encryptedData);
	        return decryptedBytes;
	    }
	   
	    // Convert a Base64-encoded private key string to PrivateKey
	    public static PrivateKey getPrivateKeyFromString(String privateKeyBase64) throws Exception {
	        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        return keyFactory.generatePrivate(keySpec);
	    }
}
