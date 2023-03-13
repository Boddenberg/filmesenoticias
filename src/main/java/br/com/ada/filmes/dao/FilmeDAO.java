package br.com.ada.filmes.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ada.filmes.model.Filme;

@Component
public class FilmeDAO {

	private static List<Filme> filmes = new ArrayList<>();
	private static int proximoId = 1;

	public void adicionar(Filme filme) {
		filme.setId(proximoId++);
		filmes.add(filme);
	}

	public void atualizar(Filme filme) {
		for (int i = 0; i < filmes.size(); i++) {
			Filme p = filmes.get(i);
			if (p.getId() == filme.getId()) {
				filmes.set(i, filme);
				break;
			}
		}
	}

	public void remover(int id) {
		filmes.removeIf(p -> p.getId() == id);
	}

	public Filme buscarPorId(int id) {
		return filmes.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	public List<Filme> buscarTodos() {
		return filmes;
	}
	
	public void atualizarLike(int id) {
        for (int i = 0; i < filmes.size(); i++) {
            Filme film = filmes.get(i);
            if (film.getId() == id) {
                film.setLike(film.getLike() + 1);
                break;
            }
        }
    }

    public void atualizarDeslike(int id) {
        for (int i = 0; i < filmes.size(); i++) {
            Filme film = filmes.get(i);
            if (film.getId() == id) {
                if(film.getLike() > 0) {
                    film.setLike(film.getLike() - 1);
                    break;
                }
            }
        }
    }
}
