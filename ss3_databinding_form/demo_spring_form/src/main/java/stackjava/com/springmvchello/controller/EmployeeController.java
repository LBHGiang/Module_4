package stackjava.com.springmvchello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stackjava.com.springmvchello.entities.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value={"/", "addEmployee"}, method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());

		List<String> listFavorite = new ArrayList<String>();
		listFavorite.add("Swimming");
		listFavorite.add("Listening music");
		listFavorite.add("Walking");
		listFavorite.add("Watching movie");
		listFavorite.add("Reading comic");
		model.addAttribute("listFavorite", listFavorite);

		List<String> listPosition = new ArrayList<String>();
		listPosition.add("Developer");
		listPosition.add("Designer");
		listPosition.add("Tester");
		listPosition.add("QA");
		model.addAttribute("listFavorite", listFavorite);
		model.addAttribute("listPosition", listPosition);

		return "add-employee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String doAddEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
		modelMap.addAttribute("employee", employee);
		return "view-employee";
	}

}
