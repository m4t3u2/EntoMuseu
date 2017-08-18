package util;


import dao.FamiliaDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Familia;

@FacesConverter(value = "familiaConverter", forClass = Familia.class)
public class FamiliaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Familia temp = null;
        FamiliaDao dao = new FamiliaDao();
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
        if (obj instanceof Familia){
            Familia ar = (Familia)obj;
            return ar.getNome();
        }
        return "";
    }
    
}