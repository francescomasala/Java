package it.tn.buonarroti.masala.quarta.HashTable;
import java.time.LocalDate;

public class PersonaHT {
    private String nome;
    private String dataDiNascita;

    public PersonaHT(String nome, String dataDiNascita) {
        this.nome = nome;
        this.dataDiNascita = dataDiNascita;
    }

    public PersonaHT(PersonaHT personaHT) {
        this.dataDiNascita = personaHT.getDataDiNascita();
        this.nome = personaHT.getNome();
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) throws Exception {
        this.dataDiNascita = dataDiNascita;
        try {
            int day = Integer.parseInt(dataDiNascita.substring(0, 1));
            int month = Integer.parseInt(dataDiNascita.substring(3, 4));
            int year = Integer.parseInt(dataDiNascita.substring(6, 10));
            LocalDate ld = LocalDate.of(year, month, day);
            this.dataDiNascita = ld.toString();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return (this.nome + " " + this.dataDiNascita);
    }

}
