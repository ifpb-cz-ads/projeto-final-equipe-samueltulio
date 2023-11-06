package model.Model;

import java.util.Date;

public class Pessoa {
   private String email;
   private String nome;
   private String cpf;
   private String matricula;
   private Date dataNascimento;

   public Pessoa(String email, String nome, String cpf, String matricula, Date dataNascimento) {
      this.email = email;
      this.nome = nome;
      this.cpf = cpf;
      this.matricula = matricula;
      this.dataNascimento = dataNascimento;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCpf() {
      return cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public String getMatricula() {
      return matricula;
   }

   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   public Date getDataNascimento() {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento) {
      this.dataNascimento = dataNascimento;
   }
}
