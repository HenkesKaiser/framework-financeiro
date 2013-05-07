package framework.core.data.tag;

public interface IInput
{

	public static String cols = null; // For h:inputTextarea only—number of
										// columns
	public static String immediate = null; // Process validation early in the
											// life cycle
	public static String redisplay = null; // For h:inputSecret only—when true,
											// the input field’s value is
											// redisplayed when the web page is
											// reloaded
	public static String required = null; // Require input in the component when
											// the form is submitted
	public static String rows = null;// For h:inputTextarea only—number of rows
	public static String valueChangeListener = null;// A specified listener
													// that’s notified of value
													// changes

}
