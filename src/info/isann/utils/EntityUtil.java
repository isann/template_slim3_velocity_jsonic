package info.isann.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * カプセル化されたエンティティクラスのプロパティを操作するユーティリティクラスです。
 * @author isann
 *
 */
public class EntityUtil {

	private static final Logger logger = Logger.getLogger(EntityUtil.class.getName());

	/**
	 * 引数のエンティティクラスのエンティティオブジェクトにプロパティ名で値を設定します。
	 * @param clazz エンティティのクラス
	 * @param entity エンティティのオブジェクト
	 * @param propertyName 設定するプロパティ名（getter/setterが設定されていて、カプセル化されていること）
	 * @param value 設定値
	 */
	@SuppressWarnings("unchecked")
	public static void setEntityValue(Class clazz, Object entity, String propertyName, Object value){
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(propertyName, clazz);
			Method setterMethod = pd.getWriteMethod();
			setterMethod.invoke(entity, value);
		} catch (IntrospectionException e) {
			logger.severe(
					LogMessages.ERROR_0007_MESSAGE + LogMessages.logParams(" clazz:", clazz.getName(), 
							" entity:", entity.toString(), 
							" propropertyNameper:", propertyName, 
							" value:", value));
			logger.severe(LogMessages.getStackTrace(e));
			throw new ApplicationRuntimeException("エンティティの操作に失敗しました。");
		} catch (IllegalArgumentException e) {
			logger.severe(
					LogMessages.ERROR_0007_MESSAGE + LogMessages.logParams(" clazz:", clazz.getName(), 
							" entity:", entity.toString(), 
							" propropertyNameper:", propertyName, 
							" value:", value));
			logger.severe(LogMessages.getStackTrace(e));
			throw new ApplicationRuntimeException("エンティティの操作に失敗しました。");
		} catch (IllegalAccessException e) {
			logger.severe(
					LogMessages.ERROR_0007_MESSAGE + LogMessages.logParams(" clazz:", clazz.getName(), 
							" entity:", entity.toString(), 
							" propropertyNameper:", propertyName, 
							" value:", value));
			logger.severe(LogMessages.getStackTrace(e));
			throw new ApplicationRuntimeException("エンティティの操作に失敗しました。");
		} catch (InvocationTargetException e) {
			logger.severe(
					LogMessages.ERROR_0007_MESSAGE + LogMessages.logParams(" clazz:", clazz.getName(), 
							" entity:", entity.toString(), 
							" propropertyNameper:", propertyName, 
							" value:", value));
			logger.severe(LogMessages.getStackTrace(e));
			throw new ApplicationRuntimeException("エンティティの操作に失敗しました。");
		}
	}

	/**
	 * 引数のエンティティクラスのエンティティオブジェクトからプロパティ名の値を取得します。
	 * @param clazz エンティティのクラス
	 * @param entity エンティティのインスタンス
	 * @param propertyName 値を取得するプロパティ名（getter/setterが設定されていてカプセル化されていること）
	 * @return 取得した値を返却します。
	 */
	@SuppressWarnings("unchecked")
	public static Object getEntityValue(Class clazz, Object entity, String propertyName){
		PropertyDescriptor pd;
		Object ret = null;
		try {
			pd = new PropertyDescriptor(propertyName, clazz);
			Method getterMethod = pd.getReadMethod();
			ret = getterMethod.invoke(entity);
		} catch (IntrospectionException e) {
			logger.severe(
					LogMessages.ERROR_0007_MESSAGE + LogMessages.logParams(" clazz:", clazz.getName(),
							" entity:", entity.toString(),
							" propropertyNameper:", propertyName));
			logger.severe(LogMessages.getStackTrace(e));
			throw new ApplicationRuntimeException("エンティティの操作に失敗しました。");
		} catch (IllegalArgumentException e) {
			logger.severe(
					LogMessages.ERROR_0007_MESSAGE + LogMessages.logParams(" clazz:", clazz.getName(), 
							" entity:", entity.toString(), 
							" propropertyNameper:", propertyName));
			logger.severe(LogMessages.getStackTrace(e));
			throw new ApplicationRuntimeException("エンティティの操作に失敗しました。");
		} catch (IllegalAccessException e) {
			logger.severe(
					LogMessages.ERROR_0007_MESSAGE + LogMessages.logParams(" clazz:", clazz.getName(), 
							" entity:", entity.toString(), 
							" propropertyNameper:", propertyName));
			logger.severe(LogMessages.getStackTrace(e));
			throw new ApplicationRuntimeException("エンティティの操作に失敗しました。");
		} catch (InvocationTargetException e) {
			logger.severe(
					LogMessages.ERROR_0007_MESSAGE + LogMessages.logParams(" clazz:", clazz.getName(), 
							" entity:", entity.toString(), 
							" propropertyNameper:", propertyName));
			logger.severe(LogMessages.getStackTrace(e));
			throw new ApplicationRuntimeException("エンティティの操作に失敗しました。");
		}
		return ret;
	}

}
