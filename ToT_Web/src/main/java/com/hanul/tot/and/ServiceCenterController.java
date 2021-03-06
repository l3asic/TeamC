package com.hanul.tot.and;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.chaminhwan;

@Controller
public class ServiceCenterController {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceCenterController.class);
	
	
	@RequestMapping(value = "/servicecenter.sc", method = RequestMethod.GET)
	public String home(HttpSession session, Locale locale, Model model) {
		logger.info((chaminhwan.cnt++)+ " =>=> " +"Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "service/schome";
	}

	
}
