package com.lkan.sample.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
@Controller
@RequestMapping("/")
public class HomeController {



	@RequestMapping(method = RequestMethod.GET)
	public String show(ModelMap model) {
		return "/home";

	}

	@RequestMapping(value = "/mu-40e93541-db42b8f5-36bd0540-dcbf7834", method = RequestMethod.GET)
	@ResponseBody
	public String blitz_io(ModelMap model) {
		return "42";
	}
}
