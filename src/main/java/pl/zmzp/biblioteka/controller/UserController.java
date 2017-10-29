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

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BibliotekaService bibliotekaService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new UserRegistrationForm());
        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute(name = "userForm")  UserRegistrationForm userRegistrationForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.hasErrors());
            return "registration";
        }

        if(bibliotekaService.checkIfUserExists(userRegistrationForm.getNazwauzy())){
            model.addAttribute("userAlreadyExistsWarning", "Użytkownik o takiej nazwie już istnieje");
            return "registration";
        }

        final User newUser = modelMapper.map(userRegistrationForm, User.class);
        bibliotekaService.saveNewUser(newUser);


        return "redirect:/hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("userLoginForm", new UserLoginForm());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userLoginForm") @Valid UserLoginForm userLoginForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "login";
        }
        return "redirect:/hello";
    }
}
