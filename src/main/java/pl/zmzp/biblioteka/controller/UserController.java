package pl.zmzp.biblioteka.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.zmzp.biblioteka.dao.UserRepositoryDao;
import pl.zmzp.biblioteka.dto.User;
import pl.zmzp.biblioteka.dto.UserLoginForm;
import pl.zmzp.biblioteka.dto.UserRegistrationForm;
import pl.zmzp.biblioteka.service.BibliotekaService;

import javax.validation.Valid;

@Controller
public class UserController {

    public static final String LOGIN_PAGE = "login";
    public static final String REGISTRATION_PAGE = "registration";
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BibliotekaService bibliotekaService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new UserRegistrationForm());
        return REGISTRATION_PAGE;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute(name = "userForm")  UserRegistrationForm userRegistrationForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return REGISTRATION_PAGE;
        }

        if(bibliotekaService.checkIfUserExists(userRegistrationForm.getNazwauzy())){
            model.addAttribute("userAlreadyExistsWarning", "Użytkownik o takiej nazwie już istnieje");
            return REGISTRATION_PAGE;
        }

        final User newUser = modelMapper.map(userRegistrationForm, User.class);
        bibliotekaService.saveNewUser(newUser);


        return "redirect:/hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("userLoginForm", new UserLoginForm());
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String log(Model model){

            return "redirect:/hello";

    }
}
