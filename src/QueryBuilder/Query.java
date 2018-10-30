package QueryBuilder;

public class Query {
	private String select = null;
	private String from = null;
	private String where = null;
	private String orderBy = null;
	
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

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public void print(){
		System.out.println("select "+select+" from "+from+" where "+where+" order by"+orderBy);
	}
}
