package com.sleep.owl.web.webcore.base;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {


    public ModelAndView randerView(String view) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(view);
        return modelAndView;
    }

}
