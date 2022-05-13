package tacos.api;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.data.OrderRepository;
import tacos.data.TacoRepository;
import tacos.model.Taco;
import tacos.model.TacoOrder;

import java.util.Optional;

/*tells Spring that all handler methods in the controller should have their return
value written directly to the body of the response, rather than being carried in the
model to a view for rendering.*/
@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoController {

    private TacoRepository tacoRepository;

    public TacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(params="recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());

        return tacoRepository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        return optionalTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }

    @PutMapping(path="/{tacoId}", consumes="application/json")
    public Taco putTaco(@PathVariable("oId") Long id, @RequestBody Taco taco) {
        taco.setId(id);
        return tacoRepository.save(taco);
    }

    @DeleteMapping("/{tacoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaco(@PathVariable("id") Long id) {
        try {
            tacoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {}

    }

}
