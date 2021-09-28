class Payment
{
	private final String source;
	private final String recipient;
	private final double number;
	private final String currency;
	private final String method;
	private final String code;
	private final long time;
	public Payment(String source,String recipient,double number,String currency,String method,String code)
	{
		this.source = source;
		this.recipient = recipient;
		this.number = number;
		this.currency = currency;
		this.method = method;
		this.code = code;
		this.time = System.currentTimeMillis();
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
	public long getTime()
	{
	    return this.time;
        }
}
