package don616.apitarot.service;

import don616.apitarot.entity.ArcanoEntity;
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

        ArcanoEntity arcano = this.montarArcano(param);


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




    private ResponseEntity<?> buscaPorCorrespondeciaAstrologicaEPorNaipe(ArcanoEntity arcano) {

        List<ArcanoEntity> lista = arcanoRepository
                .findByCorrespondenciaAstrologicaContainsAndNaipeContains
                        (arcano.getCorrespondenciaAstrologica(),arcano.getNaipe());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorCorrespondeciaAstrologicaEPorCategoria(ArcanoEntity arcano) {

        List<ArcanoEntity> lista = arcanoRepository
                .findByCorrespondenciaAstrologicaContainsAndCategoriaContains
                        (arcano.getCorrespondenciaAstrologica(),arcano.getCategoria());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();

    }

    private ResponseEntity<?> buscaPorRunaNordica(ArcanoEntity arcano) {
        List<ArcanoEntity> lista = arcanoRepository
                .findByRunaNordicaContains(arcano.getRunaNordica());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorLetraHebraica(ArcanoEntity arcano) {
        List<ArcanoEntity> lista = arcanoRepository
                .findByLetraHebraicaContains(arcano.getLetraHebraica());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorCorrespondeciaAstrologica(ArcanoEntity arcano) {
        List<ArcanoEntity> lista = arcanoRepository
                .findByCorrespondenciaAstrologicaContains(arcano.getCorrespondenciaAstrologica());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorNaipe(ArcanoEntity arcano) {
        List<ArcanoEntity> lista = arcanoRepository
                .findByNaipeContains(arcano.getNaipe());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();
    }

    private ResponseEntity<?> buscaPorNomeEPorCategoria(ArcanoEntity arcano) {

        List<ArcanoEntity> lista = arcanoRepository
                .findByNomeContainsAndCategoriaContains(arcano.getNome(),arcano.getCategoria());
        if (!lista.isEmpty()) {
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();

    }


    private ResponseEntity<?> buscaPorCategoria(ArcanoEntity arcano) {
            List<ArcanoEntity> lista = arcanoRepository
                    .findByCategoriaContains(arcano.getCategoria());
            if (!lista.isEmpty()) {
                return ResponseEntity.status(200).body(lista);
            }
            return ResponseEntity.status(404).build();


    }

    private ResponseEntity<?> buscaPorTitulo(ArcanoEntity arcano) {

        List<ArcanoEntity> lista = arcanoRepository
                .findByTituloContains(arcano.getTitulo());
        if(!lista.isEmpty()){
            return ResponseEntity.status(200).body(lista);
        }
        return ResponseEntity.status(404).build();

    }

    public ResponseEntity<?> buscaPorNome(ArcanoEntity arcano){

            List<ArcanoEntity> lista = arcanoRepository
                    .findByNomeContains(arcano.getNome());
            if(!lista.isEmpty()){
                return ResponseEntity.status(200).body(lista);
            }
            return ResponseEntity.status(404).build();
    }



    public ArcanoEntity montarArcano(HashMap<String, String> param){

        ArcanoEntity arcanoParam = new ArcanoEntity();
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

