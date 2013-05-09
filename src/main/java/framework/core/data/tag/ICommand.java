package framework.core.data.tag;

public interface ICommand
{
	public String action = null; // If specified as a string: Directly specifies
									// an outcome used by the navigation handler
									// to determine the JSF page to load next as
									// a result of activating the button or link
									// If specified as a method binding: The
									// method has this signature: String
									// methodName(); the string represents the
									// outcome
	public String actionListener = null; // A method binding that refers to a
											// method with this signature: void
											// methodName(ActionEvent)
	public String charset = null;// For h:commandLink only—The character
									// encoding of the linked reference
	public String image = null; // For h:commandButton only—A context-relative
								// path to an image displayed in a button. If
								// you specify this attribute, the HTML input’s
								// type will be image.
	public String immediate = null; // A boolean. If false (the default),
									// actions and action listeners are invoked
									// at the end of the request life cycle; if
									// true, actions and action listeners are
									// invoked at the beginning of the life
									// cycle. See Chapter 6 for more information
									// about the immediate attribute.
	public String type = null;// For h:commandButton: The type of the generated
								// input element: button, submit, or reset. The
								// default, unless you specify the image
								// attribute, is submit. For h:commandLink: The
								// content type of the linked resource; for
								// example, text/html, image/gif, or audio/basic
	public String value = null; // The label displayed by the button or link.
								// You can specify a string or a value reference
								// expression.

}
