package com.project.mini;


import java.util.Objects;

public class Mini {

	// 필드
	private String name;
	private String ph;
	private String company;

	// 생성자
	public Mini(String name, String ph, String company) {
		super();
		this.name = name;
		this.ph = ph;
		this.company = company;
	}

	// 메소드 g,s
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// 메소드 일반
	@Override
	public String toString() {
		return "Mini [name=" + name + ", ph=" + ph + ", company=" + company + "]";
	}
	// 화면에 출력하기
	public void showinfo() {
		System.out.println(name + "  " + ph + "  " + company);
	}
	// 파일로 내보내기
	public String printout() {
		return name + "," + ph + "," + company;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mini other = (Mini) obj;
		return Objects.equals(name, other.name);
	}

}
