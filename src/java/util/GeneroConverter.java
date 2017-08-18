package util;

import dao.GeneroDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Genero;

@FacesConverter(value = "generoConverter", forClass = Genero.class)
public class GeneroConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Genero temp = null;
        GeneroDao dao = new GeneroDao();
        try {
            nome = value;
            temp = dao.buscarPorNome(nome);
	} catch (Exception e) {
            System.out.println("Erro converter: "+e.toString());
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null){
            return " ";
        }
        if (obj instanceof Genero){
            Genero ar = (Genero)obj;
            return ar.getNome();
        }
        return "";
    }
}
