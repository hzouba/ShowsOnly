package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import mBeans.AdminShowBean;
import domain.Event;

@FacesConverter("ec")
public class EventConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null) {
			return null;
		}
		AdminShowBean adminshowbean = (AdminShowBean) context.getApplication()
				.evaluateExpressionGet(context, "#{AdminShowBean}",
						AdminShowBean.class);
		Event event = adminshowbean.doFindEventByName(string);
		return event;
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
