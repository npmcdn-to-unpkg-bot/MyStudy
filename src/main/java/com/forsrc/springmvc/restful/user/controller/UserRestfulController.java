package com.forsrc.springmvc.restful.user.controller;

import com.forsrc.pojo.User;
import com.forsrc.springmvc.restful.user.service.UserRestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//@RestController
@Controller
@RequestMapping(value = "/v1.0")
public class UserRestfulController {

    @Autowired
    @Resource(name = "userRestfulService")
    private UserRestfulService userRestfulService;

    @RequestMapping(value = {"/user"}, method = RequestMethod.GET
            //, headers = "Accept=application/json"
    )
    @ResponseBody
    public ModelAndView list(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        Map<String, List<User>> map = new HashMap<String, List<User>>();
        List<User> list = this.userRestfulService.list();
        map.put("list", list);
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("list", list);
        modelAndView.addObject(map);
        return modelAndView;
    }

    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.GET, produces = {})
    @ResponseBody
    public ModelAndView get(@PathVariable Long id,
                    HttpServletRequest request,
                    HttpServletResponse response) throws Exception {
        User user = this.userRestfulService.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().put("user", user);
        return modelAndView;

    }

    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.PUT)
    @ResponseBody
    public User update(@PathVariable Long id,
                       @RequestBody User user,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        //User bean = userManager.findUser(id);
        user.setToken(UUID.randomUUID().toString());
        this.userRestfulService.update(user);
        return user;

    }

    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@PathVariable Long id,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        this.userRestfulService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().put("id", id);
        modelAndView.getModelMap().put("status", 200);
        return modelAndView;

    }

    @RequestMapping(value = {"/user"}, method = RequestMethod.POST)
    @ResponseBody
    public User save(@PathVariable User bean,
                     HttpServletRequest request,
                     HttpServletResponse response) throws Exception {
        bean.setToken(UUID.randomUUID().toString());
        bean.setId(this.userRestfulService.save(bean));
        return bean;

    }

    @RequestMapping(value = {"/user/login"}, method = RequestMethod.POST)
    @ResponseBody
    public User login(@PathVariable User bean,
                     HttpServletRequest request,
                     HttpServletResponse response) throws Exception {
        bean.setToken(UUID.randomUUID().toString());
        bean.setId(this.userRestfulService.save(bean));
        return bean;

    }

    public UserRestfulService getUserRestfulService() {
        return userRestfulService;
    }

    public void setUserRestfulService(UserRestfulService userRestfulService) {
        this.userRestfulService = userRestfulService;
    }
}
