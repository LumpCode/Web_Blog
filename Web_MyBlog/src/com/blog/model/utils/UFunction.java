package com.blog.model.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 定义EL自定义函数
 * 
 */
public class UFunction {
    /**
     * 获取一个字符串的长度
     * 
     * @param str
     * @return int
     */
    public static int getLen(String str) {
	return str.length();
    }

    /**
     * 截取字符串
     * 
     * @param str
     * @param start
     * @param end
     * @return String
     */
    public static String substr(String str, int start, int end) {
	String detail = delHTMLTag(str).trim();
	String aftersubstr;
	if(detail.length()>end)
	{
	    aftersubstr = detail.substring(start, end);
	}else
	{
	    return detail;
	}
	return aftersubstr;
    }

    /**
     * 两数相除获取整数结果
     * 
     * @param first
     * @param second
     * @return int
     */
    public static int chufa(int first, int second) {
	return first / second;
    }

    public static String delHTMLTag(String htmlStr) {
	String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
	String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
	String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

	Pattern p_script = Pattern.compile(regEx_script,
		Pattern.CASE_INSENSITIVE);
	Matcher m_script = p_script.matcher(htmlStr);
	htmlStr = m_script.replaceAll(""); // 过滤script标签

	Pattern p_style = Pattern
		.compile(regEx_style, Pattern.CASE_INSENSITIVE);
	Matcher m_style = p_style.matcher(htmlStr);
	htmlStr = m_style.replaceAll(""); // 过滤style标签

	Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
	Matcher m_html = p_html.matcher(htmlStr);
	htmlStr = m_html.replaceAll(""); // 过滤html标签

	return htmlStr.trim(); // 返回文本字符串
    }
}
