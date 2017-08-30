package util;

import dao.EspecieDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Especie;

@FacesConverter(value = "especieConverter", forClass = Especie.class)
public class EspecieConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Especie temp = null;
        EspecieDao dao = new EspecieDao();
        try {
            nome = value;
            temp = dao.buscarPorNome(nome);
        } catch (Exception e) {
            System.out.println("Erro converter: " + e.toString());
        }
        return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null) {
            return " ";
        }
        if (obj instanceof Especie) {
            Especie ar = (Especie) obj;
            return ar.getNome();
        }
        return "";
    }
}
