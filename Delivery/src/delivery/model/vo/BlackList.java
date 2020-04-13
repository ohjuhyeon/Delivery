package delivery.model.vo;

public class BlackList {

	private String strId;
	private String keyword;
	private int blNo;

	public BlackList() {
	}

	public BlackList(String strId, String keyword, int blNo) {
		super();
		this.strId = strId;
		this.keyword = keyword;
		this.blNo = blNo;
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getBlNo() {
		return blNo;
	}

	public void setBlNo(int blNo) {
		this.blNo = blNo;
	}

	@Override
	public String toString() {
		return this.strId + " , " + this.keyword + " , " + this.blNo;
	}

}
