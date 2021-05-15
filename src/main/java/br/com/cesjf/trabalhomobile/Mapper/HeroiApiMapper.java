package br.com.cesjf.trabalhomobile.Mapper;

import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class HeroiApiMapper {

    public static List<HeroiDto> mapper(LinkedHashMap raw){
        ArrayList<LinkedHashMap> hash = (ArrayList) raw.get("results");
        List<HeroiDto> lista = new ArrayList<>();
        try {
            hash.stream().forEach( obj -> {
                HeroiDto dto = new HeroiDto();
                dto.setIdApi((String) obj.get("id"));
                dto.setNome((String) obj.get("name"));

                LinkedHashMap biography = (LinkedHashMap) obj.get("biography");
                dto.setAlterEgo((String) biography.get("full-name"));

                LinkedHashMap image = (LinkedHashMap) obj.get("image");
                dto.setUrlImagem((String) image.get("url"));

                LinkedHashMap appearance = (LinkedHashMap) obj.get("appearance");
                ArrayList tipoAltura = (ArrayList) appearance.get("height");
                ArrayList tipoPeso = (ArrayList) appearance.get("weight");
                dto.setAltura((String) tipoAltura.get(1));
                dto.setPeso((String) tipoPeso.get(1));

                LinkedHashMap powerStats = (LinkedHashMap) obj.get("powerstats");
                dto.setInteligencia((String) powerStats.get("intelligence"));
                dto.setForca((String) powerStats.get("strength"));
                dto.setVelocidade((String) powerStats.get("speed"));
                dto.setResistencia((String) powerStats.get("durability"));
                dto.setPoder((String) powerStats.get("power"));
                dto.setCombate((String) powerStats.get("combat"));

                lista.add(dto);
            });
        }catch (Exception e){
            return new ArrayList<>();
        }
        return lista;
    }

}
