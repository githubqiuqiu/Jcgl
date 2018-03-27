package com.edu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.edu.service.impl.MinServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SysAction extends ActionSupport {
	private List list;
	private int count;
	private MinServiceImpl minService;

	public MinServiceImpl getMinService() {
		return minService;
	}

	public void setMinService(MinServiceImpl minService) {
		this.minService = minService;
	}
	public String sel() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(req.getParameter("page"));
		int rows = Integer.parseInt(req.getParameter("rows"));
		 list = minService.selsyslog(page,rows);
		 count = minService.selsyscount();
			Map map = new HashMap<>();
			map.put("total", count);
			map.put("rows", list);

			String str = JSON.toJSONString(map);
			PrintWriter pw = null;
			try {
				pw = res.getWriter();
				pw.print(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			 System.out.println(str);
			return null;
	}
}
