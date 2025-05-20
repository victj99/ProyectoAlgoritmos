package utils;

import java.util.Objects;

public class ListItem2 {

    String valor;
    String texto;

    public ListItem2(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    // sobreescribimos el toString porque el jCombobox y el jList llaman al toString por debajo
    @Override
    public String toString() {
        return texto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListItem2 listItem) {
            return listItem.getValor().equals(valor);
        }

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    public String getValor() {
        return valor;
    }

    public String getTexto() {
        return texto;
    }

}
