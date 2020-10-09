package del.ac.id.demo.controller;

import del.ac.id.demo.jpa.LoginRepository;
import del.ac.id.demo.jpa.RoleRepository;
import del.ac.id.demo.jpa.UserRepository;
import del.ac.id.demo.jpa.Role;
import del.ac.id.demo.jpa.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class LoginController {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private LoginRepository loginRepository;

    public LoginController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        List<Role> listRoles = roleRepository.findAll();
        //System.out.println(listRoles.size());

        ModelAndView mv = new ModelAndView("login");
        mv.addObject("roles", listRoles);
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView submitLogin(@ModelAttribute User user, Model model){

        model.addAttribute("user", user);
        User userRole = userRepository.findByUsername(user.getUsername());

        ModelAndView adminView = new ModelAndView("redirect:/admin");
        adminView.addObject("username", userRole.getUsername());

        ModelAndView penggunaView = new ModelAndView("redirect:/pengguna");
        penggunaView.addObject("username", userRole.getUsername());

        //System.out.println(userRole.getUsername());
       //System.out.println(userRole.getRoleid());
        if(userRole.getRoleid() == 1){
            return adminView;
        }
        if(userRole.getRoleid() == 2){
            return penggunaView;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }
}
