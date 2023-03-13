package br.com.ada.filmes.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ada.filmes.model.Noticia;

@Component
public class NoticiaDAO {


	    private static List<Noticia> noticias = new ArrayList<>();
	    private static int proximoId = 1;

	    public void adicionar(Noticia noticia) {
	    	noticia.setId(proximoId++);
	        noticias.add(noticia);
	    }

	    public void atualizar(Noticia noticia) {
	        for (int i = 0; i < noticias.size(); i++) {
	        	Noticia p = noticias.get(i);
	            if (p.getId() == noticia.getId()) {
	            	noticias.set(i, noticia);
	                break;
	            }
	        }
	    }

	    public void remover(int id) {
	    	noticias.removeIf(p -> p.getId() == id);
	    }

	    public Noticia buscarPorId(int id) {
	        return noticias.stream()
	                .filter(p -> p.getId() == id)
	                .findFirst()
	                .orElse(null);
	    }

	    public List<Noticia> buscarTodos() {
	        return noticias;
	    }
	
	
	
}
