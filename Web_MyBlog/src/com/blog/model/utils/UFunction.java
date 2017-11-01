package com.blog.model.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����EL�Զ��庯��
 * 
 */
public class UFunction {
    /**
     * ��ȡһ���ַ����ĳ���
     * 
     * @param str
     * @return int
     */
    public static int getLen(String str) {
	return str.length();
    }

    /**
     * ��ȡ�ַ���
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
     * ���������ȡ�������
     * 
     * @param first
     * @param second
     * @return int
     */
    public static int chufa(int first, int second) {
	return first / second;
    }

    public static String delHTMLTag(String htmlStr) {
	String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // ����script��������ʽ
	String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // ����style��������ʽ
	String regEx_html = "<[^>]+>"; // ����HTML��ǩ��������ʽ

	Pattern p_script = Pattern.compile(regEx_script,
		Pattern.CASE_INSENSITIVE);
	Matcher m_script = p_script.matcher(htmlStr);
	htmlStr = m_script.replaceAll(""); // ����script��ǩ

	Pattern p_style = Pattern
		.compile(regEx_style, Pattern.CASE_INSENSITIVE);
	Matcher m_style = p_style.matcher(htmlStr);
	htmlStr = m_style.replaceAll(""); // ����style��ǩ

	Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
	Matcher m_html = p_html.matcher(htmlStr);
	htmlStr = m_html.replaceAll(""); // ����html��ǩ

	return htmlStr.trim(); // �����ı��ַ���
    }
}
