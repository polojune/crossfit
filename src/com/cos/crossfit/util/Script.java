package com.cos.crossfit.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {

	public static void outText(String msg, HttpServletResponse response) {
		try {

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void href(String msg, String uri, HttpServletResponse response) {
		try {

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("location.href='" + uri + "';");
			out.println("</script>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void back(String msg, HttpServletResponse response) {
		try {

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("location.href='" + "" + "';");
			out.println("</script>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
