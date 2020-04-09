package com.ruanmou.house.housecommon.exception;

import com.ruanmou.house.housecommon.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class ApiErrorExceptionContorller implements ErrorController {

    public static final String ERROR_PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String errorHandler(HttpServletRequest request, HttpServletResponse response){

        int status = response.getStatus();

        switch (status){
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }

        return "";
    }

    @RequestMapping(ERROR_PATH)
    @ResponseBody
    public ApiResponse errorApiHandler(HttpServletRequest request,HttpServletResponse response){
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        Map<String,Object> errorAttributesmap = this.errorAttributes.getErrorAttributes(servletWebRequest,false);
        int status = getStatus(response);
        return ApiResponse.ofMessage(status,String.valueOf(errorAttributesmap.getOrDefault("message","error")));
    }

    private int getStatus(HttpServletResponse response){
//        Integer status = (Integer)request.getAttribute("javax.serverlet.error.status_code");
        Integer status = response.getStatus();
        if(status != null){
            return status;
        }
        return 500;
    }



}
