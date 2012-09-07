package com.lkan.sample.mvc;

import com.lkan.sample.person.Person;
import com.lkan.sample.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Random;

import static com.lkan.sample.builder.PersonBuilder.aPerson;

/**
 * Controller for mongo
 *
 * @author Lukasz Kaniowski
 */
@Controller
@RequestMapping("/mongo/")
public class MongoController {
	@Autowired
	PersonRepository personRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String show(ModelMap model) {
		personRepository.save(aPerson().withName("TestUser-" + new Random().nextInt(100)).build());

		List<Person> all = personRepository.findAll();
		model.addAttribute("people", all);


		return "mongo";
	}

	@RequestMapping(method = RequestMethod.GET, value = "clearDb")
	public String clearDb(ModelMap model) {
		personRepository.deleteAll();

		List<Person> all = personRepository.findAll();
		model.addAttribute("people", all);
		return "peopleList";
	}
}
