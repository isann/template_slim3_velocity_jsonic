package info.isann.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class HashUtils {

	private static final Logger logger = Logger.getLogger(HashUtils.class.getName());

	/** ハッシュアルゴリズム */
	private static final String ALG = "SHA-256";
	/** ソルトに用いる固定時文字列（サイト毎に変更してください） */
	private static final String FIXEDSALT = "ei429jerunf096ejio3zxzqoi3905kjfj8heo";

	//		//同じパスワードでもユーザＩＤにより違うハッシュ値が得られることを確認
	//		assertFalse( getPasswordHash(userId1, pass1).equals( getPasswordHash(userId2, pass2) ));

	/**
	 * パスワードにソルトを追加したデータのハッシュ値を取得、ソルトの生成にはユーザＩＤを入力とする関数を用いる。
	 * @param userId
	 * @param password
	 * @return
	 */
	public static String getPasswordHash(String userId, String password){
		return getHash(password, getSalt(userId) );
	}

	/**
	 * 引数で与えた文字列にソルトを連結してハッシュ値を取得
	 * @param target
	 * @param salt
	 * @return
	 */
	private static String getHash(String target, String salt){
		return getHash(target + salt);
	}

	/**
	 * 引数で与えた文字列のハッシュ値を取得
	 * @param target
	 * @return
	 */
	private static String getHash(String target){
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance(ALG);
			md.update(target.getBytes());
			byte[] digest = md.digest();
			//byte[] -> String
			hash = hexString(digest);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}

	private static String getSalt(String userId){
		return userId + FIXEDSALT;
	}

	private static String hexString(byte[] bin) {
		StringBuilder sb = new StringBuilder();
		int size = bin.length;
		for (int i = 0; i < size; i++) {
			int n = bin[i];
			if (n < 0) {
				n += 256;
			}
			String hex = Integer.toHexString(n);
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			sb.append(hex);
		}
		return sb.toString();
	}
}

