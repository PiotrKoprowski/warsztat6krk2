package pl.coderslab.warsztat6krk2.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.coderslab.warsztat6krk2.entity.Tweet;
import pl.coderslab.warsztat6krk2.entity.User;
import pl.coderslab.warsztat6krk2.repository.TweetRepository;
import pl.coderslab.warsztat6krk2.repository.UserRepository;

@Controller
@RequestMapping("/tweet")
@SessionAttributes({"loggedInUser"})
public class TweetController {
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	TweetRepository tweetRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/add")
	public String add(Model m, HttpSession s) {
		m.addAttribute("tweet", new Tweet());
		return "tweetForm";
	}
	
	@PostMapping("/add")
	@Transactional
	public String addPost(@Valid @ModelAttribute Tweet tweet, BindingResult br, HttpSession session) {
		User u = (User)session.getAttribute("loggedInUser");
		tweet.setUser(u);
		this.entityManager.merge(tweet);
		return "redirect:/ add";
	}
}
