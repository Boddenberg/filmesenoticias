package br.com.ada.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ada.filmes.dao.FilmeDAO;
import br.com.ada.filmes.dao.NoticiaDAO;
import br.com.ada.filmes.model.Filme;
import br.com.ada.filmes.model.Noticia;


@Controller
@RequestMapping("/home")
public class HomeController {


	    @Autowired
	    private FilmeDAO filmeDAO;
	    
	    @Autowired
	    private NoticiaDAO noticiaDAO;

	    @GetMapping
	    public String listar(Model model) {
	        List<Filme> listaFilme = filmeDAO.buscarTodos();
	        model.addAttribute("filmes", listaFilme);
	        List<Noticia> listaNoticia = noticiaDAO.buscarTodos();
	        model.addAttribute("noticias", listaNoticia);
	        return "home_listar";
	    }

	    @GetMapping("/editar-filme/{id}")
	    public String editarFilme(@PathVariable int id, Model model) {
	        Filme filme = filmeDAO.buscarPorId(id);
	        model.addAttribute("filme", filme);
	        return "editar_filme";
	    }

	    @PostMapping("/editar-filme")
	    public String atualizarFilme(Filme filme) {
	        filmeDAO.atualizar(filme);
	        return "redirect:/home";
	    }

	    @GetMapping("/remover-filme/{id}")
	    public String removerFilme(@PathVariable int id) {
	        filmeDAO.remover(id);
	        return "redirect:/home";
	    }

	    @GetMapping("/novo-filme")
	    public String novoFilme(Model model) {
	        model.addAttribute("filme", new Filme());
	        return "filme_novo";
	    }

	    @PostMapping("/novo-filme")
	    public String adicionarFilme(Filme filme) {
	        filmeDAO.adicionar(filme);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/like/{id}")
	    public String atualizarLikeFilme(@PathVariable int id) {
	        filmeDAO.atualizarLike(id);
	        return "redirect:/home";
	    }

	    @GetMapping("/deslike/{id}")
	    public String atualizarDeslikeFilme(@PathVariable int id) {
	        filmeDAO.atualizarDeslike(id);
	        return "redirect:/home";
	    }
	    
 
//NOTICIAS \/
	    
	    @GetMapping("/editar-noticia/{id}")
	    public String editarNoticia(@PathVariable int id, Model model) {
	        Noticia noticia = noticiaDAO.buscarPorId(id);
	        model.addAttribute("noticia", noticia);
	        return "editar_noticia";
	    }

	    @PostMapping("/editar-noticia")
	    public String atualizarNoticia(Noticia noticia) {
	        noticiaDAO.atualizar(noticia);
	        return "redirect:/home";
	    }

	    @GetMapping("/remover-noticia/{id}")
	    public String removerNoticia(@PathVariable int id) {
	    	noticiaDAO.remover(id);
	        return "redirect:/home";
	    }

	    @GetMapping("/novo-noticia")
	    public String novoNoticia(Model model) {
	        model.addAttribute("noticia", new Noticia());
	        return "noticia_novo";
	    }

	    @PostMapping("/novo-noticia")
	    public String adicionarNoticia(Noticia noticia) {
	    	noticiaDAO.adicionar(noticia);
	        return "redirect:/home";
	    }
	
	
}
