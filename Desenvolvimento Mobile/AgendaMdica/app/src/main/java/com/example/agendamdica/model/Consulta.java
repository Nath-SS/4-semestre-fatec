package com.example.agendamdica.model;


public class Consulta {

    private int id;
    private String CPF;
    private String paciente;
    private String especialidade;
    private String medico;
    private String data;
    private String horario;

    public Consulta(){

    }

    public Consulta(int id, String CPF, String paciente, String especialidade, String medico, String data, String horario) {
        this.id = id;
        this.CPF = CPF;
        this.paciente = paciente;
        this.especialidade = especialidade;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
