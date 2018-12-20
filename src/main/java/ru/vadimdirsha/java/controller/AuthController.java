/**
 * Vadim Dirsha
 * Copyright (c) 2018 Java Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package ru.vadimdirsha.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.vadimdirsha.java.exception.RegisterNewUserException;
import ru.vadimdirsha.java.model.User;
import ru.vadimdirsha.java.service.UserRoleService;
import ru.vadimdirsha.java.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author = Vadim Dirsha
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;
    private MessageSource messageSource;
    private UserRoleService userRoleService;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @RequestMapping(value = "/register", method = GET)
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", userRoleService);
        return "auth/register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @ModelAttribute("user") User user, BindingResult bindingResult,
            HttpServletRequest req,
            Model model,
            RedirectAttributes redirectModel) {
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        model.addAttribute("roles", userRoleService);
        try {
            userService.registerNewUserAccount(user);
        } catch (RegisterNewUserException e) {
            ObjectError error = new FieldError(
                    bindingResult.getObjectName(), "username", "Smth wrong");
            bindingResult.addError(error);
            return "auth/register";
        }

        return "redirect:/";
    }

    @RequestMapping(value="/login", method=GET)
    public String login(Model model) {
        return "auth/login";
    }

    @RequestMapping(value="/logout", method=GET)
    public String logout(Model model) {
        return "auth/logout";
    }
}
