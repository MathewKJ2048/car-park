

class payment
{
	String to;
	String from;
	String date;
	double authenticationcode;
	double numb;
	double unit;
	
	payment(String TO, String FROM,String Date,double code,double Numb,double Unit)throws Exception
	{
		to = TO;
		from = FROM;
		date = Date;
		authenticationcode = code;
		numb = Numb;
		unit = Unit;
	}
	private String source;
	private String recipient;
	private double number;
	private String currency;
	private String method;
	public void pay(String source,String recipient,double number,String currency,String method)
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
















