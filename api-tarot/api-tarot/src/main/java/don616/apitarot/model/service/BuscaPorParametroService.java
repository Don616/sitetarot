package don616.apitarot.model.service;

import don616.apitarot.model.entity.Arcano;
import don616.apitarot.repository.ArcanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuscaPorParametroService {

    @Autowired
    ArcanoRepository arcanoRepository;

    public ResponseEntity<?> buscaParam(HashMap<String, String> param) {

        Arcano arcano = this.montarArcano(param);

        if(param.size()==1&&param.containsKey("all")){
            String valor = this.retornaValor(param);
            return this.buscaEmTudo(valor);
        }
        if(param.size()==1&&param.containsKey("nome")){
            return this.buscaPorNome(arcano);
        }
        if(param.size()==1&&param.containsKey("categoria")){
            return this.buscaPorCategoria(arcano);
        }
        if(param.size()==1&&param.containsKey("titulo")){
            return this.buscaPorTitulo(arcano);
        }
        if(param.size()==1&&param.containsKey("naipe")){
            return this.buscaPorNaipe(arcano);
        }
        if(param.size()==1&&param.containsKey("correspondenciaAstrologica")){
            return this.buscaPorCorrespondeciaAstrologica(arcano);
        }
        if(param.size()==1&&param.containsKey("letraHebraica")){
            return this.buscaPorLetraHebraica(arcano);
        }
        if(param.size()==1&&param.containsKey("runaNordica")){
            return this.buscaPorRunaNordica(arcano);
        }
        if(param.size()==2&&param.containsKey("nome")&&param.containsKey("categoria")){
            return this.buscaPorNomeEPorCategoria(arcano);
        }
        if(param.size()==2&&param.containsKey("correspondenciaAstrologica")&&param.containsKey("categoria")){
            return this.buscaPorCorrespondeciaAstrologicaEPorCategoria(arcano);
        }
        if(param.size()==2&&param.containsKey("correspondenciaAstrologica")&&param.containsKey("naipe")){
            return this.buscaPorCorrespondeciaAstrologicaEPorNaipe(arcano);
        }


        return ResponseEntity.status(400).build();
    }




    private ResponseEntity<?> buscaPorCorrespondeciaAstrologicaEPorNaipe(Arcano arcano) {

        List<Arcano> lista = arcanoRepository
                .findByCorrespondenciaAstrologicaContainsAndNaipeContains
                        (arcano.getCorrespondenciaAstrologica(),arcano.getNaipe());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorCorrespondeciaAstrologicaEPorCategoria(Arcano arcano) {

        List<Arcano> lista = arcanoRepository
                .findByCorrespondenciaAstrologicaContainsAndCategoriaContains
                        (arcano.getCorrespondenciaAstrologica(),arcano.getCategoria());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();

    }

    private ResponseEntity<?> buscaPorRunaNordica(Arcano arcano) {
        List<Arcano> lista = arcanoRepository
                .findByRunaNordicaContains(arcano.getRunaNordica());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorLetraHebraica(Arcano arcano) {
        List<Arcano> lista = arcanoRepository
                .findByLetraHebraicaContains(arcano.getLetraHebraica());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorCorrespondeciaAstrologica(Arcano arcano) {
        List<Arcano> lista = arcanoRepository
                .findByCorrespondenciaAstrologicaContains(arcano.getCorrespondenciaAstrologica());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorNaipe(Arcano arcano) {
        List<Arcano> lista = arcanoRepository
                .findByNaipeContains(arcano.getNaipe());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorNomeEPorCategoria(Arcano arcano) {

        List<Arcano> lista = arcanoRepository
                .findByNomeContainsAndCategoriaContains(arcano.getNome(),arcano.getCategoria());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();

    }


    private ResponseEntity<?> buscaPorCategoria(Arcano arcano) {
            List<Arcano> lista = arcanoRepository
                    .findByCategoriaContains(arcano.getCategoria());
            if (!lista.isEmpty()) {
                return ResponseEntity.status(200).body(lista);
            }
            return ResponseEntity.status(404).build();


    }

    private ResponseEntity<?> buscaPorTitulo(Arcano arcano) {

        List<Arcano> lista = arcanoRepository
                .findByTituloContains(arcano.getTitulo());
        if(!lista.isEmpty()){
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();

    }

    public ResponseEntity<?> buscaPorNome(Arcano arcano){

            List<Arcano> lista = arcanoRepository
                    .findByNomeContains(arcano.getNome());
            if(!lista.isEmpty()){
                return ResponseEntity.status(200).body(lista);
            }
            return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaEmTudo(String value) {
        List<Arcano> lista = arcanoRepository
                .findAll(value);
        if(!lista.isEmpty()){
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    public Arcano montarArcano(HashMap<String, String> param){

        Arcano arcanoParam = new Arcano();
        for(Map.Entry<String,String> entrada : param.entrySet()){

            if(entrada.getKey().equalsIgnoreCase("nome")){
                arcanoParam.setNome(entrada.getValue());
            }
            if(entrada.getKey().equalsIgnoreCase("categoria")){
                arcanoParam.setCategoria(entrada.getValue());
            }
            if(entrada.getKey().equalsIgnoreCase("titulo")){
                arcanoParam.setTitulo(entrada.getValue());
            }
            if(entrada.getKey().equalsIgnoreCase("naipe")){
                arcanoParam.setNaipe(entrada.getValue());
            }
            if(entrada.getKey().equalsIgnoreCase("correspondenciaAstrologica")) {
                arcanoParam.setCorrespondenciaAstrologica(entrada.getValue());
            }
            if(entrada.getKey().equalsIgnoreCase("letraHebraica")){
                arcanoParam.setLetraHebraica(entrada.getValue());
            }
            if(entrada.getKey().equalsIgnoreCase("runaNordica")){
                arcanoParam.setRunaNordica(entrada.getValue());
            }

        }

        return arcanoParam;
    }

    private String retornaValor(HashMap<String, String> param) {

        for(Map.Entry<String,String> entrada : param.entrySet()){
            return entrada.getValue();
        }
        return null;
    }

}

