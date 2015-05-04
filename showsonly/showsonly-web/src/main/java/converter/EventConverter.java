package converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import mBeans.AdminShowBean;
import domain.Event;



import services.interfaces.EventManagementLocal;




@ManagedBean(name="ec")
public class EventConverter implements Converter {

	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
	
		if (string == null) {
			return null;
		}
		else 
			{AdminShowBean adminshowbean = (AdminShowBean) context.getApplication()
				.evaluateExpressionGet(context, "#{AdminShowBean}",
						AdminShowBean.class);
		
		Event event = adminshowbean.doFindEventByName("test");
		return event;}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		String string = null;
		if (object instanceof Event) {
			string = ((Event) object).getName();

		}
		return string;
	}

}
