package school.sptech.projeto_pets;

import java.time.LocalDate;

public class Pet {


    private Integer id;
    private String nome;
    private Integer peso;
    private LocalDate dataNascimento;
    private String sexo;

    public Pet() {
    }

    public Pet(Integer id, String nome, Integer peso, LocalDate dataNascimento, String sexo) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
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

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
