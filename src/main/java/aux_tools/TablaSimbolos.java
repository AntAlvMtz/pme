/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aux_tools;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author turis
 */
public class TablaSimbolos {
     public ArrayList<Simbolo> ListaTokens;

    public TablaSimbolos() {
        this.ListaTokens = new ArrayList<Simbolo>();
    }

    public void addToken(Simbolo t) {
        if (!buscarToken(t)) {
            this.ListaTokens.add(t);
            sortTabla();
        }
    }
    public void updateToken(Simbolo t) {
        if (buscarToken(t)) {
            ubicarToken(t.getLexema(), t.getTipo(), t.getValor());
            sortTabla();
        }
    }

    public void sortTabla() {
        Collections.sort(ListaTokens);
    }
    public void clear(){
        this.ListaTokens.clear();
    }

    public Boolean buscarToken(Simbolo t) {
        if(this.ListaTokens.isEmpty()){
            return false;
        }
        for (Simbolo tokens : this.ListaTokens) {
            if (tokens.getLexema().equals(t.getLexema())) {
                return true;
            }
        }
        return false;
    }
    public Boolean existeToken(String t) {
        if(this.ListaTokens.isEmpty()){
            return false;
        }
        for (Simbolo tokens : this.ListaTokens) {
            if (tokens.getLexema().equals(t)) {
                return true;
            }
        }
        return false;
    }
    public Simbolo getToken(String t) {
        if(this.ListaTokens.isEmpty()){
            return null;
        }
        for (Simbolo tokens : this.ListaTokens) {
            if (tokens.getLexema().equals(t)) {
                return tokens;
            }
        }
        return null;
    }
    public void ubicarToken(String t,String tipo) {
        if(this.ListaTokens.isEmpty()){
            return;
        }
        for (int l = 0; l < ListaTokens.size();l++) {
            if (ListaTokens.get(l).getLexema().equals(t)) {
                ListaTokens.get(l).setTipo(tipo);
            }
        }
    }
    public void ubicarToken(String t,String tipo,Object valor) {
        if(this.ListaTokens.isEmpty()){
            return;
        }
        for (int l = 0; l < ListaTokens.size();l++) {
            if (ListaTokens.get(l).getLexema().equals(t)) {
                ListaTokens.get(l).setTipo(tipo);
                ListaTokens.get(l).setValor(valor);
                
            }
        }
    }
    public ArrayList<Simbolo> verTablaSimbolos(){
        return this.ListaTokens;
    }
}
