package com.hongdatchy.bookcar.security;

import com.hongdatchy.bookcar.repo.UserRepo;
import lombok.AllArgsConstructor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class UserFilter implements Filter {

    private final UserRepo userRepo;
    private final JWTService jwtService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        if(token != null){
            String username = jwtService.decode(token);
            if (username != null && userRepo.findByUsername(username) != null){
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.setStatus(401);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
