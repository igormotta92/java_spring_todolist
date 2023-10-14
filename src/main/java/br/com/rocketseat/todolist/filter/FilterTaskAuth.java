package br.com.rocketseat.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rocketseat.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var servletPath = request.getServletPath();

        if (!servletPath.startsWith("/tasks/")) filterChain.doFilter(request, response);

        var authorization = request.getHeader("Authorization");

        var authEncoder = authorization.substring("Basic".length()).trim();
        byte[] authDecoder = Base64.getDecoder().decode(authEncoder);
        var authString = authEncoder;

        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        var user = this.userRepository.findByUsername(username);

        if (user == null) response.sendError(401, "Usuário sem autorização");

        var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

        if (!passwordVerify.verified) response.sendError(401, "Usuário sem autorização");

        request.setAttribute("idUser", user.getId());
        filterChain.doFilter(request, response);

    }
}