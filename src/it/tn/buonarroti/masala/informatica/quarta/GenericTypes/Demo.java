package it.tn.buonarroti.masala.informatica.quarta.GenericTypes;

import lombok.Getter;
import lombok.Setter;

public class Demo<T> {
	@Getter
	@Setter
	T var1;
	T var2;
	T var3;

	public Demo(T var1, T var2, T var3) {
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}

	public String info() {
		String s = this.var1 + " " + this.var2 + " " + this.var3;
		return s;
	}
}
