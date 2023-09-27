package com.example.prepratica.Controller;
import com.example.prepratica.Model.XPTO;
import com.example.prepratica.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto") //api/tabela
public class Controller {

    private ProdRepository popopo ; //prodRepository
    @Autowired
    public Controller(ProdRepository popopo){
        this.popopo = popopo;
    }

    @GetMapping("/selecionarProd")
    public List<XPTO> seleciona(){
        return popopo.findAll();
    }

    @PostMapping("/postar")
    public ResponseEntity<String> inserir(@RequestBody XPTO body){
        try {
            popopo.save(body);
            return ResponseEntity.ok("deu certo");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Deu erro");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> alterar(@PathVariable Long id, @RequestBody XPTO body){
        Optional<XPTO> xxpto = popopo.findById(id);
        if(xxpto.isPresent()){
            XPTO ptox = xxpto.get();
            ptox.setNome(body.getNome());
            ptox.setDesc(body.getDesc());
            ptox.setPreco(body.getPreco());
            ptox.setQntEstroque(body.getQntEstroque());
            popopo.save(ptox);
            return ResponseEntity.ok("deu certo");
        }
        return ResponseEntity.badRequest().body("Deu erro");
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deleta(@PathVariable Long id){
        Optional<XPTO> xxpto = popopo.findById(id);
        if(xxpto.isPresent()){
           popopo.deleteById(id);
            return ResponseEntity.ok("deu certo");
        }
        return ResponseEntity.badRequest().body("Deu erro");
    }

    @GetMapping("/selecionar/{id}")
    public Optional<XPTO> selecionarID(@PathVariable Long id){
        return popopo.findById(id);
    }

    @GetMapping("/selecionarNome/{name}")
    public List<XPTO> selecionarNome(@PathVariable String name){
        return popopo.findByNome(name);
    }

}
