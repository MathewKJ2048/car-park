public class Ticket.java{
	public static void main(String[] args) {
		
	}



	public static void issue_ticket(){

		Hashmap <String,Integer> hm = new Hashmap<>();

		hm.put("F1SE", 5);
		hm.put("F2ME", 4);
		hm.put("F3LE", 3);
		hm.put("F2SE", 2);
		hm.put("F1SN", 1);


		// initial values in the hashmap to be filled up by the manager
		// indices: F1ME thus there will be n*3*2 = 6n keys


		String s//has the type: S, M or L.
		String form="F";
		for(int i=1;i<=n;i++)
		{
			form+=i.toString();
			form+=s;
			System.out.println(form);
			if(hm[form])
				hm.replace("form",hm[form]-1);
		}

	}
}