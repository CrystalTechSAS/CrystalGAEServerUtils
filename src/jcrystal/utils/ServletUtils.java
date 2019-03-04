package jcrystal.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Created by G on 1/15/2017.
*/
public class ServletUtils {
	public static int optInt(HttpServletRequest req, String name, int defaultValue){
		String val = req.getParameter(name);
		if(val == null || val.isEmpty())
			return defaultValue;
		return Integer.parseInt(val);
	}
	public static Integer optInteger(HttpServletRequest req, String name){
		String val = req.getParameter(name);
		if(val == null || val.isEmpty())
			return null;
		return Integer.parseInt(val);
	}
	public static Long optLong(HttpServletRequest req, String name){
		String val = req.getParameter(name);
		if(val == null || val.isEmpty())
			return null;
		return Long.parseLong(val);
	}
	public static void sendNonAuthorizedUser(HttpServletResponse resp) throws IOException {
		resp.getWriter().print("{\"success\": 3, \"code\": 403, \"mensaje\": \"Usuario no autenticado\"}");
	}
	public static void send404(HttpServletResponse resp) throws IOException{
		resp.setStatus(404);
		resp.getWriter().print("The requested resource doesn't exists.");
	}
	public static Cookie setAge(Cookie cookie, int age){cookie.setMaxAge(age);return cookie;}
	public static Cookie setPath(Cookie cookie, String path){cookie.setPath(path);return cookie;}
	public static String getToken(HttpServletRequest req){
		String token = req.getHeader("Authorization");
		if(token == null){
			Cookie[] cookies = req.getCookies();
			if(cookies != null){
				for(Cookie c : cookies)if("token".equals(c.getName())){
					token = c.getValue();
					break;
				}
			}
		}
		return token;
	}
	public static void copy(int bufferSize, InputStream input, OutputStream output) throws IOException {
		try {
			byte[] buffer = new byte[bufferSize];
			int bytesRead = input.read(buffer);
			while (bytesRead != -1) {
				output.write(buffer, 0, bytesRead);
				bytesRead = input.read(buffer);
			}
			output.flush();
		} finally {
			input.close();
			output.close();
		}
	}
}
