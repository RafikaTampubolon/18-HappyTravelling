package del.ac.id.demo.controller;

import del.ac.id.demo.jpa.Role;
import del.ac.id.demo.jpa.RoleRepository;
import del.ac.id.demo.jpa.User;
import del.ac.id.demo.jpa.UserRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RegistrationController {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public RegistrationController(UserRepository userRepository,
                                  RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        List<Role> listRoles = roleRepository.findAll();
        System.out.println(listRoles.size());
        ModelAndView mv = new ModelAndView("registration");
        mv.addObject("roles", listRoles);
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registrationSubmit(@ModelAttribute User user, BindingResult
            bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error");
        }
        model.addAttribute("user", user);
        userRepository.save(user);
        return new ModelAndView("redirect:/login") ;
    }
}