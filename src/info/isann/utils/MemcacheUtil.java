package info.isann.utils;

import java.util.Collections;
import java.util.logging.Logger;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.cache.CacheManager;

import com.google.appengine.api.memcache.stdimpl.GCacheException;

/**
 * Memcacheに関するユーティリティクラスです。
 * @author isann
 *
 */
public class MemcacheUtil {

	private static final Logger logger = Logger.getLogger(MemcacheUtil.class.getName());
	
	/**
	 * キャッシュを取得します。
	 * @return 取得したキャッシュを返却します。取得できない場合、NULLを返却します。
	 */
	public static Cache getMemCache(){
		Cache cache = null;

		try {
			cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
		} catch (CacheException e) {
			// 何もしない。キャッシュはデータストアで代替できるようにしておく。
			logger.severe(LogMessages.ERROR_0010_MESSAGE);
			logger.severe(LogMessages.getStackTrace(e));
		}
		return cache;

	}
	
	/**
	 * キャッシュのキーにひもづくデータを取得します。
	 */
	public static Object get(Object key){
		Cache cache = MemcacheUtil.getMemCache();
		return cache.get(key);
	}
	
	/**
	 * キャッシュのキーにひもづくデータを取得します。
	 * @return キーにひもづいていた以前のデータを返却します。
	 */
	@SuppressWarnings("unchecked")
	public static void put(Object key, Object value){
		try {
			Cache cache = MemcacheUtil.getMemCache();
			cache.put(key, value);
		} catch (GCacheException ignore) {
			logger.warning(LogMessages.WARNING_0010_MESSAGE);
			logger.warning(LogMessages.getStackTrace(ignore));
		}
	}
	
	/**
	 * Memcacheに引数のキーが既に含まれているかどうか判定します。
	 * @return Memcacheにキーが含まれている場合、trueを返却します。
	 */
	public static boolean containsKey(Object key){
		Cache cache = MemcacheUtil.getMemCache();
		return cache.containsKey(key);
	}
	
	/**
	 * Memcacheから引数のキーにひもづく値を削除します。
	 * @return 削除されたデータを返却します。
	 */
	public static Object remove(Object key){
		Cache cache = MemcacheUtil.getMemCache();
		return cache.remove(key);
	}
	
}
