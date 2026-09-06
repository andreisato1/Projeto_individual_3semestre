package school.sptech.projeto_pets;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pets")
public class PetController {

    private final JdbcTemplate jdbcTemplate;

    public PetController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listarPets() {

        String sql = "SELECT * FROM pet;";
        List<Pet> pets = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pet.class));
        return ResponseEntity.status(200).body(pets);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> listarPorId(@PathVariable Integer id) {

        String sql = "SELECT * FROM pet WHERE id = ?";

        try {

            Pet pet = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Pet.class), id);

            return ResponseEntity.status(200).body(pet);

        } catch (EmptyResultDataAccessException e) {

            return ResponseEntity.status(404).build();

        }

    }

    @PostMapping
    public ResponseEntity<Pet> inserirPet(@RequestBody Pet petParaAdicionar) {

        if(petParaAdicionar.getNome() == null
                || petParaAdicionar.getNome().isBlank()
                || petParaAdicionar.getNome().length() > 50
                || petParaAdicionar.getPeso() == null
                || petParaAdicionar.getPeso() < 0
                || petParaAdicionar.getDataNascimento() == null
                || petParaAdicionar.getDataNascimento().isAfter(LocalDate.now())
                || petParaAdicionar.getSexo() == null
                || (!petParaAdicionar.getSexo().equals("Macho") && !petParaAdicionar.getSexo().equals("Fêmea"))
                || petParaAdicionar.getSexo().isBlank()){

            return ResponseEntity.status(400).build();

        }

        String sql = "INSERT INTO pet(nome, peso, data_nascimento, sexo) VALUES (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, petParaAdicionar.getNome());
            ps.setInt(2, petParaAdicionar.getPeso());
            ps.setObject(3, petParaAdicionar.getDataNascimento());
            ps.setString(4, petParaAdicionar.getSexo());

            return ps;

        }, keyHolder);

        Integer idGerado = keyHolder.getKeyAs(Integer.class);
        petParaAdicionar.setId(idGerado);

        return ResponseEntity.status(201).body(petParaAdicionar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizarPorId(@PathVariable Integer id, @RequestBody Pet petParaAtualizar) {

        if(!existeId(id)) {

            return ResponseEntity.status(404).build();

        }

        if(petParaAtualizar.getNome() == null
                || petParaAtualizar.getNome().isBlank()
                || petParaAtualizar.getNome().length() > 50
                || petParaAtualizar.getPeso() == null
                || petParaAtualizar.getPeso() < 0
                || petParaAtualizar.getDataNascimento() == null
                || petParaAtualizar.getDataNascimento().isAfter(LocalDate.now())
                || petParaAtualizar.getSexo() == null
                || (!petParaAtualizar.getSexo().equals("Macho") && !petParaAtualizar.getSexo().equals("Fêmea"))
                || petParaAtualizar.getSexo().isBlank()){

            return ResponseEntity.status(400).build();

        }

        String sql = "UPDATE pet SET nome = ?, peso = ?, data_nascimento = ?, sexo = ? WHERE id = ?";

        jdbcTemplate.update(con -> {PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, petParaAtualizar.getNome());
            ps.setInt(2, petParaAtualizar.getPeso());
            ps.setObject(3, petParaAtualizar.getDataNascimento());
            ps.setString(4, petParaAtualizar.getSexo());
            ps.setInt(5, id);

            return ps;
        });

        petParaAtualizar.setId(id);

        return ResponseEntity.status(200).body(petParaAtualizar);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {

        if(!existeId(id)) {

            return ResponseEntity.status(404).build();

        }

        String sql = "DELETE FROM pet WHERE id = ?";
        jdbcTemplate.update(sql, id);

        return ResponseEntity.status(204).build();

    }

    private Boolean existeId(Integer id) {

        String sqlExistePorId = "SELECT COUNT(*) FROM pet WHERE id = ?";
        Integer countId = jdbcTemplate.queryForObject(sqlExistePorId, Integer.class, id);

        Boolean existePorId = countId == 1;
        return existePorId;
    }

}
