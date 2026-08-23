package school.sptech.projeto_pets;

import java.time.LocalDate;

public class Pet {

    private Integer id;
    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;
    private SexoAnimal sexo;

    public Pet() {
    }

    public Pet(Integer id, String nome, Integer idade, LocalDate dataNascimento, SexoAnimal sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public SexoAnimal getSexo() {
        return sexo;
    }

    public void setSexo(SexoAnimal sexo) {
        this.sexo = sexo;
    }
}
