/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Eduardo Henrique
 */
public class Artigos {
    private Integer id;
    private String repositorio;
    private String artigo;
    private String autores;
    private Integer ano;
    private String palavrasChaves;
    private String doi;
    private String introducao;
    private String conclusao;
    private String introducao_pt;
    private String conclusao_pt;
    
    public Artigos(){
        this.id = 0;
        this.repositorio = "";
        this.artigo = "";
        this.autores = "";
        this.ano = 2021;
        this.palavrasChaves = "";
        this.doi = "";
        this.introducao = "";
        this.conclusao = "";
        this.introducao_pt = "";
        this.conclusao_pt = "";
    }

    public Artigos(String repositorio, String artigo, String autores, Integer ano, String palavrasChaves, String doi, String introducao, String conclusao, String introducao_pt, String conclusao_pt) {
        this.repositorio = repositorio;
        this.artigo = artigo;
        this.autores = autores;
        this.ano = ano;
        this.palavrasChaves = palavrasChaves;
        this.doi = doi;
        this.introducao = introducao;
        this.conclusao = conclusao;
        this.id = 0;
        this.introducao_pt = introducao_pt;
        this.conclusao_pt = conclusao_pt;
    }

    public String getIntroducao_pt() {
        return introducao_pt;
    }

    public void setIntroducao_pt(String introducao_pt) {
        this.introducao_pt = introducao_pt;
    }

    public String getConclusao_pt() {
        return conclusao_pt;
    }

    public void setConclusao_pt(String conclusao_pt) {
        this.conclusao_pt = conclusao_pt;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }

    public String getArtigo() {
        return artigo;
    }

    public void setArtigo(String artigo) {
        this.artigo = artigo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getIntroducao() {
        return introducao;
    }

    public void setIntroducao(String introducao) {
        this.introducao = introducao;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artigos other = (Artigos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Artigos{" + "id=" + id + "\n repositorio=" + repositorio + "\n artigo=" + artigo + "\n autores=" + autores + "\n ano=" + ano + "\n palavrasChaves=" + palavrasChaves + "\n doi=" + doi + "\n introducao=" + introducao + "\n conclusao=" + conclusao + '}';
    }
    
    
}
