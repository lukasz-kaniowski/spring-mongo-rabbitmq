package com.lkan.sample.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	MongoTemplate mongoTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String show(ModelMap model) {
		mongoTemplate.save(new Person("TestUser-" + new Random().nextInt(100)));

		List<Person> all = mongoTemplate.findAll(Person.class);
		model.addAttribute("people", all);
		model.addAttribute("controllerAttr", "controllerVal");
		return "/home/home";

	}

	@RequestMapping(value = "/mu-40e93541-db42b8f5-36bd0540-dcbf7834", method = RequestMethod.GET)
	@ResponseBody
	public String blitz_io(ModelMap model) {
		return "42";
	}
}
