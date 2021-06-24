/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.TrayIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.Artigos;
import model.Conexao;

/**
 *
 * @author Eduardo Henrique
 */
public class ConexaoMySQL {
    private Conexao conexao = null;
    public static Connection connection = null;
    
    public ConexaoMySQL(Conexao conexao){
        this.conexao = conexao;
    }
    
    public boolean Conectar(){
        if(conexao != null){
            try{                       
                String url = "jdbc:mysql://" + conexao.getHost() + ":" + conexao.getPort() + "/" + conexao.getBanco();
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url,conexao.getUser(),conexao.getPass());
                return true;
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Erro ao conectar: " + ex.getMessage(), "Erro na conexão com o banco de dados.", JOptionPane.WARNING_MESSAGE);
                return false;
            }                    
        }else
            return false;
    }
    
    public Artigos buscarArtigo(Integer codAnt, Integer operacao){
        Artigos artigo = new Artigos();
        String sql = "";
        String op = "";
        String ordenacao = "";
        ResultSet res = null;
        Statement st = null;
        switch(operacao){
            case 0: 
                op = ">"; 
                ordenacao = " order by id asc ";
                break;
            case 1: 
                op = "<"; 
                ordenacao = " order by id desc ";
                break;
        }
        try{
            sql = "SELECT * FROM artigos WHERE id " + op + " " + codAnt + ordenacao + " limit 1";
            st = connection.createStatement();
            res = st.executeQuery(sql);
            if(res != null){
                while (res.next()){
                    artigo.setId(Integer.parseInt(res.getString("id")));
                    artigo.setRepositorio(res.getString("repositorio"));
                    artigo.setArtigo(res.getString("titulo"));
                    artigo.setAutores(res.getString("autores"));
                    artigo.setAno(Integer.parseInt(res.getString("ano")));
                    artigo.setPalavrasChaves(res.getString("palavrachave"));
                    artigo.setDoi(res.getString("doi"));
                    artigo.setIntroducao(res.getString("introducao"));
                    artigo.setConclusao(res.getString("conclusao"));
                    artigo.setIntroducao_pt(res.getString("introducao_pt"));
                    artigo.setConclusao_pt(res.getString("conclusao_pt"));
                }
            }
        }catch(NumberFormatException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados: " + ex.getMessage(), "Erro ao buscar dados no banco de dados.", JOptionPane.WARNING_MESSAGE);
            artigo = null;
        }
        return artigo;
    }
    
    public boolean Insert(Artigos artigos){
        PreparedStatement stmt = null;
        try{
            //inserindo o comando SQL:
            stmt = connection.prepareStatement("INSERT INTO artigos(id_projeto, repositorio, titulo, autores, ano, palavrachave, doi, h5, CI01, CI02, CI03, CE01, CE02, CE03, CE04, CE05, introducao, conclusao, situacao, introducao_pt, conclusao_pt)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, 1);
            stmt.setString(2, artigos.getRepositorio());
            stmt.setString(3, artigos.getArtigo());
            stmt.setString(4, artigos.getAutores());
            stmt.setInt(5, artigos.getAno());
            stmt.setString(6, artigos.getPalavrasChaves());
            stmt.setString(7, artigos.getDoi());
            stmt.setInt(8, 999);
            stmt.setInt(9, 1);
            stmt.setInt(10, 1);
            stmt.setInt(11, 1);
            stmt.setInt(12, 0);
            stmt.setInt(13, 0);
            stmt.setInt(14, 0);
            stmt.setInt(15, 0);
            stmt.setInt(16, 0);
            stmt.setString(17, artigos.getIntroducao());
            stmt.setString(18, artigos.getConclusao());
            stmt.setInt(19, 1);
            stmt.setString(20, artigos.getIntroducao_pt());
            stmt.setString(21, artigos.getConclusao_pt());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + ex.getMessage(), "Erro ao gravar dados no banco de dados.", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
}
