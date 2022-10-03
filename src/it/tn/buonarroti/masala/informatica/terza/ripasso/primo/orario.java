package it.tn.buonarroti.masala.informatica.terza.ripasso.primo;

public class orario {
	private Integer SS;
	private Integer MM;
	private Integer HH;

	public orario() {
		this.SS = 0;
		this.MM = 0;
		this.HH = 0;

	}

	public orario(Integer HH, Integer MM, Integer SS) {
		this.SS = SS;
		this.MM = MM;
		this.HH = HH;
	}

	public void AddSS(Integer New_Sec) {

		this.SS = this.SS + New_Sec;

	}

	public void AddMM(Integer New_Min) {

		this.MM = this.MM + New_Min;

	}

	public void AddHH(Integer New_Hour) {

		this.HH = this.HH + New_Hour;

	}

	public void RmSS(Integer New_Sec) {

		this.SS = this.SS - New_Sec;

	}

	public void RmMM(Integer New_Min) {

		this.MM = this.MM - New_Min;

	}

	public void RmHH(Integer New_Hour) {

		this.HH = this.HH - New_Hour;

	}

	public Integer ToSecFromMidnight() {
		int result;

		result = this.HH * 60;
		result = result + (this.MM * 60);
		result = result + this.SS;

		return result;
	}

	public Integer ToMinFromMidnight() {
		int result;

		result = (this.HH * 60);
		result = result + this.MM;

		if (this.SS >= 30) {
			result = result + 1;
		}

		return result;

	}

	public Integer ToHourFromMidnight() {

		Integer result;

		result = this.HH;

		if (this.MM >= 30) {
			result = result + 1;
		}

		return result;
	}

	public Integer ToSecToMidnight() {
		int result;

		result = this.ToMinToMidnight() * 60;
		result = result + (60 - this.SS);

		return result;
	}

	public Integer ToMinToMidnight() {
		int result;

		result = this.ToHourToMidnight() * 60;
		result = result + (60 - this.MM);

		return result;
	}

	public Integer ToHourToMidnight() {
		int result;

		result = 24 - this.HH;

		return result;
	}

	private void SecondsToTime(Integer sec) {
		if (sec > 86400) {
			sec -= 86400;
		}

		this.HH = sec / 3600;
		this.MM = sec / 60;
		this.SS = sec % 60;
	}

	@Override
	public String toString() {
		return this.HH + ":" + this.MM + ":" + this.SS;
	}
}
