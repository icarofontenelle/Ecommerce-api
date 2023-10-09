package com.example.api.wine.Infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.api.wine.configurations.security.TokenConfig;
import com.example.api.wine.repositories.AcessoRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FiltroSeguranca extends OncePerRequestFilter {

    @Autowired
    private TokenConfig tokenConfig;

    private AcessoRepository acessoRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        var tokenJWT = recuperarToken(request);
        
        if(tokenJWT != null){ //Validando o token e se caso válido, mantendo o usuário logado.
            var usuarioValido = tokenConfig.validarToken(tokenJWT);
            var acesso = acessoRepository.findByLogin(usuarioValido);

            var authentication = new UsernamePasswordAuthenticationToken(acesso, null, acesso.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication); // classe que faz a autenticação do usuário para determinada requisição.
        }

        filterChain.doFilter(request, response);
    }

   
    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null){
            return authorizationHeader.replace("Bearer", "");     
        }
        return null;
    }
    

}
