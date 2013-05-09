package framework.core.data.tag.facelets;

public class View
{
	public String locale;// O local da view.
	public String renderKitId;// (JSF 1.2) The render kit ID for this view
	public String beforePhase;
	public String afterPhase;// Phase listeners that are called in every phase
								// except "restore view"
}
