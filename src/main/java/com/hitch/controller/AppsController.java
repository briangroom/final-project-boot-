package com.hitch.controller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hitch.entity.Applications;
import com.hitch.entity.UserLogin;
import com.hitch.hitchUtils.States;
import com.hitch.service.AppsService;
import com.hitch.service.HitchedService;

@Controller
public class AppsController {

	final static Logger logger = Logger.getLogger(HitchedController.class);

	@Autowired
	private AppsService appsService;

	@Autowired
	private HitchedService hitchedService;

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public String applications(Model model) {

		/*
		 * UserLogin userdetail =
		 * hitchedService.getUserByEmailId(UserLogin.getEmailAddress());
		 */
		model.addAttribute("applications", appsService.getAllApps());

		logger.info("This is info : " + appsService.getAllApps());

		return "applications";
	}

	@RequestMapping(value = "/applications", method = RequestMethod.POST)
	public String applications(@Valid @ModelAttribute("applications") Applications applications, BindingResult result,
			Model model) {

		/* model.addAttribute("applications", appsService.getAllApps()); */
		if (result.hasErrors()) {
			return "applications";
		}
		try {
			/* appsService.createApp(applications); */
			model.addAttribute("applications", appsService.getAllApps());
			/*
			 * model.addAttribute("success", "Entry added for " +
			 * applications.getWebsite() + ".");
			 */

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return "applications";
		} catch (RuntimeException e) {
			model.addAttribute("error", "Entry Not Added for " + applications.getWebsite() + ".");

			e.printStackTrace();
			return "applications";
		}

		return "applications";
	}

	@RequestMapping(value = "/appentry", method = RequestMethod.GET)
	public String appentry(Model model, HttpServletRequest request) {
		logger.debug("working!!");
		UserLogin myUser = (UserLogin) request.getSession().getAttribute("myUser");

		logger.debug("Logged In user details: " + myUser.getFname() + " " + myUser.getLname());
		String name = myUser.getFname() + " " + myUser.getLname();

		model.addAttribute("appentry", appsService.getAllApps());
		model.addAttribute("myUserName", name);
		model.addAttribute("dummy", "Sahara");

		return "appentry";
	}

	@RequestMapping(value = "/appentry", method = RequestMethod.POST)
	public String appentry(@Valid @ModelAttribute("appentry") Applications applications, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "appentry";
		}
		try {
			applications.setOverallRating(calculateOverallRating(applications));
			appsService.createApp(applications);

			model.addAttribute("applications", appsService.getAllApps());
			model.addAttribute("success", "Entry added for " + applications.getWebsite() + ".");

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return "appentry";
		} catch (RuntimeException e) {
			model.addAttribute("error", "Entry Not Added for " + applications.getWebsite() + ".");

			e.printStackTrace();
			return "appentry";
		}

		return "applications";
	}

	/*
	 * @RequestMapping("deleteApp") public String deleteApp(@RequestParam long
	 * id, ModelMap model) {
	 * 
	 * appsService.deleteAppById(applications);; model.addAttribute("success",
	 * "ID = " +id+ " has been removed"); model.addAttribute("applications",
	 * appsService.getAllApps());
	 * 
	 * return "about"; }
	 */

	@ModelAttribute("states")
	public List<States> populateStates() {
		return Arrays.asList(States.values());
	}
	
	public static String calculateOverallRating(Applications app)
	{
		
		int result= (Integer.parseInt(app.getBookHotelBlock())+ 
						Integer.parseInt(app.getBudget()) +
						Integer.parseInt(app.getChecklist()) +
						Integer.parseInt(app.getDateTracker()) +
						Integer.parseInt(app.getDressSearch()) +
						Integer.parseInt(app.getForumn()) +
						Integer.parseInt(app.getGiftRegistry()) +
						Integer.parseInt(app.getGuestList()) +
						Integer.parseInt(app.getVendorSearch()) +
						Integer.parseInt(app.getVenueSearch()) +
						Integer.parseInt(app.getWeddingWebsite())) /11;
		String str = Integer.toString(result);
		return str;
	}

	/*
	 * @RequestMapping(value = "/services", method = RequestMethod.GET) public
	 * String service(Model model) { model.addAttribute("message",
	 * "Welcome to wellness club ");
	 * 
	 * return "services"; }
	 * 
	 * @RequestMapping(value = "/applications", method = RequestMethod.GET)
	 * public String applications(Model model) { model.addAttribute("message",
	 * "Welcome to Application Page ");
	 * 
	 * return "services"; }
	 * 
	 * @RequestMapping(value = "/appentry", method = RequestMethod.GET) public
	 * String appentry(Model model) { model.addAttribute("message",
	 * "Welcome to Application Entry Page ");
	 * 
	 * return "services"; }
	 */

}
