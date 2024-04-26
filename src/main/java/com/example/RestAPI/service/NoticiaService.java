package com.example.RestAPI.service;

import com.example.RestAPI.model.NoticiaEntity;
import com.example.RestAPI.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    public String noticiasereleases() {
        String resultadoNoticia = "";

        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        NoticiaEntity ne = new NoticiaEntity();
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            resultadoNoticia = responseEntity.getBody();
        } else {
            resultadoNoticia = "Falha ao obter dados Da noticia. Código de status: " + responseEntity.getStatusCode();
        }

            ne.setTexto(resultadoNoticia);
            ne.setId(resultadoNoticia);
            noticiaRepository.save(ne);

        return ne.getTexto();
    }
    public String noticias() {
        String resultadoNoticia = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            resultadoNoticia = responseEntity.getBody();
        } else {
            resultadoNoticia = "Falha ao obter dados Da noticia. Código de status: " + responseEntity.getStatusCode();
        }

            NoticiaEntity ne = new NoticiaEntity();
            ne.setId(resultadoNoticia);
            ne.setTexto(resultadoNoticia);
            noticiaRepository.save(ne);

        return resultadoNoticia;
    }
    public String releases() {
        String resultadoNoticia = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            resultadoNoticia = responseEntity.getBody();
        } else {
            resultadoNoticia = "Falha ao obter dados Da noticia. Código de status: " + responseEntity.getStatusCode();
        }

            NoticiaEntity ne = new NoticiaEntity(resultadoNoticia, resultadoNoticia);
            ne.setId(resultadoNoticia);
            ne.setTexto(resultadoNoticia);
            noticiaRepository.save(ne);
        return resultadoNoticia;
    }


}
