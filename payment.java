

class Payment
{
	private final String source;
	private final String recipient;
	private final double number;
	private final String currency;
	private final String method;
	public Payment(String source,String recipient,double number,String currency,String method)
	{
		this.source = source;
		this.recipient = recipient;
		this.number = number;
		this.currency = currency;
		this.method = method;
	}
	
	public String getSource()
	{
		return source;
	}
	public String getRecipient()
	{
		return recipient;
	}
	public double getNumber()
	{
		return number;
	}
	public String getCurrency()
	{
		return currency;
	}
	public String getMethod()
	{
		return method;
	}
}
















