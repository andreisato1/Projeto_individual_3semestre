package school.sptech.projeto_pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<List<Pet>> listar() {
        String sql = "SELECT * FROM pet;";
        List<Pet> petsDoBanco = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pet.class));
        return ResponseEntity.status(200).body(petsDoBanco);

    }



}

