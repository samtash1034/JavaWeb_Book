package com.sam.web;

import com.sam.pojo.User;
import com.sam.service.UserService;
import com.sam.service.impl.UserServiceImpl;
import com.sam.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet{

    private UserService userService = new UserServiceImpl();

    /**
     * 登出
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 登入
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));

        if(loginUser == null){
            System.out.println("登入失敗！");
            req.setAttribute("username", username);
            req.setAttribute("msg", "用戶名或密碼錯誤！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{
            System.out.println("登入成功！");
            req.getSession().setAttribute("user", loginUser);//登入後訊息回顯
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 註冊
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //使用驗證碼避免表單重複提交
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //刪除session中的驗證碼(已經存在token變數中，所以刪掉下次才能比較)
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        if(token != null && token.equalsIgnoreCase(code)){//先判斷驗整碼再判斷帳號是否重複

            if(userService.existsUsername(username)){
                //用戶名重複
                req.setAttribute("msg", "用戶名重複！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                System.out.println("用戶名" + username + "已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

            }else{
                //用戶名可用，直接新增用戶
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);

            }

        }else{
            //驗證碼錯誤
            req.setAttribute("msg", "驗證碼錯誤！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            System.out.println("驗證碼" + code + "錯誤");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
