package br.com.fmp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fmp.modelo.Filme;

@WebServlet("/filme")
public class FilmeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme("Coringa", "Drama", 2019));
        filmes.add(new Filme("Matrix", "Ação", 1999));
        filmes.add(new Filme("Forrest Gump", "Drama", 1994));

        String genero = req.getParameter("genero");
        List<Filme> listaFiltrada = null;
        if (genero != null && !genero.isEmpty()) {
            listaFiltrada = filmes.stream()
                                  .filter(filme -> filme.getGenero().equalsIgnoreCase(genero))
                                  .collect(Collectors.toList());
        }

        req.setAttribute("listaFiltrada", listaFiltrada);
        RequestDispatcher dispatcher = req.getRequestDispatcher("lista-filmes.jsp");
        dispatcher.forward(req, resp);
    }
}
