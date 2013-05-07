package framework.core.data.tag.facelets;

public interface IMessage
{

	public String for1 = null; // Mensagem relacionada ao componente
								// identificado
	public String errorClass = null; // CSS class aplicado ao erro "messages"
	public String errorStyle = null; // CSS style aplicado ao erro "messages"
	public String fatalClass = null;// CSS class aplicado ao fatal "messages"
	public String fatalStyle = null;// CSS style aplicado ao fatal "messages"
	public String globalOnly = null; // Instruction to display only global
										// "messages"—applicable only to
										// h:"messages". Default: false
	public String infoClass = null; // CSS class aplicado ao informação
									// "messages"
	public String infoStyle = null; // CSS style aplicado ao informação
									// "messages"
	public String layout = null; // Specification for message layout: table or
									// list—applicable only to h:"messages"
	public String showDetail = null; // A boolean that determines whether
										// message details are shown. Defaults
										// are false for h:"messages", true for
										// h:message.
	public String showSummary = null; // A boolean that determines whether
										// message summaries are shown. Defaults
										// are true for h:"messages", false for
										// h:message.
	public String tooltip = null; // A boolean that determines whether message
									// details are rendered in a tooltip; the
									// tooltip is only rendered if showDetail
									// and showSummary are true
	public String warnClass = null; // CSS class for warning "messages"
	public String warnStyle = null; // CSS style for warning "messages"
}
