package QueryBuilder;

public class Query {
	private String select = null;
	private String from = null;

	
	public String getSelect(){
		return select;
	}
	
	public void setSelect(String select){
		this.select=select;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}


	
	public String print(){
		return ("select "+select+" from "+from);
	}
}
