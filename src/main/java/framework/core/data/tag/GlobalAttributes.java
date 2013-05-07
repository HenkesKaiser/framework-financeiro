package framework.core.data.tag;

public class GlobalAttributes
{

	public String id; // A (25) Identifier for a component
	public String binding; // A (25) Reference to the component that can be used
							// in a backing bean
	public String rendered; // A (25) A boolean; false suppresses rendering
	public String styleClass; // A (23) Cascading stylesheet (CSS) class name
	public String value; // I, O, C (19) A component’s value, typically a value
							// binding
	public String valueChangeListener; // I (11) A method binding to a method
										// that responds to value changes
	public String converter;// I, O (15) Converter class name
	public String validator; // I (11) Class name of a validator that’s created
								// and attached to a component
	public String required; //

}
