package com.teste.testehdi.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.teste.testehdi.controller.dto.CorretorDto;
import com.teste.testehdi.controller.dto.CorretorStatusDto;



@Service
public class CorretorService {

    public CorretorDto buscarStatusCorretor(String document) throws Exception {
        CorretorDto corretoDto = new CorretorDto();
        corretoDto.setDocumento(document);

        CorretorDto corretorDto = consultaCorretorPorDocumento(corretoDto);

        return corretorDto;
    }


    private CorretorDto consultaCorretorPorId(CorretorDto corretorDto, String idCorretor) throws Exception {
        final String URI = "https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/brokerData/"+idCorretor;
        RestTemplate buscaCorretor = new RestTemplate();


        ResponseEntity<CorretorStatusDto> response = buscaCorretor.exchange(URI,
                HttpMethod.GET,
                null,
                CorretorStatusDto.class);
        try {
            if(response.getBody().isActive()) {
                corretorDto.setActive(response.getBody().isActive());
                corretorDto.setTaxaComissao(response.getBody().getCommissionRate());

            }else {
                Exception erro = new Exception();
                throw erro;
            }
        } catch (Exception e) {
            throw new Exception("Corretor Com Status Inativo");

        }

        return corretorDto;
    }


    private CorretorDto consultaCorretorPorDocumento(CorretorDto corretor) throws Exception {

        final String URI ="https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/broker/"+corretor.getDocumento();
        RestTemplate buscaCorretor = new RestTemplate();

        ResponseEntity<CorretorStatusDto> response = buscaCorretor.exchange(URI,
        HttpMethod.GET,
        null,
        CorretorStatusDto.class);
        String idCorretor = response.getBody().getCode();
    

        corretor.setNome(response.getBody().getName());
        corretor.setDocumento(response.getBody().getDocument());
        corretor.setCodigo(Integer.parseInt(idCorretor));
        corretor.setDataCriação(response.getBody().getCreateDate());
        corretor.setTaxaComissao(response.getBody().getCommissionRate());

        consultaCorretorPorId(corretor, idCorretor);
        return corretor;
    }

}
