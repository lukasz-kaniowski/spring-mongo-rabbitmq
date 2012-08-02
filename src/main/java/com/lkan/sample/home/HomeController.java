package com.lkan.sample.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		model.addAttribute("controllerAttr", "controllerVal");
		return "/home/home";

	}
}
