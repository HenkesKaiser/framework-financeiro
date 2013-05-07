package framework.core.data.tag;

public interface ISelect
{

	public String disabledClass = null; // CSS class for disabled elements—for
										// h:selectOneRadio and
										// h:selectManyCheckbox only
	public String enabledClass = null; // CSS class for enabled elements—for
										// h:selectOneRadio and
										// h:selectManyCheckbox only
	public String layout = null; // Specification for how elements are laid out:
									// lineDirection (horizontal) or
									// pageDirection (vertical)—for
									// h:selectOneRadio and h:selectManyCheckbox
									// only
	public String accesskey = null;
	public String border = null;
	public String dir = null;
	public String disabled = null;
	public String lang = null;
	public String readonly = null;
	public String style = null;
	public String size = null;
	public String tabindex = null;
	public String title = null; // HTML 4.0—border is applicable to
								// h:selectOneRadio and h:selectManyCheckbox
								// only. size is applicable to
								// h:selectOneListbox and h:selectManyListbox
								// only.

}
