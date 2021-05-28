package br.com.cesjf.trabalhomobile.Mapper;

import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class HeroiApiMapper {

    public static HeroiDto mapper(Object raw){
        LinkedHashMap result = (LinkedHashMap) raw;
        try {
            HeroiDto dto = new HeroiDto();
            dto.setIdApi((String) result.get("id"));
            dto.setNome((String) result.get("name"));

            LinkedHashMap biography = (LinkedHashMap) result.get("biography");
            dto.setAlterEgo((String) biography.get("full-name"));

            LinkedHashMap image = (LinkedHashMap) result.get("image");
            dto.setUrlImagem((String) image.get("url"));

            LinkedHashMap appearance = (LinkedHashMap) result.get("appearance");
            ArrayList tipoAltura = (ArrayList) appearance.get("height");
            ArrayList tipoPeso = (ArrayList) appearance.get("weight");
            dto.setAltura((String) tipoAltura.get(1));
            dto.setPeso((String) tipoPeso.get(1));

            LinkedHashMap powerStats = (LinkedHashMap) result.get("powerstats");
            dto.setInteligencia((String) powerStats.get("intelligence"));
            dto.setForca((String) powerStats.get("strength"));
            dto.setVelocidade((String) powerStats.get("speed"));
            dto.setResistencia((String) powerStats.get("durability"));
            dto.setPoder((String) powerStats.get("power"));
            dto.setCombate((String) powerStats.get("combat"));

            return dto;
        }catch (Exception e){
            return new HeroiDto();
        }
    }

}
