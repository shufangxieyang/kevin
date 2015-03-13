package cn.kevin.dataguru.nmea_server.util;

import java.net.URL;

public class StringUtils {

	public static String dotToSplash(String name) {
		return name.replaceAll("\\.", "/");
	}

	/**
	 * "file:/home/cn/kevin" -> "/home/cn/kevin"
	 */
	public static String getRootPath(URL url) {
		String fileUrl = url.getFile();
		int pos = fileUrl.indexOf('!');
		if (-1 == pos) {
			return fileUrl;
		}
		return fileUrl.substring(5, pos);
	}

	/**
	 * "Apple.class" -> "Apple"
	 */
	public static String trimExtension(String name) {
		int pos = name.indexOf('.');
		if (-1 != pos) {
			return name.substring(0, pos);
		}
		return name;
	}

	public static boolean isClassFile(String name) {
		return name.endsWith(".class");
	}

	public static boolean isJarFile(String name) {
		return name.endsWith(".jar");
	}

	public static String toFullName(String basePackage, String shortName) {
		StringBuilder sb = new StringBuilder(basePackage);
		sb.append('.');
		sb.append(trimExtension(shortName));
		return sb.toString();
	}
	
	public static String getSentenceType(String name) {
		return name.substring(name.lastIndexOf(".") + 1).substring(0, 3).toUpperCase();
	}
}
