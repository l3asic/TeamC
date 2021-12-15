package com.hanul.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//public abstract void execute();	//추상메소드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
}
