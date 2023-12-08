package model;

import java.io.Serializable;
import java.util.*;

public class Turma implements Serializable {
    private int idTurma;
    private String serie;
    private int anoLetivo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma turma)) return false;
        return anoLetivo == turma.anoLetivo && Objects.equals(serie, turma.serie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serie, anoLetivo);
    }

    public Turma(int idTurma, String serie, int anoLetivo) {
        this.idTurma = idTurma;
        this.serie = serie;
        this.anoLetivo = anoLetivo;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "idTurma=" + idTurma +
                ", serie='" + serie + '\'' +
                ", anoLetivo=" + anoLetivo +
                '}';
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

}